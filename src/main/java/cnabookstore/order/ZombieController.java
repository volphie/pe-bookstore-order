package cnabookstore.order;

import cnabookstore.order.external.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ZombieController {

    private boolean flag;

    @Autowired
    private CustomerService customerService;

    public ZombieController(){
        flag = true;
    }

    @GetMapping({"/isHealthy"})
    public void zombie2() throws Exception {
        if (flag)
            return;
        else
            throw new Exception("zombie.....");
    }

    @GetMapping({"/makeZombie"})
    public void getStockInputs() {

        flag = false;

    }

    @GetMapping({"/orderService/verifyCustomer/{customerId}"})
    public @ResponseBody String verifyCustomer(@PathVariable("customerId") Long customerId) {

        customerService.queryCustomer(customerId);
        return "Success...............";

    }

}
