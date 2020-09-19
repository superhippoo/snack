package com.snack.dao;

import java.util.List;

import com.snack.dto.familyVO;

public interface familyDao {

	public List<familyVO> selectFmailyList(familyVO familyvo);

	public List<familyVO> selectMyFmailyList(familyVO familyvo);

	public familyVO selectFmaily(familyVO familyvo);

	public int insertFamily(familyVO familyvo);

	public int maxSequence(familyVO familyvo);

	public int updateFamily(familyVO familyvo);
	
	public int updateFamilyByOwner(familyVO familyvo);
	
	public int deleteFamily(familyVO familyvo);
	
	public int permanentdeleteFamily(familyVO familyvo);
	
	public List<familyVO> selectMyStandbyFmailyList(familyVO familyvo);
	
	public int confirmInvite(familyVO familyvo);

}
