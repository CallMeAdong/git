package Intercepter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import Util.SaleUtil;
import domain.User;

public class SaleLoginIntercepter extends MethodFilterInterceptor{
	/*
	 * 自定义登录拦截器
	 * @see com.opensymphony.xwork2.interceptor.MethodFilterInterceptor#doIntercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 从session中获得登录对象
		ActionProxy proxy = invocation.getProxy();
		String actionName = proxy.getActionName();
		String namespace = proxy.getNamespace();
		String url = namespace + actionName;
		System.out.println(url);
		User user = SaleUtil.getLoginUser();
		System.out.println(user);
		if(user==null) {
			return "TOLOGIN";
		}
		//放行
		return invocation.invoke();
	}

}
