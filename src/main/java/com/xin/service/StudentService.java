package com.xin.service;

import com.xin.entity.Student;
import com.xin.mapper.StudentMapper;
import com.xin.util.MyBatisSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
@Slf4j
public class StudentService {

    private SqlSessionFactory sqlSessionFactory;

    @PostConstruct
    private void init(){
        sqlSessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
        sqlSessionFactory.getConfiguration().addMapper(StudentMapper.class);
    }

    public List<Student> findAllStudents(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findAllStudents();
        }finally {
            sqlSession.close();
        }
    }

    public Student findStudentById(Integer id){
        log.debug("Select student by id :{}", id);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findStudentById(id);
        }finally {
            sqlSession.close();
        }
    }

    public HashMap<String, Object> findById(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findById(id);
        }finally {
            sqlSession.close();
        }
    }

    public Student findStudentWithAddress(Integer stuId){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.findStudentWithAddress(stuId);
//            return mapper.selectStudentWithAddress(stuId);
        }finally {
            sqlSession.close();
        }
    }

    public int insertStudent(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            return mapper.insertStudent(student);
        }finally {
            sqlSession.close();
        }
    }

}
