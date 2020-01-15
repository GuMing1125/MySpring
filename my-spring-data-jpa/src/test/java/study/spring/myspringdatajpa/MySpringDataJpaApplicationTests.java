package study.spring.myspringdatajpa;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import study.spring.myspringdatajpa.entity.Customer;
import study.spring.myspringdatajpa.repository.CustomerRepository;

@SpringBootTest
class MySpringDataJpaApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(MySpringDataJpaApplicationTests.class);
    @Autowired
    CustomerRepository repository;

    @Test
    void contextLoads() {
        //save a few customers
        repository.save(new Customer("jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));

        //获取所有客户
        log.info("Customers found with findAll: ");
        log.info("--------------------------------");
        for (Customer customer : repository.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // 通过ID获取单个客户
        Customer customer = repository.findById(1L);
        log.info("Customer found with findById(1L):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");

        // 按姓氏获取客户
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        repository.findByLastName("Bauer").forEach(bauer -> {
            log.info(bauer.toString());
        });
        // for (Customer bauer : repository.findByLastName("Bauer")) {
        //  log.info(bauer.toString());
        // }
        log.info("");
    }

}
