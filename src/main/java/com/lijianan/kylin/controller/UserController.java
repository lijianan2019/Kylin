package com.lijianan.kylin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.User;
import com.lijianan.kylin.entity.UserVo;
import com.lijianan.kylin.service.IUserService;
import com.lijianan.kylin.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户分页查询列表
     *
     * @param current
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, UserVo userVo) {
        Page<User> page = new Page<>(current, size);
        //自定义查询分页实现
        IPage<User> pageInfo = iUserService.selectPageVo(page, userVo);
        return ResultEntity.ok(pageInfo);
    }

    /**
     * 删除--单表，批量删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public ResultEntity delete(Integer ids[]) {
        //返回值为boolean
        boolean flag = iUserService.removeByIds(Arrays.asList(ids));
        //返回boolean值
        return ResultEntity.ok(flag);
    }

    /**
     * 用户添加
     *
     * @param entity
     * @return
     */
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody User entity) {
        boolean flag = iUserService.save(entity);
        return ResultEntity.ok(flag);
    }

    /**
     * 用户数据编辑
     *
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody User entity) {
        boolean flag = iUserService.updateById(entity);
        return ResultEntity.ok(flag);
    }

    @RequestMapping("/login")
    public ResultEntity login(HttpServletRequest request,@RequestBody User user){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        System.out.println(session.getId()+"@@@@@@@@@@@@@@@@@@@@@@@");
        //定义查询条件
        QueryWrapper queryWrapper = new QueryWrapper();
        //username名称是唯一
        queryWrapper.eq("username",user.getUsername());
        //获取实体对象
        User entity = iUserService.getOne(queryWrapper);
        //判断查询结果
        if(entity!=null){
            //判断密码
            if(entity.getPassword().equals(user.getPassword())){
                //存储会话
                session.setAttribute("user",entity);
                //返回结果
                return ResultEntity.ok(entity);
            }
        }
        return ResultEntity.error(5001,"用户名或密码错误");
    }

    /**
     * 退出登录/注销
     * @param request
     *
     * @return
     */
    @RequestMapping("/loginout")
    public ResultEntity loginout(HttpServletRequest request){
        //获取session对象
        HttpSession session = request.getSession();
        //输出session的id
        session.removeAttribute("user");
        return ResultEntity.ok(true);
    }
}

