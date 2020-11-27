package com.example.demo.service;


import com.example.demo.pojo.Notice;

public interface NoticeService {

    //查看公告
    Notice getNoticeById(String notice_id);

    //修改公告
    void updateNoticeById(String notice_id, String notice_details);
}
