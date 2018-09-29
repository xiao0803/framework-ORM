package com.my.app.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.domain.User;
import com.my.app.domain.Weibo;
import com.my.app.repository.UserRepository;
import com.my.app.repository.WeiboDao;
import com.my.app.repository.WeiboRepository;
import com.my.app.vo.WeiboVo;

@Controller
public class TestController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WeiboRepository weiboRepository;
    
    @Autowired
    private WeiboDao weiboDao;
    
    @RequestMapping("/searchUser/{username}")
    public @ResponseBody
    List<User> searchUser(@PathVariable("username") String username) {
        List<User> result = this.userRepository.findByUsernameContaining(username);
        return result;
    }
    
    @RequestMapping("/username/{username}")
    public List<Weibo> getUserWeibo(@PathVariable("username") String username) {
        return this.weiboRepository.searchUserWeibo(username,new Sort(new Sort.Order(Sort.Direction.DESC,"weiboId")));
    }
    
    @RequestMapping("/simpleSearch")
    public String simpleSearch(){
//        User user = this.userRepository.getByUsernameIs(username);
//        return this.weiboRepository.findByUserIsAndWeiboTextContaining(user,weiboText,new PageRequest(pageNo,pageSize));
    	weiboDao.searchWeibo2("%weibo%");
    	return null;
    }
    
    @RequestMapping("/test")
    public String test(){
    	List<WeiboVo> list = weiboDao.searchWeibo2("%weibo%");
    	WeiboVo vo = list.get(0);
    	long WeiboId = vo.getWeiboId();
    	System.out.println("@@@@@@@@@@@@@:" + WeiboId);
    	System.out.println("执行成功！");
    	return "执行成功！";
    }
    

}