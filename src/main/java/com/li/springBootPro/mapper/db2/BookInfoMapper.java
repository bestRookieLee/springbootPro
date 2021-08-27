package com.li.springBootPro.mapper.db2;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookInfoMapper {

    /**
     * 获取所有book信息
     * @return
     */
    List<Map<String, Object>> getAllBookInfo();
}
