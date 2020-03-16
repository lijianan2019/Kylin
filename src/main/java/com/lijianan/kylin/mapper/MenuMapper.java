package com.lijianan.kylin.mapper;

import com.lijianan.kylin.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 查询所有菜单
     */
    List<Menu> selectMenu();

    /**
     * 根据用户名称查询用户对应的菜单资源
     */
    List<Menu> selectMenuByusername(String username);
}
