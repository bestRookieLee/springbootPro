package com.li.springBootPro.service;

import java.util.Map;

public interface TestRedisService {
    Map<String, Object> typeString();
    public Map<String, String> typeHash();
}
