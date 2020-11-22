package com.controller;

import com.bean.Notice;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //查看公告
    @RequestMapping(value = "/getNoticeById/{id}",method = RequestMethod.GET)
    public Notice getNoticeById(@PathVariable("id")String id){
        return noticeService.getNoticeById(id);
    }

    //修改公告
    @RequestMapping(value = "/updateNoticeById/{notice_id}",method = RequestMethod.PUT)
    public Notice updateNoticeById(@PathVariable("notice_id")String notice_id, @RequestParam("notice_details")String notice_details){
        noticeService.updateNoticeById(notice_id,notice_details);
        return noticeService.getNoticeById(notice_id);
    }
}
