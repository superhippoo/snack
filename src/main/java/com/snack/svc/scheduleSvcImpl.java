package com.snack.svc;

import java.sql.Timestamp;
import java.util.ArrayList;
//import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snack.dao.scheduleDao;
import com.snack.dto.scheduleVO;
import com.snack.util.uidUtil;

@Service("scheduleSvc")
public class scheduleSvcImpl implements scheduleSvc {
	@Autowired
	private scheduleDao scheduledao;

	@Override
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo) {
		return scheduledao.selectScheduleList(schedulevo);
	}

	@Override
	public List<scheduleVO> selectMyScheduleList(scheduleVO schedulevo) {
		List<scheduleVO> resultlist = new ArrayList<scheduleVO>();
		List<scheduleVO> list = scheduledao.selectMyScheduleList(schedulevo);
		for (int i = 0; i < list.size(); i++) {
			if ("Y".equals(list.get(i).getOpen_yn()) ) {
				resultlist.add(list.get(i));
			}else if(list.get(i).getOpen_range().contains(schedulevo.getSearchfcode())){
				resultlist.add(list.get(i));
			}
		}		
		
		return resultlist;
	}

	@Override
	public List<scheduleVO> selectAllMyScheduleList(List<scheduleVO> schedulelist) {
		List<scheduleVO> resultlist = new ArrayList<scheduleVO>();
		
		for (int i = 0; i < schedulelist.size(); i++) {
			List<scheduleVO> list = scheduledao.selectMyScheduleList(schedulelist.get(i));
			
			for (int j = 0; j < list.size(); j++) {
				if ("Y".equals(list.get(j).getOpen_yn()) ) {
					resultlist.add(list.get(j));
				}else if(list.get(j).getOpen_range().contains(schedulelist.get(i).getSearchfcode())){
					resultlist.add(list.get(j));
				}
			}
		}
		
		return resultlist;
	}
	

	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {

		scheduleVO resultvo = new scheduleVO();
		resultvo = scheduledao.selectSchedule(schedulevo);
		if (resultvo == null) {
			return resultvo;
		} else {
			resultvo.setIsowner("N");
			if (schedulevo.getSearcheruid() != null && resultvo.getReg_id() != null	&& schedulevo.getSearcheruid().equals(resultvo.getReg_id())) {
				resultvo.setIsowner("Y");
			}
			return resultvo;
		}

	}

	@Override
	public int insertSchedule(scheduleVO schedulevo) {
		schedulevo.setSid(uidUtil.generateUid("S"));
		Timestamp time = new Timestamp(System.currentTimeMillis());
		schedulevo.setReg_dt(time);
		schedulevo.setMdfy_dt(time);			
		return scheduledao.insertSchedule(schedulevo);
	}

	@Override
	public int updateSchedule(scheduleVO schedulevo) {
		Timestamp time = new Timestamp(System.currentTimeMillis());
		schedulevo.setMdfy_dt(time);
		return scheduledao.updateSchedule(schedulevo);
	}

	@Override
	public int permanentdeleteSchedule(scheduleVO schedulevo) {
		return scheduledao.permanentdeleteSchedule(schedulevo);
	}


}
