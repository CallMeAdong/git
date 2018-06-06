package Action;

import com.opensymphony.xwork2.ActionSupport;

import Service.CheckImgService;

public class CheckImgAction extends ActionSupport{
	private CheckImgService checkimgservice;
	public String checkImg() {
		checkimgservice.init();
		checkimgservice.check();
		return "SUCCESS";
	}
}
