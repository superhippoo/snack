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

import com.snack.Entity.ArticleEntity;
import com.snack.Entity.BoardEntity;
import com.snack.dao.articleRepository;
import com.snack.dao.boardRepository;
import com.snack.dto.articleVO;
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
//
//    @RequestMapping(value = "/selectarticle",method = RequestMethod.POST)
//    @ResponseBody
//    public articleVO selectarticle(@RequestBody articleVO articlevo){
//    	ModelMapper modelMapper = new ModelMapper();
//    	articleVO article = modelMapper.map(articlerepo.findById(articlevo.getArticle_id()).orElseGet(ArticleEntity::new), articleVO.class);
//    	return article;
//
//    }
//    
//    @RequestMapping(value = "/selectarticlelistbybrdno",method = RequestMethod.POST)
//    @ResponseBody
//    public List<articleVO> selectarticlelistbybrdno(@RequestBody articleVO articlevo){
//    	List<ArticleEntity> list = new ArrayList<ArticleEntity>();
//    	List<articleVO> articlelist = new ArrayList<articleVO>();
//    	list = articlerepo.findBybrdNo(articlevo.getBrdNo());
//    	
//    	ModelMapper modelMapper = new ModelMapper();
//    	
//    	for (int i = 0; i < list.size(); i++) {
//    		articlelist.add(modelMapper.map(list.get(i),articleVO.class));
//		}
//    	
//        return articlelist;
//    }
//
//    
//	@RequestMapping(value = "/updatearticle", method = RequestMethod.POST)
//	@ResponseBody
//	public void updatearticle(@RequestBody articleVO articlevo) {
//    	ModelMapper modelMapper = new ModelMapper();
//    	ArticleEntity articleentity = modelMapper.map(articlevo, ArticleEntity.class);
//		articlerepo.save(articleentity);
//	}
// 
//	@RequestMapping(value = "/deletearticle", method = RequestMethod.POST)
//	@ResponseBody
//	public void deletearticle(@RequestBody articleVO articlevo) {
//    	ModelMapper modelMapper = new ModelMapper();
//    	ArticleEntity articleentity = modelMapper.map(articlevo, ArticleEntity.class);
//		articlerepo.delete(articleentity);
//	}
//	
//	@RequestMapping(value = "/insertarticle", method = RequestMethod.POST)
//	@ResponseBody
//	public void insertarticle(@RequestBody articleVO articlevo) {
//		
//		articlevo.setArticle_id(uidUtil.generateUid("A"));
//    	ModelMapper modelMapper = new ModelMapper();
//    	ArticleEntity articleentity = modelMapper.map(articlevo, ArticleEntity.class);
//		articlerepo.save(articleentity);
//	}
}
