package com.snack.svc;

import java.util.List;

import com.snack.dto.familyVO;

public interface familySvc {

	public List<familyVO> selectFamilyList(familyVO familyvo);

	public List<familyVO> selectMyFmailyList(familyVO familyvo);
	
	public familyVO selectFmaily(familyVO familyvo);
	
	public int insertFamily(familyVO familyvo);

	public int updateFamily(familyVO familyvo);
	
	public int deleteFamily(familyVO familyvo);
	
	public int permanentdeleteFamaily(familyVO familyvo);

	public familyVO inviteFmailyMember(familyVO familyvo);
	
	public List<familyVO> selectMyStandbyFmailyList(familyVO familyvo);
	
	public familyVO confirmInvite(familyVO familyvo);

	
}
