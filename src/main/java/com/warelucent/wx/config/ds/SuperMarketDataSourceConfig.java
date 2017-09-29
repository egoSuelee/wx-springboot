package com.warelucent.wx.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = SuperMarketDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "supermarketSqlSessionFactory")

public class SuperMarketDataSourceConfig {

    static final String PACKAGE = "com.warelucent.wx.dao.supermarket";
    static final String MAPPER_LOCATION = "classpath:mapper/supermarket/*.xml";

    @Value("${supermarket.datasource.url}")
    private String url;

    @Value("${supermarket.datasource.username}")
    private String user;

    @Value("${supermarket.datasource.password}")
    private String password;

    @Value("${supermarket.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "supermarketDataSource")
    @Primary
    public DataSource supermarketDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name = "supermarketTransactionManager")
    @Primary
    public DataSourceTransactionManager supermarketTransactionManager() {
        return new DataSourceTransactionManager(supermarketDataSource());
    }

    @Bean(name = "supermarketSqlSessionFactory")
    @Primary
    public SqlSessionFactory supermarketSqlSessionFactory(@Qualifier("supermarketDataSource") DataSource supermarketDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(supermarketDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SuperMarketDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
