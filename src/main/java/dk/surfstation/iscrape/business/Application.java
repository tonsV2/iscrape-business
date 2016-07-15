package dk.surfstation.iscrape.business;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
//@EnableJpaRepositories("dk.surfstation.iscrape.business")
@EnableJpaRepositories
public class Application {
	public Application() {
		System.out.println("sdsd");
	}

/*
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[]{"dk.surfstation.iscrape"});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
//		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
//					.addScript("classpath:schema.sql")
//					.addScript("classpath:test-data.sql")
				.build();
	}
*/
}
