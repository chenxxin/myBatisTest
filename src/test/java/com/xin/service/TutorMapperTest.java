package com.xin.service;

import com.xin.entity.Tutor;
import com.xin.mapper.TutorMapper;
import com.xin.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * Created by CHENXINXIN on 2016/8/8.
 */
public class TutorMapperTest {
    @Test
    public void test() throws Exception {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.getSqlSessionFactory();
        sqlSessionFactory.getConfiguration().addMapper(TutorMapper.class);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            TutorMapper mapper = sqlSession.getMapper(TutorMapper.class);

//            List<Course> courses = mapper.findCoursesByTutorId(1);
//
//            System.out.println("---------------------------------------");
//            for (Course course : courses){
//                System.out.println(course);
//            }
//            System.out.println("---------------------------------------");

            Tutor tutor = mapper.findTutorById(1);

            System.out.println("---------------------------------------");
            System.out.println(tutor);
            System.out.println("---------------------------------------");

//            Address address = mapper.findAddressById(1);
//
//            System.out.println("---------------------------------------");
//            System.out.println(address);
//            System.out.println("---------------------------------------");
        }finally {
            sqlSession.close();
        }

    }


}
