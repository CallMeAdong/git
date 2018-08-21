package Util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import domain.User;

public class SaleUtil {
	//获取session
	public static HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	public static User getLoginUser() {
		return (User) getSession().getAttribute("user");
		
	}
}
