package com.snack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snack.dto.familyVO;

@Repository
public class familyDaoImple implements familyDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<familyVO> selectFmailyList(familyVO familyvo) {//가족일정캘린더 전체조회 관리자 기능

		String q = "select * from sd_family";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<familyVO>(familyVO.class));

	}

	@Override
	public List<familyVO> selectMyFmailyList(familyVO familyvo) {//나의 가족일정캘린더 전체 조회 (vld_yn = Y)인 일정만 

		String q = "select * from sd_family " 
					+ "where uid = ?" 
					+ "and vld_stat = ?";
		Object[] args = { familyvo.getUid(), familyvo.getVld_stat() };
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<familyVO>(familyVO.class));
	}

	@Override
	public familyVO selectFmaily(familyVO familyvo) {//나의 가족일정캘린더 중 단일 일정캘린더 조회
		String q = "select * from sd_family  " 
					+ "where fuid = ?" 
					+ "and uid = ?";
		Object[] args = { familyvo.getFuid(), familyvo.getUid() };
		
		try {
			return jdbdtemplate.queryForObject(q, args,new BeanPropertyRowMapper<familyVO>(familyVO.class));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public int insertFamily(familyVO familyvo) {//나의 가족일정캘린더 생성
		String q = "  INSERT INTO sd_family VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { familyvo.getFuid(), familyvo.getUid(), familyvo.getFcode(),familyvo.getMembername(),
				familyvo.getTitle(),familyvo.getColor(), familyvo.getSequence(), familyvo.getBase_yn(), 
				familyvo.getOpen_yn(),familyvo.getVld_stat(), familyvo.getReg_id(), familyvo.getMdfy_id(), 
				familyvo.getReg_dt(),familyvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int maxSequence(familyVO familyvo) {//일정캘린더 생성시 순서를 정의하기위한 max sequence 정보 조회
		String q = "select max(sequence) from sd_family where uid = ?";
		Object[] args = { familyvo.getUid() };
		return jdbdtemplate.queryForObject(q, args, Integer.class);
	}

	@Override
	public int updateFamily(familyVO familyvo) {// 단일 가족일정캘린더의 정보 수정 게스트 기능 (동일 fuid의 캘린더 전체가 아닌 fuid,uid 조건의 내꺼만 수정)
		String q = "update sd_family set "
				+ "membername = ?"
				+ "title = ? , "
				+ "color = ? , "
				+ "base_yn = ? , "
				+ "mdfy_id = ? , "
				+ "mdfy_dt = ? "				
				+ "where fuid = ?"
				+ "and uid = ?" ;
		Object[] args = {familyvo.getMembername(),familyvo.getTitle(),familyvo.getColor(),familyvo.getBase_yn(),
						familyvo.getMdfy_id(),familyvo.getMdfy_dt(),familyvo.getFuid(),familyvo.getUid() };
		return jdbdtemplate.update(q, args);
	}
	

	@Override
	public int updateFamilyByOwner(familyVO familyvo) {// 동일 fuid를 사용하는 일정캘린더들을 일괄 수정하는 owner의 기능 
		String q = "update sd_family set "
				+ "open_yn = ? , "//공유 여부
				+ "vld_stat = ? , "//삭제 여부
				+ "mdfy_id = ? , "//수정자
				+ "mdfy_dt = ? "//수정일
				+ "where fuid = ?";//가족일정 id
				
		Object[] args = {familyvo.getOpen_yn(),familyvo.getVld_stat(),familyvo.getMdfy_id(),
							familyvo.getMdfy_dt(),familyvo.getFuid()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteFamily(familyVO familyvo) {
		String q = "update sd_family set "
				+ "vld_stat = ? ,"
				+ "mdfy_id = ? ,"
				+ "mdfy_dt = ? "
				+ "where fuid = ?" ;
		Object[] args = { familyvo.getVld_stat(),familyvo.getMdfy_id(),familyvo.getMdfy_dt(),familyvo.getFuid()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int permanentdeleteFamily(familyVO familyvo) {
		String q = "delete from sd_family where fuid = ?" ;
		Object[] args = {familyvo.getFuid()};
		return jdbdtemplate.update(q,args);
		//fuid 하위 일정들 일괄 삭제 기능 구현해야됨
	}

	@Override
	public List<familyVO> selectMyStandbyFmailyList(familyVO familyvo) {
		String q = "select * from sd_family " 
					+ "where uid = ?" 
					+ "and vld_stat = ?";
		Object[] args = { familyvo.getUid(), familyvo.getVld_stat() };
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<familyVO>(familyVO.class));
	}

	@Override
	public int confirmInvite(familyVO familyvo) {
		String q = "update sd_family set "
				+ "val_stat = ? , "
				+ "mdfy_id = ? , "
				+ "mdfy_dt = ? "				
				+ "where fuid = ?"
				+ "and uid = ?" ;
		Object[] args = {familyvo.getVld_stat(),familyvo.getMdfy_id(),
						familyvo.getMdfy_dt(),familyvo.getFuid(),familyvo.getUid() };
		return jdbdtemplate.update(q, args);
	}


}
