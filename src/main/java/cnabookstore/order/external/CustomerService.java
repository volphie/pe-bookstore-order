
package cnabookstore.order.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="customer", url="${api.url.customer}")
public interface CustomerService {

    @RequestMapping(method= RequestMethod.GET, path="/customers/{customerId}")
    public Customer queryCustomer(@PathVariable("customerId") Long customerId);

}