package com.lijianan.kylin.service;

import com.lijianan.kylin.entity.Menu_role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface IMenu_roleService extends IService<Menu_role> {
    /**
     * 抛出异常的操作
     * @param rid
     * @param mids
     * @throws Exception
     */
    void insertBatch(Integer rid,Integer mids[])throws Exception;
}
