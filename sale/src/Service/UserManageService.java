package Service;

import vo.PageBean;

public interface UserManageService {
	 public void pageQuery(PageBean pageBean);

	public void deleteBatch(String ids); 
}
