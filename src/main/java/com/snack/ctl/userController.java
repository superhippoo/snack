package com.snack.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snack.dto.userVO;
import com.snack.svc.userSvc;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userSvc usersvc;


    @RequestMapping(value = "/selectuserlist",method = RequestMethod.POST)
    @ResponseBody
    public List<userVO> selectuserlist(@RequestBody userVO uservo){
        return usersvc.selectUserList(uservo);
    }
  
    @RequestMapping(value = "/selectuser",method = RequestMethod.POST)
    @ResponseBody
    public userVO selectuser(@RequestBody userVO uservo){
        return usersvc.selectUser(uservo);
    }
    
    @RequestMapping(value = "/insertuser",method = RequestMethod.POST)
    @ResponseBody
    public int insertuser(@RequestBody userVO uservo){
        return usersvc.insertUser(uservo);
    }
    
    @RequestMapping(value = "/updateuser",method = RequestMethod.POST)
    @ResponseBody
    public int updateuser(@RequestBody userVO uservo){
        return usersvc.updateUser(uservo);
    }
    
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    @ResponseBody
    public int deleteuser(@RequestBody userVO uservo){
        return usersvc.deleteUser(uservo);
    }
        
    @RequestMapping(value = "/permanentdeleteuser",method = RequestMethod.POST)
    @ResponseBody
    public int permanentdeleteuser(@RequestBody userVO uservo){
        return usersvc.permanentdeleteUser(uservo);
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public userVO login(@RequestBody userVO uservo){
        return usersvc.login(uservo);
    }
}
