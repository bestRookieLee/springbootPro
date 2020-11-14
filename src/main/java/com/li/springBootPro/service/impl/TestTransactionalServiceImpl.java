package com.li.springBootPro.service.impl;

import com.li.springBootPro.entry.MlisFirstSupplierInfoPO;
import com.li.springBootPro.mapper.MlisFirstSupplierInfoPOMapper;
import com.li.springBootPro.service.TestTransactionalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TestTransactionalServiceImpl implements TestTransactionalService {
    @Autowired
    MlisFirstSupplierInfoPOMapper mlisFirstSupplierInfoPOMapper;

    @Override
    @Transactional
    public void TestShiWu() {

        MlisFirstSupplierInfoPO mlisFirstSupplierInfoPO = mlisFirstSupplierInfoPOMapper.selectByPrimaryKey("4cded40b-2683-11eb-8802-c46516baa728");
        MlisFirstSupplierInfoPO newMlisFirstSupplierInfoPO = new MlisFirstSupplierInfoPO();
        BeanUtils.copyProperties(mlisFirstSupplierInfoPO, newMlisFirstSupplierInfoPO);
        String id = UUID.randomUUID().toString().replace("-","");
        newMlisFirstSupplierInfoPO.setId(id);
        mlisFirstSupplierInfoPOMapper.insertSelective(newMlisFirstSupplierInfoPO);
        update(newMlisFirstSupplierInfoPO, "改变名称2");
        MlisFirstSupplierInfoPO mlisFirstSupplierInfoPO2 = mlisFirstSupplierInfoPOMapper.selectByPrimaryKey(id);
        System.out.println("success");
        throw new RuntimeException("故意的一个异常");
//        return mlisFirstSupplierInfoPO2;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(MlisFirstSupplierInfoPO param, String personName){
        param.setContactPerson(personName);
        mlisFirstSupplierInfoPOMapper.updateByPrimaryKey(param);
    }

}
