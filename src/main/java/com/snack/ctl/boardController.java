package com.snack.ctl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.snack.Entity.BoardEntity;
import com.snack.dao.boardRepository;
import com.snack.dto.boardVO;
import com.snack.util.uidUtil;
@RestController
@RequestMapping("/board")
public class boardController {

	@Autowired
	boardRepository boardrepo;


    @RequestMapping(value = "/selectboardlist",method = RequestMethod.POST)
    @ResponseBody
    public List<boardVO> selectboardlist(@RequestBody boardVO boardvo){
    	List<BoardEntity> list = new ArrayList<BoardEntity>();
    	List<boardVO> boardlist = new ArrayList<boardVO>();
    	list = boardrepo.findAll();
    	
    	ModelMapper modelMapper = new ModelMapper();
    	
    	for (int i = 0; i < list.size(); i++) {
    		boardlist.add(modelMapper.map(list.get(i),boardVO.class));
		}
    	
        return boardlist;
    }
    
    @RequestMapping(value = "/selectboard",method = RequestMethod.POST)
    @ResponseBody
    public boardVO selectboard(@RequestBody boardVO boardvo){
    	
    	ModelMapper modelMapper = new ModelMapper();
    	boardVO board = modelMapper.map(boardrepo.findById(boardvo.getBrdNo()).orElseGet(BoardEntity::new), boardVO.class);
    	
        return board;
    }
    
    @RequestMapping(value = "/updateboard",method = RequestMethod.POST)
    @ResponseBody
    public void updateboard(@RequestBody boardVO boardvo){    	
    	ModelMapper modelMapper = new ModelMapper();
    	BoardEntity boardentity = modelMapper.map(boardvo,BoardEntity.class);
    	boardrepo.save(boardentity);    	
    }
    
    @RequestMapping(value = "/deleteboard",method = RequestMethod.POST)
    @ResponseBody
    public void deleteboard(@RequestBody boardVO boardvo){    	
    	ModelMapper modelMapper = new ModelMapper();
    	BoardEntity boardentity = modelMapper.map(boardvo,BoardEntity.class);
    	boardrepo.delete(boardentity);    	
    }
    
    @RequestMapping(value = "/insertboard",method = RequestMethod.POST)
    @ResponseBody
    public void insertboard(@RequestBody boardVO boardvo){    	
    	boardvo.setBrdNo(uidUtil.generateUid("B"));
    	ModelMapper modelMapper = new ModelMapper();
    	BoardEntity boardentity = modelMapper.map(boardvo,BoardEntity.class);
    	boardrepo.save(boardentity);    	
    }

}
