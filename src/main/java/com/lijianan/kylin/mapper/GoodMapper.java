package com.lijianan.kylin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Good;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lijianan.kylin.entity.GoodVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
public interface GoodMapper extends BaseMapper<Good> {

    IPage<Good> selectPageVo(Page<Good> page, GoodVo goodVo);

    void insertgood(Good good);

    void insertmiddle(@Param("id") Integer id, @Param("id1") Integer id1);
}
