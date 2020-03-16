package com.lijianan.kylin.service.impl;

import com.lijianan.kylin.entity.Nation;
import com.lijianan.kylin.entity.NationVo;
import com.lijianan.kylin.mapper.NationMapper;
import com.lijianan.kylin.service.INationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 城市字典表 服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-03
 */
@Service
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

    @Resource
    private NationMapper nationMapper;

    @Override
    public List<NationVo> findAll() {
        return nationMapper.findAll();
    }
}
