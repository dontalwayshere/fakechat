package com.fakechat.practice.service.impl;


import com.fakechat.practice.mapper.PmsgMapper;
import com.fakechat.practice.model.Pmsg;
import com.fakechat.practice.service.PMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PMsgServiceImpl implements PMsgService {

    @Resource
    private PmsgMapper pmsgMapper;

    @Override
    public int save(Pmsg pmsg) {
        return pmsgMapper.save(pmsg);
    }
}
