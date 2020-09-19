package com.snack.svc;

import java.sql.Timestamp;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snack.dao.familyDao;
import com.snack.dao.userDao;
import com.snack.dto.familyVO;
import com.snack.dto.userVO;
import com.snack.util.uidUtil;

@Service("familySvc")
public class familySvcImpl implements familySvc {
	@Autowired
	private familyDao familydao;

	@Autowired
	private userDao userdao;
	
	@Override
	public List<familyVO> selectFamilyList(familyVO familyvo) {
		return familydao.selectFmailyList(familyvo);
	}

	@Override
	public List<familyVO> selectMyFmailyList(familyVO familyvo) {
		familyvo.setVld_stat("Y");
		return familydao.selectMyFmailyList(familyvo);
	}

	@Override
	public familyVO selectFmaily(familyVO familyvo) {
		return familydao.selectFmaily(familyvo);
	}

	@Override
	public int insertFamily(familyVO familyvo) {
		familyvo.setFuid(uidUtil.generateUid("F"));
		familyvo.setVld_stat("Y");
		familyvo.setSequence(familydao.maxSequence(familyvo)+1);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		familyvo.setReg_dt(time);
		familyvo.setMdfy_dt(time);		
		familyvo.setReg_id("system");
		familyvo.setMdfy_id("system");		
		return familydao.insertFamily(familyvo);
	}

	@Override
	public int updateFamily(familyVO familyvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		familyvo.setMdfy_dt(time);
		return familydao.updateFamily(familyvo);
	}

	@Override
	public int deleteFamily(familyVO familyvo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		familyvo.setMdfy_dt(time);		
		familyvo.setVld_stat("N");
		return familydao.deleteFamily(familyvo);
	}

	@Override
	public int permanentdeleteFamaily(familyVO familyvo) {
		return familydao.permanentdeleteFamily(familyvo);
	}

	@Override
	public familyVO inviteFmailyMember(familyVO familyvo) {
		userVO uservo = new userVO(); 	
		userVO tempuservo = new userVO(); 	
		
		uservo.setEmail(familyvo.getInviteemail());
		tempuservo = userdao.selectUidByEmail(uservo);//email로 uid받아온다
		
		if (tempuservo.getUid() == null) {
			familyvo.setMessage("not registed id");
			return familyvo;
		}else {
			familyvo.setUid(tempuservo.getUid());
			familyvo.setVld_stat("S");
			familyvo.setSequence(familydao.maxSequence(familyvo)+1);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			familyvo.setReg_dt(time);
			familyvo.setMdfy_dt(time);		
			familyvo.setReg_id("system");
			familyvo.setMdfy_id("system");
			
			familydao.insertFamily(familyvo);
			
			familyvo.setMessage("invite ok");
			return familyvo;
		}
		
	}

	@Override
	public List<familyVO> selectMyStandbyFmailyList(familyVO familyvo) {
		familyvo.setVld_stat("S");
		return familydao.selectMyFmailyList(familyvo);
	}

	@Override
	public familyVO confirmInvite(familyVO familyvo) {
		int result = 0;
		if ("Y".equals(familyvo.getConfirm_yn())) {	
			familyvo.setVld_stat("Y");
			result = familydao.confirmInvite(familyvo);
			
			if (result == 1) {
				familyvo.setMessage("confirm ok");				
			}else {
				familyvo.setMessage("check to admin");
			}
			return familyvo;
		}else {
			result = familydao.permanentdeleteFamily(familyvo);
			
			if (result ==1) {
				familyvo.setMessage("reject ok");
			}else {
				familyvo.setMessage("check to admin");
			}
			return familyvo;
		}
	}

}
