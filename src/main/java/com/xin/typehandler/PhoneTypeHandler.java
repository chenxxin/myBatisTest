package com.xin.typehandler;

import com.xin.domain.PhoneNumber;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, PhoneNumber phoneNumber, JdbcType jdbcType) throws SQLException {
        // 因为 数据表中的phone列 是varchar类型，故使用 setString() 方法
        preparedStatement.setString(i,phoneNumber.getAsString());
    }

    // 下面三个方法没看懂

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 因为 数据表中的phone列 是varchar类型，故使用 getString() 方法
        return new PhoneNumber(resultSet.getString(s));
    }

    @Override
    public PhoneNumber getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new PhoneNumber(resultSet.getString(i));
    }

    @Override
    public PhoneNumber getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new PhoneNumber(callableStatement.getString(i));
    }
}
