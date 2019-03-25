package cn.lijiahao.demo.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.lijiahao.demo.po.User;
import cn.lijiahao.demo.service.UserService;
/**
*
*@Description 自定义remeberMe的filter拦截器
*@author 李佳浩
*@Date 2018年10月16日 上午9:15:28
*/
@Component
public class RememberMeFilter extends FormAuthenticationFilter{
	@Autowired
	private UserService userService;
	
	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		
		Subject subject = getSubject(request, response);
		
		Session session = subject.getSession();
		//记住我过    功能isAuthenticated肯定是"flase"，而isRemembered为true
		if (!subject.isAuthenticated()&&subject.isRemembered()&&session.getAttribute("user")==null) {
			//说明是记住我功能
			Object principal = subject.getPrincipal();
			//不为空再去获取用户操作
			if (principal!=null) {
				String username = principal.toString();
				User user=null;
					user = userService.selectByUsername(username);
				session.setAttribute("user", user);
			}
		}
		
		return subject.isAuthenticated()||subject.isRemembered()||true;
	}
}
