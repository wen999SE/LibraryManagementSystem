package com.dao;

import com.bean.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NoticeDao {

    //查看公告
    @Select("select * from notice where notice_id=#{notice_id}")
    Notice getNoticeById(@Param("notice_id") String notice_id);

    //修改公告
    @Update("update notice set notice_details=#{notice_details} where notice_id=#{notice_id}")
    void updateNoticeById(@Param("notice_id") String notice_id,@Param("notice_details")String notice_details);
}
