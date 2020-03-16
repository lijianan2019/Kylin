package com.lijianan.kylin.service.impl;

import com.lijianan.kylin.entity.Employee;
import com.lijianan.kylin.mapper.EmployeeMapper;
import com.lijianan.kylin.service.IEmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
