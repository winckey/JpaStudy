package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class JpashopApplication {


	public static void main(String[] args) {




		SpringApplication.run(JpashopApplication.class, args);
	}

}
