package hello;

import hello.DTO.CustomerDTO;
import hello.Repositories.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        List<CustomerDTO> existingAntons = repository.findByFirstName("Anton");
        if (existingAntons.isEmpty()) {
            System.out.println("Adding new Anton");
            repository.save(new CustomerDTO("Anton", "Test"));
        }
        else {
            System.out.println("Anton was there!");
        }

//        try {
//            Scanner scanIn = new Scanner(System.in);
//            System.out.println("Press enter to exit application");
//            scanIn.nextLine();
//        } finally {
//            context.close();
//        }
    }
}
