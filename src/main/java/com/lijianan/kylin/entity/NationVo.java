package com.lijianan.kylin.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class NationVo implements Serializable {

    //对象三级联动的id值
    private Integer value;
    //对应三级联动中的名称，province,city,district
    private String label;

    private List<NationVo> children;
}
