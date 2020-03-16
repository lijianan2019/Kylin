package com.lijianan.kylin.entity;

import lombok.Data;

@Data
public class UserVo extends User {
    //扩展省市区
    //省
    private String provinceName;
    //市
    private String cityName;
    //区
    private String districtName;
    //扩展角色
    private String ids;
    private String rnames;
    private String rnameZhs;
}
