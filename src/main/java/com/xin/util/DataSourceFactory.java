package com.xin.util;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
public class DataSourceFactory {
    /**
     * POOLED类型的数据源
     */
    public static DataSource getDataSource(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://10.4.2.40:3306/kingsoftyun";
        String username = "root";
        String password = "111111";
        PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
        return dataSource;
    }

    /**
     * JNDI 类型的数据源
     * 在生产环境中，DataSource会被应用服务器配置，并通过JNDI获取DataSource对象
     */
    public static DataSource getJNDIDataSource()
    {
        String dataSourceJNDIName = "java:comp/env/jdbc/MyBatisDemoDS";
        try
        {
            InitialContext ctx = new InitialContext();
            DataSource dataSource = (DataSource) ctx.lookup(dataSourceJNDIName);
            return dataSource;
        }
        catch (NamingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
