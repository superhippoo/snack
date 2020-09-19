package com.snack.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.snack.dto.scheduleVO;

@Repository
public class scheduleDaoImple implements scheduleDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo) {

		String q = "select * from sd_schedule";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class));
	}

//	@Override
//	public List<scheduleVO> selectMyScheduleList(scheduleVO schedulevo) {
//		String q = "select * from sd_schedule"
//				+ " where fuid = ?"
//				+ " and (date_format(startdate,'%Y%m') = ? or date_format(enddate,'%Y%m') = ?)";
//		
//		Object[] args = { schedulevo.getFuid(),schedulevo.getSearchmonth(),schedulevo.getSearchmonth()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class));	
//	}

	
	@Override
	public List<scheduleVO> selectMyScheduleList(scheduleVO schedulevo) {
		String q = "select * from sd_schedule"
				+ " where fuid = ?"
				+ " and enddate >= ? and startdate <= ?";
		
		Object[] args = { schedulevo.getFuid(),schedulevo.getSearchstartdate(),schedulevo.getSearchenddate()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class));	
	}
	
	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {
		String q = "select * from sd_schedule  " 
				 + "where sid = ?" ;				
		Object[] args = { schedulevo.getSid()};
		
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public int insertSchedule(scheduleVO schedulevo) {
		String q = "insert into sd_schedule values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = {schedulevo.getSid(),schedulevo.getFuid(),schedulevo.getAct_dt(),schedulevo.getFcode(),
						schedulevo.getEvcode(),schedulevo.getTitle(),schedulevo.getContent(),schedulevo.getPushterm(),
						schedulevo.getOpen_yn(),schedulevo.getOpen_range(),schedulevo.getPlace(),schedulevo.getStartdate(),
						schedulevo.getEnddate(),schedulevo.getReg_id(),schedulevo.getMdfy_id(),schedulevo.getReg_dt(),schedulevo.getMdfy_dt()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateSchedule(scheduleVO schedulevo) {
		String q = "update sd_schedule set "
				+ "act_dt = ? , "
				+ "evcode = ? , "
				+ "title = ? , "
				+ "content = ? , "
				+ "pushterm = ? , "
				+ "open_yn = ?, "
				+ "open_range = ?, "
				+ "place = ?, "
				+ "startdate = ?, "
				+ "enddate= ?, "
				+ "mdfy_id = ?, "
				+ "mdfy_dt = ?"				
				+ "where sid = ?";
		
		Object[] args = {schedulevo.getAct_dt(),schedulevo.getEvcode(),schedulevo.getTitle(),schedulevo.getContent(),schedulevo.getPushterm(),
				schedulevo.getOpen_yn(),schedulevo.getOpen_range(),schedulevo.getPlace(),schedulevo.getStartdate(),schedulevo.getEnddate(),
				schedulevo.getMdfy_id(),schedulevo.getMdfy_dt(),schedulevo.getSid()};
		
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int permanentdeleteSchedule(scheduleVO schedulevo) {
		String q = "delete from sd_schedule where sid = ?" ;
		Object[] args = {schedulevo.getSid()};
		return jdbdtemplate.update(q,args);
	}



}
