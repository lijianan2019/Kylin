package com.lijianan.kylin.service.impl;

import com.lijianan.kylin.entity.Menu;
import com.lijianan.kylin.mapper.MenuMapper;
import com.lijianan.kylin.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> selectMenu() {
        return menuMapper.selectMenu();
    }

    @Override
    public List<Menu> selectMenuByusername(String username) {
        return menuMapper.selectMenuByusername(username);
    }
}
