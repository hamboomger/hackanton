package com.hamboomger

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

/**
 * @author ddorochov
 */
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class AppConfiguration {

    @Bean fun datasource() : DataSource {
        val builder = EmbeddedDatabaseBuilder()
        return builder.setType(EmbeddedDatabaseType.H2).build()
    }

    @Bean fun entityManagerFactory() : LocalContainerEntityManagerFactoryBean {
        val vendor = HibernateJpaVendorAdapter()
        vendor.setGenerateDdl(true)

        val factory = LocalContainerEntityManagerFactoryBean()
        factory.jpaVendorAdapter = vendor
        factory.setPackagesToScan("com.hamboomger")
        factory.dataSource = datasource()
        return factory
    }

    @Bean fun platformTransactionManager(entityManagerFactory: EntityManagerFactory)
            : PlatformTransactionManager {
        val transactionManager = JpaTransactionManager()
        transactionManager.entityManagerFactory = entityManagerFactory
        return transactionManager
    }

}