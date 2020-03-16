package com.lijianan.kylin.service;

import com.lijianan.kylin.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 查询所有菜单
     */
    List<Menu> selectMenu();

    /**
     * 根据用户名称查询用户对应的菜单资源
     */
    List<Menu> selectMenuByusername(String username);
}
