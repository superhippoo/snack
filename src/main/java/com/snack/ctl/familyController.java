package com.snack.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snack.dto.familyVO;
import com.snack.svc.familySvc;

@RestController
@RequestMapping("/family")
public class familyController {

	@Autowired
	private familySvc familysvc;

	@RequestMapping(value = "/selectfamilylist", method = RequestMethod.POST)
	@ResponseBody
	public List<familyVO> selectfamilylist(@RequestBody familyVO familyvo) {
		return familysvc.selectFamilyList(familyvo);
	}

	@RequestMapping(value = "/selectmyfamilylist", method = RequestMethod.POST)
	@ResponseBody
	public List<familyVO> selectmyfamilylist(@RequestBody familyVO familyvo) {
		return familysvc.selectMyFmailyList(familyvo);
	}

	@RequestMapping(value = "/selectfamily", method = RequestMethod.POST)
	@ResponseBody
	public familyVO selectfamily(@RequestBody familyVO familyvo) {
		return familysvc.selectFmaily(familyvo);
	}

	@RequestMapping(value = "/insertfamily", method = RequestMethod.POST)
	@ResponseBody
	public int insertfamily(@RequestBody familyVO familyvo) {
		return familysvc.insertFamily(familyvo);
	}
	
	@RequestMapping(value = "/updatefamily", method = RequestMethod.POST)
	@ResponseBody
	public int updatefamily(@RequestBody familyVO familyvo) {
		return familysvc.updateFamily(familyvo);
	}
	
	@RequestMapping(value = "/deletefamily", method = RequestMethod.POST)
	@ResponseBody
	public int deletefamily(@RequestBody familyVO familyvo) {
		return familysvc.deleteFamily(familyvo);
	}
	
	@RequestMapping(value = "/permanentdeletefamily", method = RequestMethod.POST)
	@ResponseBody
	public int permanentdeletefamily(@RequestBody familyVO familyvo) {
		return familysvc.permanentdeleteFamaily(familyvo);
	}
	
	@RequestMapping(value = "/invitefmailymember", method = RequestMethod.POST)
	@ResponseBody
	public familyVO invitefmailymember(@RequestBody familyVO familyvo) {
		return familysvc.inviteFmailyMember(familyvo);
	}
	
	@RequestMapping(value = "/selectmystandbyfmailylist", method = RequestMethod.POST)//앱 시작시 체크 useEffect
	@ResponseBody
	public List<familyVO> selectmystandbyfmailylist(@RequestBody familyVO familyvo) {
		return familysvc.selectMyStandbyFmailyList(familyvo);
	}
	
	@RequestMapping(value = "/confirminvite", method = RequestMethod.POST)
	@ResponseBody
	public familyVO confirminvite(@RequestBody familyVO familyvo) {
		return familysvc.confirmInvite(familyvo);
	}

}
