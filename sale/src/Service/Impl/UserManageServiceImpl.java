package Service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Dao.UserManageDao;
import Service.UserManageService;
import vo.PageBean;
@Service
@Transactional
public class UserManageServiceImpl implements UserManageService{
	@Autowired
	private UserManageDao userManageDao;
	@Override
	public void pageQuery(PageBean pageBean) {
		userManageDao.pageQuery(pageBean);
		
	}
	@Override
	public void deleteBatch(String ids) {
		if(StringUtils.isNoneBlank(ids)) {
			String[] userIds = ids.split(",");
			
			for (String id : userIds) {
				
				userManageDao.executeUpdate("usermanage.delete", Integer.parseInt(id));
			}
		}
		
	}
	public void setUserManageDao(UserManageDao userManageDao) {
		this.userManageDao = userManageDao;
	}
	
	
}
