package com.lijianan.kylin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lijianan.kylin.entity.Menu_role;
import com.lijianan.kylin.mapper.Menu_roleMapper;
import com.lijianan.kylin.service.IMenu_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@Service
public class Menu_roleServiceImpl extends ServiceImpl<Menu_roleMapper, Menu_role> implements IMenu_roleService {

    @Autowired
    private Menu_roleMapper menu_roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBatch(Integer rid, Integer[] mids) throws Exception {
        //先删除角色对应的资源
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("rid",rid);
        menu_roleMapper.delete(wrapper);

        //int i=1/0;
        //判断操作
        if(mids!=null && mids.length>0) {
            //遍历
            for (Integer mid : mids) {
                Menu_role menu_role = new Menu_role();
                menu_role.setMid(mid);
                menu_role.setRid(rid);
                menu_roleMapper.insert(menu_role);
            }
        }
    }
}
