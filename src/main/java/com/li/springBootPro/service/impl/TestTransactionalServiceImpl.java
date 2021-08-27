package com.li.springBootPro.service.impl;

import com.li.springBootPro.entry.MlisFirstSupplierInfoPO;
import com.li.springBootPro.mapper.db1.MlisFirstSupplierInfoPOMapper;
import com.li.springBootPro.service.TestRequiresNewService;
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
    @Autowired
    TestRequiresNewService testRequiresNewService;

    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED)
    public void TestShiWu() {

        MlisFirstSupplierInfoPO mlisFirstSupplierInfoPO = mlisFirstSupplierInfoPOMapper.selectByPrimaryKey("4cded40b-2683-11eb-8802-c46516baa728");
        MlisFirstSupplierInfoPO newMlisFirstSupplierInfoPO = new MlisFirstSupplierInfoPO();
        BeanUtils.copyProperties(mlisFirstSupplierInfoPO, newMlisFirstSupplierInfoPO);
        String id = UUID.randomUUID().toString().replace("-","");
        newMlisFirstSupplierInfoPO.setId(id);
        newMlisFirstSupplierInfoPO.setContactPerson("徐杰明星1");
        int count = mlisFirstSupplierInfoPOMapper.insertSelective(newMlisFirstSupplierInfoPO);
        String id1 = UUID.randomUUID().toString().replace("-","");
        newMlisFirstSupplierInfoPO.setId(id1);
        //update 里面抛异常外层方法依然会回滚
        testRequiresNewService.update(newMlisFirstSupplierInfoPO);
        MlisFirstSupplierInfoPO mlisFirstSupplierInfoPO2 = mlisFirstSupplierInfoPOMapper.selectByPrimaryKey(id);
        System.out.println("success");
//        throw new RuntimeException("故意抛出错误");
//        return mlisFirstSupplierInfoPO2;
    }

}
