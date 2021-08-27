package com.li.springBootPro.controller;

import com.li.springBootPro.mapper.db2.BookInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/helloBook")
public class BookInfoController {
    @Autowired
    BookInfoMapper bookInfoMapper;

    @RequestMapping(value = "/HiBookInfo",method = RequestMethod.GET)
    public Map<String, Object> getAllInfo(){
        Map<String, Object> result = new HashMap<>();
        result.put("list", bookInfoMapper.getAllBookInfo());
        return result;
    }
}
