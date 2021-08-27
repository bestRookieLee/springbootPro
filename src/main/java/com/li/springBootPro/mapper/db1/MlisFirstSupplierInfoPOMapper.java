package com.li.springBootPro.mapper.db1;

import com.li.springBootPro.entry.MlisFirstSupplierInfoPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MlisFirstSupplierInfoPOMapper {
    int deleteByPrimaryKey(String id);

    int insert(MlisFirstSupplierInfoPO record);

    int insertSelective(MlisFirstSupplierInfoPO record);

    MlisFirstSupplierInfoPO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MlisFirstSupplierInfoPO record);

    int updateByPrimaryKeyWithBLOBs(MlisFirstSupplierInfoPO record);

    int updateByPrimaryKey(MlisFirstSupplierInfoPO record);
}