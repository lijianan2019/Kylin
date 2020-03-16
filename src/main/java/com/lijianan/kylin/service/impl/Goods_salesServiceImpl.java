package com.lijianan.kylin.service.impl;

import com.lijianan.kylin.entity.Goods_sales;
import com.lijianan.kylin.mapper.Goods_salesMapper;
import com.lijianan.kylin.service.IGoods_salesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
@Service
public class Goods_salesServiceImpl extends ServiceImpl<Goods_salesMapper, Goods_sales> implements IGoods_salesService {

    @Resource
    private Goods_salesMapper goods_salesMapper;

    @Override
    public void deleteMidlle(Integer id) {
        if(id!=null){
            goods_salesMapper.deleteMidlle(id);

        }
    }
}
