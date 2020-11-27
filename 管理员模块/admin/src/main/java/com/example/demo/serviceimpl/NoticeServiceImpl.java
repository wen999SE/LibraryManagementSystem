package com.example.demo.serviceimpl;


import com.example.demo.dao.NoticeDao;
import com.example.demo.pojo.Notice;
import com.example.demo.service.NoticeService;
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
