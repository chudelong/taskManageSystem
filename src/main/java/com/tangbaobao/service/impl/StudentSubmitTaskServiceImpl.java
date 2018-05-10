package com.tangbaobao.service.impl;

import com.tangbaobao.common.SessionManage;
import com.tangbaobao.dao.StudentSubmitTaskDao;
import com.tangbaobao.pojo.Course;
import com.tangbaobao.pojo.Student;
import com.tangbaobao.pojo.Task;
import com.tangbaobao.pojo.Work;
import com.tangbaobao.service.StudentSubmitTaskService;
import com.tangbaobao.vo.FileName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author 唐学俊
 * @create 2018/04/19
 **/
@Service
public class StudentSubmitTaskServiceImpl implements StudentSubmitTaskService {
    /**
     * 注入dao
     */
    @Autowired
    private StudentSubmitTaskDao studentSubmitTaskDao;

    @Override
    public List<Course> getAllCourse(Student student) {


        return studentSubmitTaskDao.getAllCourse(student.getStudentNo());
    }

    @Override
    public List<Task> getAllTaskByCourseId(int courseId, Student student) {
        return studentSubmitTaskDao.getAllTaskByCourseId(student.getStudentNo(), courseId);
    }

    @Override
    public boolean submitTask(MultipartFile uploadFile, Work work, Student student) {
        if (uploadFile.isEmpty()) {
            return false;
        } else {
            //获取文件名信息
            String fileName = this.setFileName(work, student);
            String originalFilename = uploadFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            FileName fileNameInfo = getFileNameInfo(work, student);
            //课程文件夹
            String courseName = fileNameInfo.getCourseName() + File.separator;
            //类型文件夹
            String taskName = fileNameInfo.getTaskName() + File.separator;
            //获取文件
            String path = "/root"+File.separator+"task"+File.separator + courseName + taskName;
            System.out.println(path);

            System.err.println(path);
            File file = new File(path);
            //判断目录是否存在
            if (!file.exists()) {
                file.mkdirs();
            }
            File fileTask = new File(file + File.separator + fileName + extName);
            try {
                uploadFile.transferTo(fileTask);


                //插入表中
                work.setFileName(fileName + extName);
                work.setFilePath(fileTask.getPath());
                Student student1 = new Student();
                student1.setStudentNo(fileNameInfo.getStudentNo());
                work.setStudent(student1);
                work.setWorkStatue("1");
                work.setWorkTime(new Date());
                System.out.println(work);
                studentSubmitTaskDao.insertTable(work);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public Date checkDeadLine(int taskId) {
        return studentSubmitTaskDao.checkDeadLine(taskId);
    }


    public String setFileName(Work work, Student student) {
        String fileNameStr;
        FileName fileName = getFileNameInfo(work, student);
        //软件工程-四班-唐学俊-2015214326-数据结构_实验一
        fileNameStr = fileName.getProfessionName() + "-" + fileName.getClassName() + "-" + fileName.getStudentName() + "-" + fileName.getStudentNo()
                + "-" + fileName.getCourseName() + "-" + fileName.getTaskName();
        return fileNameStr;
    }

    public FileName getFileNameInfo(Work work, Student student) {
        //获取taskID
        int taskId = work.getTask().getTaskId();
        FileName fileName = studentSubmitTaskDao.getFileName(taskId, student.getStudentNo());
        return fileName;
    }

}
