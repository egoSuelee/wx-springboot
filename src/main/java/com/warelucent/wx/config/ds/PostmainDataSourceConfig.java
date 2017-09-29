package com.warelucent.wx.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = PostmainDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "postmainSqlSessionFactory")

public class PostmainDataSourceConfig {
    static final String PACKAGE = "com.warelucent.wx.dao.postmain";
    static final String MAPPER_LOCATION = "classpath:mapper/postmain/*.xml";

    @Value("${postmain.datasource.url}")
    private String url;

    @Value("${postmain.datasource.username}")
    private String user;

    @Value("${postmain.datasource.password}")
    private String password;

    @Value("${postmain.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "postmainDataSource")
    public DataSource postmainDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "postmainTransactionManager")
    public DataSourceTransactionManager postmainTransactionManager() {
        return new DataSourceTransactionManager(postmainDataSource());
    }

    @Bean(name = "postmainSqlSessionFactory")
    public SqlSessionFactory postmainSqlSessionFactory(@Qualifier("postmainDataSource") DataSource postmainDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(postmainDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(PostmainDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }


}
