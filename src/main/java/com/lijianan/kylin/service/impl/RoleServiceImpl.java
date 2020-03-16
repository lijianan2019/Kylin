package com.lijianan.kylin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Role;
import com.lijianan.kylin.entity.RoleVo;
import com.lijianan.kylin.mapper.RoleMapper;
import com.lijianan.kylin.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Resource
    private RoleMapper roleMapper;

    @Override
    public IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo) {
        return roleMapper.selectPageVo(page, roleVo);
    }
}
