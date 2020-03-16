package com.lijianan.kylin.controller;


import com.lijianan.kylin.entity.Menu;
import com.lijianan.kylin.entity.User;
import com.lijianan.kylin.service.IMenuService;
import com.lijianan.kylin.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;
    @RequestMapping("list")
    public ResultEntity list(){
        return ResultEntity.ok(iMenuService.selectMenu());
    }

    /**
     * 根据用户名查询对应的菜单资源
     * @return
     */
    @RequestMapping("selectMenuByUsername")
    public ResultEntity selectByUsername(HttpServletRequest request, String username){
        System.out.println(request.getSession().getId()+"init");
        //获取session中的值
        User user  = (User) request.getSession().getAttribute("user");
        //判断是否未空
        if(user!=null){
            //登录的用户
            username = user.getUsername();
            System.out.println("@@@@@@@"+username);
        }
        return ResultEntity.ok(iMenuService.selectMenuByusername(username));
    }
}

