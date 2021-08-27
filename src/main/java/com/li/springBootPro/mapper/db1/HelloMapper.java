package com.li.springBootPro.mapper.db1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface HelloMapper {
    /**
     * 获取 top10信息
     * @return
     */
    List<Map<String, Object>> getHelloInfoLimit10();

    /**
     * 获取表中数据条数
     * @return
     */
    int getHelloInfoCount();

}
