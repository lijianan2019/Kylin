package com.lijianan.kylin.service.impl;

import com.lijianan.kylin.entity.Test;
import com.lijianan.kylin.mapper.TestMapper;
import com.lijianan.kylin.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
