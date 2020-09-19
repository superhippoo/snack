package com.snack.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snack.dao.userDao;
import com.snack.dto.userVO;
import com.snack.util.uidUtil;

@Service("userSvc")
public class userSvcImpl implements userSvc {
	@Autowired
	private userDao userdao;

	@Override
	public List<userVO> selectUserList(userVO uservo) {
		// TODO Auto-generated method stub
		return userdao.selectUserList(uservo);
	}
	
	@Override
	public userVO selectUser(userVO uservo) {
		// TODO Auto-generated method stub
		return userdao.selectUser(uservo);
	}
	
	@Override
	public int insertUser(userVO uservo) {
		uservo.setUid(uidUtil.generateUid("U"));
		uservo.setVal_yn("Y");
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setReg_dt(time);
		uservo.setMdfy_dt(time);		
		uservo.setReg_id("system");
		uservo.setMdfy_id("system");
		return userdao.insertUser(uservo);
	}
	
	@Override
	public int updateUser(userVO uservo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		return userdao.updateUser(uservo);
	}
	

	@Override
	public int deleteUser(userVO uservo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		uservo.setMdfy_dt(time);
		uservo.setVal_yn("N");
		return userdao.deleteUser(uservo);	
	}

	
	@Override
	public int permanentdeleteUser(userVO uservo) {
		return userdao.permanentdeleteUser(uservo);
	}
	
	@Override
	public userVO login(userVO uservo) {
		
		userVO tempuservo = new userVO(); 		
		tempuservo = userdao.login(uservo);

		if (tempuservo.getUid() == null) {// ���������� ������
			uservo.setUid(uidUtil.generateUid("U"));//�ű԰�����������
			uservo.setUser_type("U");
			uservo.setVal_yn("Y");
			Timestamp time = new Timestamp(System.currentTimeMillis());
			uservo.setReg_dt(time);
			uservo.setMdfy_dt(time);
			uservo.setReg_id("system");
			uservo.setMdfy_id("system");
			
			if (userdao.insertUser(uservo)> 0) {//���Լ���
				tempuservo = userdao.selectUser(uservo);
				tempuservo.setMessage("regist ok");
				return tempuservo;				
			}else {//������ �ȵǸ�
				tempuservo.setMessage("regist system check reqiured");
				return tempuservo;
			}
		}else if("N".equals(tempuservo.getVal_yn())) {//��Ȱ��ȭ ����
			tempuservo.setMessage("account check required");
			return tempuservo;
		}else {//�α��� ����
			tempuservo.setMessage("login ok");
			return tempuservo;
		}
		
	}

}
