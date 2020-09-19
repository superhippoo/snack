package com.snack.svc;

import java.util.List;

import com.snack.dto.scheduleVO;

public interface scheduleSvc {

	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo);
	
	public List<scheduleVO> selectMyScheduleList(scheduleVO schedulevo);
	
	public List<scheduleVO> selectAllMyScheduleList(List<scheduleVO> schedulelist);
	
	public scheduleVO selectSchedule(scheduleVO schedulevo);
	
	public int insertSchedule(scheduleVO schedulevo);
	
	public int updateSchedule(scheduleVO schedulevo);

	public int permanentdeleteSchedule(scheduleVO schedulevo);


}
