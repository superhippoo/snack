package com.snack.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snack.dto.scheduleVO;
import com.snack.svc.scheduleSvc;

@RestController
@RequestMapping("/schedule")
public class scheduleController {

	@Autowired
	private scheduleSvc schedulesvc;

	@RequestMapping(value = "/selectschedulelist", method = RequestMethod.POST)
	@ResponseBody
	public List<scheduleVO> selectschedulelist(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.selectScheduleList(schedulevo);
	}
	
	@RequestMapping(value = "/selectmyschedulelist", method = RequestMethod.POST)
	@ResponseBody
	public List<scheduleVO> selectmyachedulelist(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.selectMyScheduleList(schedulevo);
	}
	
	@RequestMapping(value = "/selectallmyschedulelist", method = RequestMethod.POST)
	@ResponseBody
	public List<scheduleVO> selectallmyachedulelist(@RequestBody List<scheduleVO> schedulelist) {
		return schedulesvc.selectAllMyScheduleList(schedulelist);
	}
	
	@RequestMapping(value = "/selectschedule", method = RequestMethod.POST)
	@ResponseBody
	public scheduleVO selectschedule(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.selectSchedule(schedulevo);
	}
	
	@RequestMapping(value = "/insertschedule", method = RequestMethod.POST)
	@ResponseBody
	public int insertschedule(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.insertSchedule(schedulevo);
	}
	
	@RequestMapping(value = "/updateschedule", method = RequestMethod.POST)
	@ResponseBody
	public int updateschedule(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.updateSchedule(schedulevo);
	}
	
	@RequestMapping(value = "/permanentdeleteschedule", method = RequestMethod.POST)
	@ResponseBody
	public int permanentdeleteschedule(@RequestBody scheduleVO schedulevo) {
		return schedulesvc.permanentdeleteSchedule(schedulevo);
	}

}
