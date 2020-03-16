package com.lijianan.kylin.service;

import com.lijianan.kylin.entity.Nation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijianan.kylin.entity.NationVo;

import java.util.List;

/**
 * <p>
 * 城市字典表 服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface INationService extends IService<Nation> {
    List<NationVo> findAll();
}
