package com.fakechat.practice.controller;

import com.fakechat.practice.common.msg.MessageBox;
import com.fakechat.practice.model.Pmsg;
import com.fakechat.practice.service.PMsgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/pmsg")
public class PMsgController {

    @Resource
    private PMsgService pMsgService;

    @PostMapping("/save")
    public MessageBox<String> save(Pmsg pmsg) {
        return pMsgService.save(pmsg) != -1 ? MessageBox.okMsg() : MessageBox.failMsg();
    }

}
