package com.example.springboot.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboot.mapper1", sqlSessionTemplateRef = "mybatisPlusSqlSessionTemplate")
public class MybatisplusConfig {
    @Bean(name = "mybatisPlusSqlSessionFactory")
    public SqlSessionFactory mybatisPlusSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        // MyBatis Plus特有的配置
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true); // 自动下划线到驼峰命名的转换
        configuration.setLogImpl(StdOutImpl.class); // SQL日志输出到标准控制台
        configuration.setCacheEnabled(false); // 禁用缓存
        configuration.setJdbcTypeForNull(null); // Oracle数据库配置JdbcTypeForNull

        // 设置MyBatis Plus的全局配置
        com.baomidou.mybatisplus.core.config.GlobalConfig globalConfig = new com.baomidou.mybatisplus.core.config.GlobalConfig();
        globalConfig.setDbConfig(new com.baomidou.mybatisplus.core.config.GlobalConfig.DbConfig());
        globalConfig.getDbConfig().setIdType(com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID);
        globalConfig.getDbConfig().setLogicDeleteField("deleted");
        globalConfig.getDbConfig().setLogicDeleteValue("1");
        globalConfig.getDbConfig().setLogicNotDeleteValue("0");

        bean.setGlobalConfig(globalConfig);

        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/mybatisplus/*.xml"));

        return bean.getObject();
    }

    @Bean(name = "mybatisPlusSqlSessionTemplate")
    public SqlSessionTemplate mybatisPlusSqlSessionTemplate(@Qualifier("mybatisPlusSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
