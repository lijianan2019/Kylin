package com.lijianan.kylin.controller;


import com.lijianan.kylin.service.ISalesService;
import com.lijianan.kylin.vo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljn
 * @since 2020-03-15
 */
@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private ISalesService iSalesService;
    /**
     * 商品促销类型查询
     * @return
     */
    @RequestMapping("/list")
    public ResultEntity list(){
        return ResultEntity.ok(iSalesService.list());
    }
}

