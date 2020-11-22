package com.serviceimpl;

import com.bean.Notice;
import com.dao.NoticeDao;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    //查看公告
    @Override
    public Notice getNoticeById(String notice_id) {
        return noticeDao.getNoticeById(notice_id);
    }

    //修改公告
    @Override
    public void updateNoticeById(String notice_id, String notice_details) {
        noticeDao.updateNoticeById(notice_id,notice_details);
    }
}
