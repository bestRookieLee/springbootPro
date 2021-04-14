package com.li.springBootPro.controller;

import com.li.springBootPro.entry.serializeIdDTO;
import com.li.springBootPro.entry.serializeIdTabPO;
import com.li.springBootPro.mapper.HelloMapper;
import com.li.springBootPro.mapper.SerializeIdTabPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/helloYou")
public class helloController {
    @Autowired
    HelloMapper helloMapper;

    @Autowired
    SerializeIdTabPOMapper serializeIdTabPOMapper;

    @RequestMapping(value = "/Hi",method = RequestMethod.GET)
    public String sayHiToYou(){
        return "long time no see,brother";
    }

    @RequestMapping(value = "/HiInfo",method = RequestMethod.GET)
    public Map<String, Object> getAllInfo(){
        Map<String, Object> result = new HashMap<>();
        result.put("count", helloMapper.getHelloInfoCount());
        result.put("top10", helloMapper.getHelloInfoLimit10());
        return result;
    }

    @RequestMapping(value = "/testMybatis",method = RequestMethod.GET)
    public List<serializeIdDTO> testMybatis(){
        /**
         * mybaits 一对多关系，在工作过程中发现
         * pgsql 映射的map中不写主键 映射结果会出错
         *
         */
        List<serializeIdDTO> serializeIdDTOList = serializeIdTabPOMapper.selectDetailUnderDt();
        return serializeIdDTOList;
    }


    @RequestMapping(value = "/selectAllAndGrp",method = RequestMethod.GET)
    public List<serializeIdDTO> selectAllAndGrp(){
        List<serializeIdDTO> serializeIdDTOList = serializeIdTabPOMapper.selectAllAndGrp();
        return serializeIdDTOList;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public Map<String, List<serializeIdTabPO>> selectAll(){
        List<serializeIdTabPO> serializeIdPOList = serializeIdTabPOMapper.selectAll();
//        Map<String, List<serializeIdTabPO>> serializeIdPOListGrpSerializeId = serializeIdPOList.stream().collect(Collectors.groupingBy(serializeIdTabPO::getSerializeId));
        Map<String, List<serializeIdTabPO>> serializeIdPOListGrpSerializeId = serializeIdPOList.stream().collect(Collectors.groupingBy(serializeIdTabPO::getParentCode));
        return serializeIdPOListGrpSerializeId;
    }
}
