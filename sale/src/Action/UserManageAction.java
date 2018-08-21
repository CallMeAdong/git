package Action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.UserManageService;
import domain.User;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import vo.PageBean;
@Controller
@Scope("prototype")
public class UserManageAction extends ActionSupport implements ModelDriven<User>{
	public User user = new User();
	@Autowired
	private UserManageService userManageService;
	private int page;
	private int rows;
	public String pageQuery() throws IOException {
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(page);
		System.out.println("当前页"+pageBean.getCurrentPage());
		pageBean.setPageSize(rows);
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		pageBean.setDetachedcriteria(detachedCriteria);
		userManageService.pageQuery(pageBean);
		
		//使用json-lib将PageBean对象转为json，通过输出流写回页面中
		//JSONObject---将单一对象转为json
		//JSONArray----将数组或者集合对象转为json
		JsonConfig jsonConfig = new JsonConfig();
		//指定哪些属性不需要转json
		jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
		String json = JSONObject.fromObject(pageBean,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(json);
		return null;
	}
	private String ids;
	public String deleteBatch() {
		
		userManageService.deleteBatch(ids);
		return "usermanager";
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	
}
