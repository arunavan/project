package com.cognizant.internal.workout.service.config;


import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cognizant.internal.workout.service.constant.BusinessConstants;
import com.cognizant.internal.workout.service.exception.BusinessException;


/**
 * Database Access Configuration
 */
@Configuration
@EnableTransactionManagement
public class DatabaseAccessConfig {

	private static final String WORKOUT_DATA_SOURCE                   = "DBDataSource";   
    
    private static final String WORKOUT_SQL_MAPPER                    = "WorkoutSqlMapper";
    private static final String WORKOUT_SQL_MAPPER_BASE_PACKAGE       = "com.cognizant.internal.workout.service.mapper";
    private static final String WORKOUT_SQL_SESSION_FACTORY           = "WorkoutSqlSessionFactory";

    private static final String WORKOUT_TRANSACTION_MANAGER           = "WorkoutTransactionManager";
    

    /**
     * Get Database Properties
     *
     * @param inProperties the database properties
     * @return Properties all properties used by mapper
     */
    @Bean
    @Primary
    public Properties getDatabaseProperties() {
        final Properties theProperties = new Properties();
        theProperties.setProperty(BusinessConstants.PROP_DEFAULT_FETCH_COUNT, "100");
        return theProperties;
    }

    /**
     * DataSource
     *
     * @return DataSource the MySql data source
     */
    @Bean(name = WORKOUT_DATA_SOURCE)
    @Primary
    public DataSource getPDBDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //dataSource.setUrl("jdbc:sqlserver://SMSPBDJDLDB01\\INSTANCE2");
        dataSource.setUrl("jdbc:mysql://10.245.231.193:3306/workout");
        dataSource.setUsername("root");
        dataSource.setPassword("Cts1234#");
        return dataSource;
    }
    
    /**
     * SQL Mapper
     *
     * @return MapperScannerConfigurer the mapper configuration
     */
    @Bean(name = WORKOUT_SQL_MAPPER)
    public MapperScannerConfigurer getPHVPDBSqlMapperConfigurer() {
        final MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(WORKOUT_SQL_MAPPER_BASE_PACKAGE);
        configurer.setSqlSessionFactoryBeanName(WORKOUT_SQL_SESSION_FACTORY);
        return configurer;
    }

    /**
     * Define SqlSessionFactory
     *
     * @param inDataSource the data source
     * @param inProperties the database properties
     * @return SqlSessionFactory the SQL session factory
     * @throws BusinessException it throws exception if there is any kind of error occurred during fetching data
     */
    @Bean(name = WORKOUT_SQL_SESSION_FACTORY)
    public SqlSessionFactory getPHVPDBSqlSessionFactory(@Qualifier(WORKOUT_DATA_SOURCE) final DataSource inDataSource, final Properties inProperties) throws BusinessException {
        return prepareSqlSessionFactory(inDataSource, inProperties);
    }
    
    /**
     * Define DataSourceTransactionManager
     *
     * @param inDataSource the data source
     * @return returns the transaction manager
     */
    @Bean(name = WORKOUT_TRANSACTION_MANAGER)
    public DataSourceTransactionManager getPHVPDBTransactionManager(@Qualifier(WORKOUT_DATA_SOURCE) final DataSource inDataSource) {
        return new DataSourceTransactionManager(inDataSource);
    }
    
    /**
     * Prepare SqlSession Factory
     *
     * @param inDataSource the data source for which session will be created
     * @param inProperties the database properties
     * @return SqlSessionFactory the SQL session factory for given data source
     * @throws BusinessException
     */
    private SqlSessionFactory prepareSqlSessionFactory(final DataSource inDataSource, final Properties inProperties) throws BusinessException {
        try {
            final SqlSessionFactoryBean theSqlSessionFactoryBean = new SqlSessionFactoryBean();
            theSqlSessionFactoryBean.setDataSource(inDataSource);
            theSqlSessionFactoryBean.setTypeAliasesPackage("com.cognizant.internal.workout.service.bo");
            final SqlSessionFactory theSqlSessionFactory = theSqlSessionFactoryBean.getObject();
            final org.apache.ibatis.session.Configuration theConfiguration = theSqlSessionFactory.getConfiguration();
            theConfiguration.setJdbcTypeForNull(JdbcType.NULL);
            theConfiguration.setVariables(inProperties);
            return theSqlSessionFactory;
        }catch (final Exception ex) {
            throw new BusinessException(ex);
        }
    }
}