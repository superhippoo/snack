package com.snack.dao;

import java.util.List;

import com.snack.dto.scheduleVO;

public interface scheduleDao {

	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo);

	public List<scheduleVO> selectMyScheduleList(scheduleVO schedulevo);
	
	public scheduleVO selectSchedule(scheduleVO schedulevo);

	public int insertSchedule(scheduleVO schedulevo);
	
	public int updateSchedule(scheduleVO schedulevo);

	public int permanentdeleteSchedule(scheduleVO schedulevo);
}
