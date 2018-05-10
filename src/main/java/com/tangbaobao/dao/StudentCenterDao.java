package com.tangbaobao.dao;

import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/15
 **/
public interface StudentCenterDao {
    /**
     * 根据学生no获取学生所有信息
     * @param studentNo
     * @return
     */
    Student getStudentInfo(@Param(value = "studentNo") String studentNo);

    List<Work> countSubmittedTask(@Param(value = "studentNo") String studentNo);

    int countTask(@Param(value = "studentNo") String studentNo);
}
