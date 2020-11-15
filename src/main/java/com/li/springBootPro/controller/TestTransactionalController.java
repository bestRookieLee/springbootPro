package com.li.springBootPro.controller;

import com.li.springBootPro.service.TestTransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testTransactional")
public class TestTransactionalController {

    @Autowired
    TestTransactionalService testTransactionalService;

    @PostMapping(value = "/testShiWu")
    public void testShiWu(){
        testTransactionalService.TestShiWu();
    }
}
