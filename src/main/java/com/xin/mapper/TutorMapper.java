package com.xin.mapper;

import com.xin.entity.Address;
import com.xin.entity.Course;
import com.xin.entity.Tutor;
import com.xin.sqlprovider.TutorDynaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by CHENXINXIN on 2016/8/8.
 */
public interface TutorMapper {
//    @One注解 一对一关联数据查询
//    @One注解的select属性指定一个使用了 完全限定名的方法(findAddressById)，该方法返回一个Address对象
//    使用 column = "addr_id"，则addr_id的值将作为参数传递给findAddressById方法
//
//    @Many注解 一对多关联数据查询

    @Select("select * from tutor where tutor_id=#{tutorId}")
    @Results({
            @Result(id = true, column = "tutor_id", property = "tutorId"),  // 一旦使用了@Results，将覆盖settings中自动驼峰命名规则的设置
            @Result(property = "address", column = "addr_id", one = @One(select = "com.xin.mapper.TutorMapper.findAddressById")),
            @Result(property = "courses", column = "tutor_id", many = @Many(select = "com.xin.mapper.TutorMapper.findCoursesByTutorId"))
    })
    Tutor findTutorById(int tutorId);

    @Select("select * from address where addr_id=#{addrId}")
    Address findAddressById(int addrId);

    @Select("select * from course where tutor_id=#{tutorId}")
    List<Course> findCoursesByTutorId(int tutorId);

    @SelectProvider(type = TutorDynaSqlProvider.class, method = "findTutorByIdSql")
    Tutor findTutorBytutorId(int tutorId);

//    动态SQL @InsertProvider, @UpdateProvider, @DeleteProvider, @SelectProvider
//
//
//
}
