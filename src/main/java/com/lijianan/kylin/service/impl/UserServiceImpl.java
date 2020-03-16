package com.lijianan.kylin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.User;
import com.lijianan.kylin.entity.UserVo;
import com.lijianan.kylin.mapper.UserMapper;
import com.lijianan.kylin.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljnselectPageVo
 * @since 2020-03-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<User> selectPageVo(Page<?> page, UserVo userVo) {
        return userMapper.selectPageVo(page, userVo);
    }
}
