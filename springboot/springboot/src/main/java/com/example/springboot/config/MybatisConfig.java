package com.example.springboot.config;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper", sqlSessionTemplateRef = "mybatisSqlSessionTemplate")
public class MybatisConfig {
    @Bean(name = "mybatisSqlSessionFactory")
    @Primary
    public SqlSessionFactory mybatisSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        // Set the location of MyBatis mapper XML files
        Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/mybatis/*.xml");
        bean.setMapperLocations(resources);

        // Setting MyBatis Configuration
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setLogImpl(StdOutImpl.class); // Setting SQL log implementation
        bean.setConfiguration(configuration);

        return bean.getObject();
    }

    @Bean(name = "mybatisSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mybatisSqlSessionTemplate(@Qualifier("mybatisSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
