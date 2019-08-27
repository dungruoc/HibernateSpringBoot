package io.dungmd;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.dungmd.db.PersonRepository;
import io.dungmd.model.Person;

@SpringBootApplication
@EnableJpaRepositories("io.dungmd.db")
@EntityScan("io.dungmd.model")
public class HibernateDemoApplication implements CommandLineRunner {

	@Autowired
    DataSource dataSource;
	
	@Autowired
	private PersonRepository personRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testRead();
		testSave();
	}
	
	void testSave() {
		Person person = new Person(9, "FirstName9", "LastName");
		personRepository.save(person);
	}
	
	void testRead() {
		personRepository.findAll().forEach(person -> System.out.println(person.toString()));
	}
}

