package com.lijianan.kylin.mapper;

import com.lijianan.kylin.entity.Goods_sales;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
public interface Goods_salesMapper extends BaseMapper<Goods_sales> {


    void deleteMidlle(Integer id);
}
