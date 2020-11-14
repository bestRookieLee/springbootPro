package com.li.springBootPro.controller;

import com.li.springBootPro.entry.MlisFirstSupplierInfoPO;
import com.li.springBootPro.mapper.HelloMapper;
import com.li.springBootPro.service.TestTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testTransactional")
public class TestTransactionalController {

    @Autowired
    TestTransactionalService testTransactionalService;

    @RequestMapping(value = "/testShiWu",method = RequestMethod.GET)
    public void testShiWu(){
        testTransactionalService.TestShiWu();
    }
}
