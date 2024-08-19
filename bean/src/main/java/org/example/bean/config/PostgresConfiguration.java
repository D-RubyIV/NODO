package org.example.bean.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresEntityManager",
        basePackages = "org.example.bean.repository.postgres",
        transactionManagerRef = "postgresTransactionManager"
)
public class PostgresConfiguration {
    /****
     * DataSource Configuration
     ****/
    @Bean("postgresDb")
    @ConfigurationProperties(prefix = "postgres.datasource")
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().build();
    }

    /****
     * Entity Manager Configuration
     ****/
    @Bean("postgresEntityManager")
    public LocalContainerEntityManagerFactoryBean postgresEntityManager(
            EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        Map<String, Object> jpaProperties = new HashMap<>();
//        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.show_sql", "true");
        return entityManagerFactoryBuilder
                .dataSource(postgresDataSource())
                .packages("org.example.bean.model.postgres")
                .persistenceUnit("role")
                .persistenceUnit("author")
                .persistenceUnit("cat")
                .persistenceUnit("dog")
                .properties(jpaProperties)
                .build();
    }

    /****
     * Transaction Manager Configuration
     ****/
    @Bean("postgresTransactionManager")
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManager")
                                                                 LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        return new JpaTransactionManager(entityManagerFactoryBean.getObject());
    }


}