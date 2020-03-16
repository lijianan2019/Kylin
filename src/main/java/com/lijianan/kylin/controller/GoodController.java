package com.lijianan.kylin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lijianan.kylin.entity.*;
import com.lijianan.kylin.service.IGoodService;
import com.lijianan.kylin.service.IGoods_salesService;
import com.lijianan.kylin.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private IGoodService iGoodService;

    @Autowired
    private IGoods_salesService iGoods_salesService;

    @RequestMapping("/list")
    public ResultEntity list(@RequestParam(defaultValue = "1") long current,
                             @RequestParam(defaultValue = "3") long size, GoodVo goodVo) {
        Page<Good> page = new Page<>(current, size);
        //自定义查询分页实现
        IPage<Good> pageInfo = iGoodService.selectPageVo(page, goodVo);
        return ResultEntity.ok(pageInfo);
    }

    /**
     * 商品添加
     * @param
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public ResultEntity insert(@RequestBody GoodsVo goodsVo) {
        boolean flag = iGoodService.save(goodsVo);
        String[] split = goodsVo.getSid().split(",");
        List<Goods_sales> list=new ArrayList<>();
        for (String s : split) {

            Goods_sales goods_sales = new Goods_sales();
            goods_sales.setGid(goodsVo.getId());
            goods_sales.setSid(Integer.parseInt(s));
            list.add(goods_sales);
        }
        boolean save = iGoods_salesService.saveBatch(list);
        return ResultEntity.ok(save);
    }

    /**
     * 批量删除/单删
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public ResultEntity delete(Integer ids[]) {
        //返回值为boolean
        boolean flag = iGoodService.removeByIds(Arrays.asList(ids));
        //返回boolean值
        return ResultEntity.ok(flag);
    }

    /**
     * 商品修改
     * @param goodsVo
     * @return
     */
    @RequestMapping("/update")
    public ResultEntity update(@RequestBody GoodsVo goodsVo) {
        boolean flag = iGoodService.updateById(goodsVo);
        String[] split = goodsVo.getSid().split(",");
        List<Goods_sales> list=new ArrayList<>();
        for (String s : split) {

            Goods_sales goods_sales = new Goods_sales();
            goods_sales.setGid(goodsVo.getId());
            goods_sales.setSid(Integer.parseInt(s));
            list.add(goods_sales);
        }

        iGoods_salesService.deleteMidlle(goodsVo.getId());
        boolean save = iGoods_salesService.saveBatch(list);
        return ResultEntity.ok(save);
    }
}

