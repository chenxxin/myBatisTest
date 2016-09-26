package com.xin.sqlprovider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by CHENXINXIN on 2016/8/8.
 */
public class TutorDynaSqlProvider {
    // 返回的是一个sql 语句
    public String findTutorByIdSql(final int tutorId){
//        return "select tutor_id as tutorId, name, email from tutor where tutor_id="+tutorId;

        SQL sql = new SQL();
        sql.SELECT("tutor_id as tutorId, name, email").
            FROM("tutor").
            WHERE("tutor_id=" + tutorId);
        return sql.toString();

    }
}
