package com.li.springBootPro.mapper;

import com.li.springBootPro.entry.detailTabPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface detailTabPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(detailTabPO record);

    int insertSelective(detailTabPO record);

    detailTabPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(detailTabPO record);

    int updateByPrimaryKey(detailTabPO record);
}