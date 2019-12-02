package com.example.config.datasource;

import com.example.config.datasource.prop.DataBase2Properties;
import com.example.utils.PojoUtil;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;
import javax.sql.DataSource;

/**
 * @Description
 * @Author cicada
 * @Date 2019-06-06 11:15
 * @Vertion 1.0
 */
@Configuration
@MapperScan(basePackages = Database2DataSourceConfiguration.BASE_PACKAGE, sqlSessionTemplateRef = "studentSqlSessionTemplateDataBase2")
public class Database2DataSourceConfiguration {

    static final String BASE_PACKAGE = "com.example.mapper.database2";

    /**
     * 对接数据库的实体层
     */
    static final String ALIASES_PACKAGE = "com.example.domain.database2";


    static final String MAPPER_LOCATION = "classpath*:/mybatis/database2/*.xml";

    @Autowired
    private DataBase2Properties dataBase2Properties;


    @Bean(name = "dataBase2DataSource")
    public DataSource getXysDataSource() {
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaProperties(PojoUtil.obj2Properties(dataBase2Properties));
        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        ds.setUniqueResourceName("dataBase2Properties");
        ds.setPoolSize(5);
        ds.setTestQuery("SELECT 1");
        return ds;
    }

    @Bean(name = "sqlSessionFactoryDataBase2")
    public SqlSessionFactory sqlSessionFactoryBlueWhale(@Qualifier("dataBase2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        VFS.addImplClass(SpringBootVFS.class);
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage(ALIASES_PACKAGE);
        // Mybatis Config
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);

        // Mybatis Mapper XML Config
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        //*.mapper.xml的地址（根据你的项目自行修改）
        sessionFactory.setMapperLocations(resolver.getResources(MAPPER_LOCATION));

        return sessionFactory.getObject();
    }


    @Bean(name = "studentSqlSessionTemplateDataBase2")
    public SqlSessionTemplate sqlSessionTemplateBlueWhale(
            @Qualifier("sqlSessionFactoryDataBase2") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

