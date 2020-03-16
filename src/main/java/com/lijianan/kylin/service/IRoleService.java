package com.lijianan.kylin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijianan.kylin.entity.RoleVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface IRoleService extends IService<Role> {
    /**
     * 角色自定义列表分页查询
     *
     * @param page
     * @param roleVo
     * @return
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);
}
