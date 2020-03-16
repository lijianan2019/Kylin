package com.lijianan.kylin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Good;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijianan.kylin.entity.GoodVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
public interface IGoodService extends IService<Good> {

    IPage<Good> selectPageVo(Page<Good> page, GoodVo goodVo);

    boolean insertgood(Good good, Integer[] ids);
}
