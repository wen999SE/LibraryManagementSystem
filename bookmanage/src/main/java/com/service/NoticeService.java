package com.service;

import com.bean.Notice;


public interface NoticeService {

    //查看公告
    Notice getNoticeById(String notice_id);

    //修改公告
    void updateNoticeById(String notice_id,String notice_details);
}
