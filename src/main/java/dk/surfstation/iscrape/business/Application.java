package dk.surfstation.iscrape.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories
public class Application {
	private final Database database = Database.POSTGRESQL;
//	private final Database database = Database.MYSQL;

	@PostConstruct
	public void loadDriver() {
		try {
			Class.forName("org.postgresql.Driver");
			//on classpath
		} catch(ClassNotFoundException e) {
			// not on classpath
		}
	}
/*
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.jdbc.Driver");
		driver.setUrl("jdbc:mysql://192.168.0.3/iscrape");
		driver.setUsername("root");
		driver.setPassword("skummet");
		return driver;
	}
*/

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("org.postgresql.Driver");
		driver.setUrl("jdbc:postgresql://192.168.0.3/iscrape");
		driver.setUsername("tons");
		driver.setPassword("skummet");
		return driver;
	}

/*
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
//					.addScript("classpath:schema.sql")
//					.addScript("classpath:test-data.sql")
				.build();
	}
*/
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setDatabase(database);
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan(getClass().getPackage().getName());
		factory.setDataSource(dataSource());

		return factory;
	}

	@Bean
	@Autowired
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
