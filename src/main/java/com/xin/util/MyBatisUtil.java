package com.xin.util;

import com.xin.domain.PhoneNumber;
import com.xin.mapper.StudentMapper;
import com.xin.typehandler.PhoneTypeHandler;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Created by CHENXINXIN on 2016/8/6.
 */
// 使用Java API 配置 MyBatis
public class MyBatisUtil {
    public static SqlSessionFactory getSqlSessionFaction(){
        SqlSessionFactory sqlSessionFactory = null;
        try{
            DataSource dataSource = DataSourceFactory.getDataSource();
            TransactionFactory transactionFactory = new JdbcTransactionFactory();
            Environment environment = new Environment("development", transactionFactory, dataSource);
            Configuration configuration = new Configuration(environment);

            // 注册别名
//            configuration.getTypeAliasRegistry().registerAlias("student", Student.class);
//            configuration.getTypeAliasRegistry().registerAlias(Student.class); // 默认规则
//            configuration.getTypeAliasRegistry().registerAliases("com.xin.entity"); // 为 包中所有类 注册别名
//            configuration.getTypeAliasRegistry().registerAliases("com.xin.entity", Identifiable.class);  // 为 包中所有继承自Identifiable的类 注册别名

            // 类型处理器
            configuration.getTypeHandlerRegistry().register(PhoneNumber.class, PhoneTypeHandler.class); // 为某个特定的类注册类处理器
//            configuration.getTypeHandlerRegistry().register(PhoneTypeHandler.class); // 注册一个类处理器
//            configuration.getTypeHandlerRegistry().register("com.xin.typehandler"); // 注册 包中的所有类型处理器

            // 全局参数设置Settings
//            configuration.setMapUnderscoreToCamelCase(true);

            // Mappers 应该在typeAliases 和 typeHandler注册后再添加到configuration中
            configuration.addMapper(StudentMapper.class);
//            configuration.addMappers("com.xin.mapper");  // 添加包中所有Mapper XML文件 或者 Mapper接口
//            configuration.addMappers("com.xin.mapper", BaseMapper.class); // 添加包中所有扩展了BaseMapper接口的 Mapper接口

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return sqlSessionFactory;
    }
}
