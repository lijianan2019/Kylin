package com.lijianan.kylin.entity;

import lombok.Data;

@Data
public class GoodVo extends  Good{
    //扩展省市区
    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;
    //促销名称
    private String sname;
    //区间价格
    private Double p1;
    private Double p2;
    //促销id
    private String sids;
}
