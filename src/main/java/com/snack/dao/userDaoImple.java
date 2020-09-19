package com.snack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snack.dto.userVO;

@Repository
public class userDaoImple implements userDao{
	
	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<userVO> selectUserList(userVO uservo) {
		
		String q = "select * from sd_user";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<userVO>(userVO.class));
		
	}
	
	@Override
	public userVO selectUser(userVO uservo) {
		
		String q = "select * from sd_user where uid = ?";
		Object[] args = {uservo.getUid()};
		try {
			return jdbdtemplate.queryForObject(q, args,new BeanPropertyRowMapper<userVO>(userVO.class));
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	public int insertUser(userVO uservo) {

		String q = "  INSERT INTO sd_user VALUES(?,?,?,?,?,?,?,?,?)";
		Object[] args = { uservo.getUid(), uservo.getEmail(), uservo.getUser_type(),
				uservo.getVal_yn(),uservo.getPush_yn(),uservo.getReg_id(),uservo.getMdfy_id(), uservo.getReg_dt(),uservo.getMdfy_dt()};
		return jdbdtemplate.update(q, args);

	}
	
	@Override
	public int updateUser(userVO uservo) {
		String q = "update sd_user set "
				+ "email = ? , "
				+ "user_type = ? , "
				+ "val_yn = ? , "
				+ "push_yn = ? , "
				+ "mdfy_id = ? , "
				+ "mdfy_dt = ? "				
				+ "where uid = ?" ;
		Object[] args = { uservo.getEmail(), uservo.getUser_type(),uservo.getVal_yn(),uservo.getPush_yn(),uservo.getMdfy_id(),
							uservo.getMdfy_dt(),uservo.getUid()};
		return jdbdtemplate.update(q, args);
	}
	
	@Override
	public int deleteUser(userVO uservo) {
		String q = "update sd_user set "
				+ "val_yn = ? ,"
				+ "mdfy_id = ? ,"
				+ "mdfy_dt = ? "
				+ "where uid = ?" ;
		Object[] args = { uservo.getVal_yn(),uservo.getMdfy_id(),uservo.getMdfy_dt(), uservo.getUid() };
		return jdbdtemplate.update(q, args);
	}
	
	
	@Override
	public int permanentdeleteUser(userVO uservo) {
		String q = "delete from sd_user where uid = ?" ;
		Object[] args = {uservo.getUid()};
		return jdbdtemplate.update(q,args);
	}
	
	@Override
	public userVO login(userVO uservo) {
		String q = "select * from sd_user where email = ?" ;
		Object[] args = {uservo.getEmail()};
		try {
			return jdbdtemplate.queryForObject(q, args,new BeanPropertyRowMapper<userVO>(userVO.class));
		} catch (Exception e) {
			return uservo;
		}
	}

	@Override
	public userVO selectUidByEmail(userVO uservo) {
		String q = "select * from sd_user where email = ?" ;
		Object[] args = {uservo.getEmail()};
		try {
			return jdbdtemplate.queryForObject(q, args,new BeanPropertyRowMapper<userVO>(userVO.class));
		} catch (Exception e) {
			return uservo;
		}
	}
	
	
}
