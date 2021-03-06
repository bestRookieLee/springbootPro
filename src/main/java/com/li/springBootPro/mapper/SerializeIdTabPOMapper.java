package com.li.springBootPro.mapper;

import com.li.springBootPro.entry.serializeIdDTO;
import com.li.springBootPro.entry.serializeIdTabPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SerializeIdTabPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(serializeIdTabPO record);

    int insertSelective(serializeIdTabPO record);

    serializeIdTabPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(serializeIdTabPO record);

    int updateByPrimaryKey(serializeIdTabPO record);

    List<serializeIdDTO> selectDetailUnderDt();
}