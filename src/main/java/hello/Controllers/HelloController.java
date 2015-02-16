package hello.Controllers;

import hello.DTO.CustomerDTO;
import hello.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HelloController {

    @Autowired
    private CustomerRepository _customerRepository;

    @RequestMapping("/webGreeting")
    public String webGreeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        ArrayList<CustomerDTO> list = new ArrayList<CustomerDTO>(_customerRepository.findByFirstName(name));
        if (!list.isEmpty()) {
            model.addAttribute("name", list.get(0).toString());
        }

        return "greeting";
    }
}
