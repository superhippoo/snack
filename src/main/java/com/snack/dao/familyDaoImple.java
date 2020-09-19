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
	public List<familyVO> selectFmailyList(familyVO familyvo) {//��������Ķ���� ��ü��ȸ ������ ���

		String q = "select * from sd_family";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<familyVO>(familyVO.class));

	}

	@Override
	public List<familyVO> selectMyFmailyList(familyVO familyvo) {//���� ��������Ķ���� ��ü ��ȸ (vld_yn = Y)�� ������ 

		String q = "select * from sd_family " 
					+ "where uid = ?" 
					+ "and vld_stat = ?";
		Object[] args = { familyvo.getUid(), familyvo.getVld_stat() };
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<familyVO>(familyVO.class));
	}

	@Override
	public familyVO selectFmaily(familyVO familyvo) {//���� ��������Ķ���� �� ���� ����Ķ���� ��ȸ
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
	public int insertFamily(familyVO familyvo) {//���� ��������Ķ���� ����
		String q = "  INSERT INTO sd_family VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { familyvo.getFuid(), familyvo.getUid(), familyvo.getFcode(),familyvo.getMembername(),
				familyvo.getTitle(),familyvo.getColor(), familyvo.getSequence(), familyvo.getBase_yn(), 
				familyvo.getOpen_yn(),familyvo.getVld_stat(), familyvo.getReg_id(), familyvo.getMdfy_id(), 
				familyvo.getReg_dt(),familyvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int maxSequence(familyVO familyvo) {//����Ķ���� ������ ������ �����ϱ����� max sequence ���� ��ȸ
		String q = "select max(sequence) from sd_family where uid = ?";
		Object[] args = { familyvo.getUid() };
		return jdbdtemplate.queryForObject(q, args, Integer.class);
	}

	@Override
	public int updateFamily(familyVO familyvo) {// ���� ��������Ķ������ ���� ���� �Խ�Ʈ ��� (���� fuid�� Ķ���� ��ü�� �ƴ� fuid,uid ������ ������ ����)
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
	public int updateFamilyByOwner(familyVO familyvo) {// ���� fuid�� ����ϴ� ����Ķ�������� �ϰ� �����ϴ� owner�� ��� 
		String q = "update sd_family set "
				+ "open_yn = ? , "//���� ����
				+ "vld_stat = ? , "//���� ����
				+ "mdfy_id = ? , "//������
				+ "mdfy_dt = ? "//������
				+ "where fuid = ?";//�������� id
				
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
		//fuid ���� ������ �ϰ� ���� ��� �����ؾߵ�
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
