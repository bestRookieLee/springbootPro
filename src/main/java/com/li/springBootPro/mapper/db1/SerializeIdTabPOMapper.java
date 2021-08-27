package com.li.springBootPro.mapper.db1;

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

    List<serializeIdTabPO> selectAll();

    int updateByPrimaryKeySelective(serializeIdTabPO record);

    int updateByPrimaryKey(serializeIdTabPO record);

    List<serializeIdDTO> selectDetailUnderDt();

    List<serializeIdDTO> selectAllAndGrp();
}