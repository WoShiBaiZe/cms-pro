package com.baize.cms.service.impl;

import com.baize.cms.dao.mapper.TestMapper;
import com.baize.cms.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public int count() {

        return testMapper.count();
    }
}
