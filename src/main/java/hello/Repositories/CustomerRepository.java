package hello.Repositories;

import hello.DTO.CustomerDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerDTO, Long> {

    List<CustomerDTO> findByLastName(String lastName);
    List<CustomerDTO> findByFirstName(String firstName);
}
