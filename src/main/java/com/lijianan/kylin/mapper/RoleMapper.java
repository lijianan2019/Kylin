package com.lijianan.kylin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lijianan.kylin.entity.RoleVo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 角色自定义列表分页查询
     *
     * @param page
     * @param roleVo
     * @return
     */
    IPage<RoleVo> selectPageVo(Page<?> page, RoleVo roleVo);
}
