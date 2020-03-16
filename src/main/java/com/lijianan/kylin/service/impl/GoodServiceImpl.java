package com.lijianan.kylin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.Good;
import com.lijianan.kylin.entity.GoodVo;
import com.lijianan.kylin.mapper.GoodMapper;
import com.lijianan.kylin.service.IGoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

    @Resource
    private GoodMapper goodMapper;

    @Override
    public IPage<Good> selectPageVo(Page<Good> page, GoodVo goodVo) {
        return goodMapper.selectPageVo(page,goodVo);
    }

    @Override
    public boolean insertgood(Good good, Integer[] ids) {
        try {
            //添加商品表
            goodMapper.insertgood(good);
            for (Integer id : ids) {
                goodMapper.insertmiddle(good.getId(),id);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }
}
