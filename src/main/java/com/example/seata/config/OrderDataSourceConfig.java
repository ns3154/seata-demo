package com.example.seata.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * <pre>
 *      订单数据源
 * </pre>
 * @author 杨帮东
 * @since 1.0
 * @date 2019/12/25 14:45
 **/
@Configuration
@MapperScan(basePackages = {"com.example.seata.dao.order"}, sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDataSourceConfig {

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.order")
    public DataSource dataSource() {
        return DruidDataSourceBuilder.create().build();
    }


    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("orderDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("orderDataSource") DataSource basicDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/order/*.xml"));
        factoryBean.setTypeAliasesPackage("com.example.seata.entity.po");
        return factoryBean.getObject();
    }


}
