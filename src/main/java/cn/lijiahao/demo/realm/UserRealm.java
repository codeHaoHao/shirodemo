package cn.lijiahao.demo.realm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.lijiahao.demo.po.Role;
import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.RoleService;
import cn.lijiahao.demo.service.UserService;

@Component
public class UserRealm extends AuthorizingRealm{
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public String getName() {
		return "userRealm";
	}

	// 支持什么类型的token
	@Override
	public boolean supports(AuthenticationToken token) {
		
		return token instanceof UsernamePasswordToken;
		
	}
	
	/**
	*
	*@Description 自定义授权方法
	*@param 
	*@author 李佳浩
	*@Date 2018年10月14日 下午12:16:34
	*/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
//      System.out.println("授权");
      SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
      /*List<String> permissions=new ArrayList<String>();*/
      List<String> roles=new ArrayList<String>();
      User activeUser= (User)token.getPrimaryPrincipal();
//      System.out.println("username"+username);
    //从数据库中查询username
      User user=null;
      user = userService.selectByUsername(activeUser.getUsername());
      List<Role> croRoleRoots=roleService.selectBysys_uid(user.getId());
      for(Role croRoleRoot:croRoleRoots){
    	  roles.add(croRoleRoot.getName());
      }
      info.addRoles(roles);//设置角色
      Set<String> set = info.getRoles();
      System.out.println(set.size());
      /*info.addStringPermissions(permissions);//设置权限*/
      return info;
	}
	/**
	*
	*@Description 自定义的认证方法
	*@param 
	*@author 李佳浩
	*@Date 2018年10月14日 下午12:15:57
	*/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//从token中获取用户身份信息
		String username = (String)token.getPrincipal();
		//System.out.println("principal:"+username);
		//从数据库中查询username
		User user=null;
			user = userService.selectByUsername(username);

		//如果查询不到则返回null
		if(user==null){ 
			throw new UnknownAccountException();
			}
		if(user.getLocked().equals("1")){
			throw new DisabledAccountException();
		}
		String password = user.getPassword();
		String salt = user.getSalt();//盐
		// 返回认证信息由父类AuthenticatingRealm进行认证
		//交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现。
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, password,ByteSource.Util.bytes(salt), getName());

		return simpleAuthenticationInfo;
	}

}
