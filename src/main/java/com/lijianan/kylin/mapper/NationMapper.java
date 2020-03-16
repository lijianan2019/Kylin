package com.lijianan.kylin.mapper;

import com.lijianan.kylin.entity.Nation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lijianan.kylin.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 Mapper 接口
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface NationMapper extends BaseMapper<Nation> {
    //查询所有的地址
    List<NationVo> findAll();
}
