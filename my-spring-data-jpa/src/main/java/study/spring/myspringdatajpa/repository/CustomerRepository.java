package study.spring.myspringdatajpa.repository;

import org.springframework.data.repository.CrudRepository;
import study.spring.myspringdatajpa.entity.Customer;

import java.util.List;

/**
 * 项目名称: MySpring
 * 描述: [类型描述]
 * 创建时间: 2020-01-15
 *
 * @author YangHaiBo
 * @version v1.0
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
