package com.tangbaobao.service;

import com.tangbaobao.pojo.Teacher;
import com.tangbaobao.vo.CourseAndCount;
import com.tangbaobao.vo.SubmitTaskInfo;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/30
 **/
public interface TeacherManageCenterService {
    List<CourseAndCount> findAllCource(Teacher teachert);

    List<SubmitTaskInfo> findAllSubmitInfo(Teacher teacher);
}
