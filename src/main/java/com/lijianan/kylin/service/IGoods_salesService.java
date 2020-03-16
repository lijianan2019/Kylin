package com.lijianan.kylin.service;

import com.lijianan.kylin.entity.Goods_sales;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
public interface IGoods_salesService extends IService<Goods_sales> {


    void deleteMidlle(Integer id);
}
