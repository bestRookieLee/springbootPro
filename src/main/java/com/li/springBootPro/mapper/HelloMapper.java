package com.li.springBootPro.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HelloMapper {
    List<Map<String, Object>> getHelloInfoLimit10();

    int getHelloInfoCount();

}
