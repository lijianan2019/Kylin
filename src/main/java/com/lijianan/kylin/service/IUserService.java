package com.lijianan.kylin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lijianan.kylin.entity.UserVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
public interface IUserService extends IService<User> {

    IPage<User> selectPageVo(Page<?> page, UserVo userVo);
}
