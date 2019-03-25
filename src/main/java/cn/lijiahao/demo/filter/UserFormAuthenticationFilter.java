package cn.lijiahao.demo.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
 * @Description	重写FormAuthenticationFilter在登录认证成功时的方法，添加在认证成功时将subject存入redis缓存
 * @author 李佳浩
 * @Date 2019年2月15日 下午4:32:30
 */
public class UserFormAuthenticationFilter extends FormAuthenticationFilter{
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		System.out.println("form表单拦截器的sessionId："+subject.getSession().getId());
		return super.onLoginSuccess(token, subject, request, response);
	}
}
