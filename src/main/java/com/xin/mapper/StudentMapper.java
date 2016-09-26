package com.xin.mapper;

import com.xin.entity.Address;
import com.xin.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

/**
 * 映射SQL语句的接口，无逻辑实现
 */
public interface StudentMapper{

    @Insert("insert into student(stud_id, name, email, dob, phone) values(#{studId}, #{name}, #{email}, #{dob}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "studId")  // 自动生成主键
    int insertStudent(Student student);

    @Update("update student set name=#{name}, email=#{email}, phone=#{phone} where stud_id=#{studId}")
    int updateStudent(Student student);

    @Delete("delete from student where stud_id=#{studId}")
    int deleteStudent(int studId);

    @Select("select * from student")
    List<Student> findAllStudents();

    @Select("select * from student where stud_id = #{studId}")
    Student findStudentById(Integer studId);

    /*
    MyBatis 可以返回的集合类有：
    java.util包下的 ArrayList, HashMap, HashSet, TreeSet
    下例中，数据表中的列名为 key，对应的列值为 value
     */
    @Select("select * from student where stud_id = #{studId}")
    HashMap<String, Object> findById(Integer stuId);

    @Select("select s.*, a.* from student s left outer join address a on s.stud_id=a.addr_id where s.stud_id=#{studId}")
    @ResultMap("com.xin.mapper.StudentMapper.StudentWithAddressResult")  // 依赖于studentMapper.xml中的<resultMap> StudentWithAddressResult
    Student selectStudentWithAddress(Integer stuId);

    @Select("select * from student where stud_id=#{studId}")
    @Results({  // @Results注解和 映射器XML配置文件中的<resultMap> 相对应
            @Result(id = true, column = "stud_id", property = "studId"),  //因开启了自动驼峰命名规则，此行可省略
            @Result(property = "address", column = "addr_id", one = @One(select = "com.xin.mapper.StudentMapper.findAddressById"))
    })
    Student findStudentWithAddress(Integer stuId);

    @Select("select * from address where addr_id=#{addrId}")
    Address findAddressById(int addrId);

    /*
    实体类中的属性名 和 数据表中的字段名 不匹配时的做法(3种)

    @Select("select stud_id as studId, name, email, dob, phone from student where stud_id = #{studId}")

    @Select("select * from student where stud_id = #{studId}")
    @Results({@Result(id = true, column = "stud_id", property = "studId")})

    @Select("select * from student where stud_id = #{studId}")
    @ResultMap("com.xin.mapper.StudentMapper.StudentResult")
     */

}
