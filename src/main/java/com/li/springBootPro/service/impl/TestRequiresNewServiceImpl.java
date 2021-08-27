package com.li.springBootPro.service.impl;

import com.li.springBootPro.entry.MlisFirstSupplierInfoPO;
import com.li.springBootPro.mapper.db1.MlisFirstSupplierInfoPOMapper;
import com.li.springBootPro.service.TestRequiresNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestRequiresNewServiceImpl implements TestRequiresNewService {

    @Autowired
    MlisFirstSupplierInfoPOMapper mlisFirstSupplierInfoPOMapper;
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update(MlisFirstSupplierInfoPO newMlisFirstSupplierInfoPO)  throws RuntimeException{
        /**
         * REQUIRES_NEW 这个方法被另外一个事务嵌套调用的时候
         * 当外部事务报错， 内部事务提交的内容还在
         */
        int count = mlisFirstSupplierInfoPOMapper.insertSelective(newMlisFirstSupplierInfoPO);
        newMlisFirstSupplierInfoPO.setContactPerson("改变名称4");
        mlisFirstSupplierInfoPOMapper.updateByPrimaryKey(newMlisFirstSupplierInfoPO);
        System.out.println("成功");
        throw new RuntimeException("故意抛出错误");
    }
}
