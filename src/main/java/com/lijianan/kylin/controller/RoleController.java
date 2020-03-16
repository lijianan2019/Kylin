package com.lijianan.kylin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Role;
import com.lijianan.kylin.entity.RoleVo;
import com.lijianan.kylin.entity.User;
import com.lijianan.kylin.service.IMenu_roleService;
import com.lijianan.kylin.service.IRoleService;
import com.lijianan.kylin.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IMenu_roleService iMenu_roleService;

    /**
     * 用户授权角色查询
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iRoleService.list());
    }
    /**
     * 角色查询
     * @param current
     * @param size
     * @param roleVo
     * @return
     */
    @RequestMapping("/select")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, RoleVo roleVo) {
        Page<User> page = new Page<>(current, size);
        //自定义查询分页实现
        IPage<RoleVo> pageInfo = iRoleService.selectPageVo(page, roleVo);
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
        //删除管理的中间表
        for (Integer id : ids) {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("rid",id);
            iMenu_roleService.remove(wrapper);
        }
        //再删除主表的数据
        //返回值为boolean
        boolean flag = iRoleService.removeByIds(Arrays.asList(ids));
        //返回boolean值
        return ResultEntity.ok(flag);
    }

    /**
     * 角色添加
     *
     * @param entity
     * @return
     */
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody Role entity) {
        boolean flag = iRoleService.save(entity);
        return ResultEntity.ok(flag);
    }

    /**
     * 角色数据编辑
     *
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody Role entity) {
        boolean flag = iRoleService.updateById(entity);
        return ResultEntity.ok(flag);
    }
}

