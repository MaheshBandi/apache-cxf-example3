package apachecxfexample2;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mahesh.ws.example.CustomerOrderWsImplService;
import com.mahesh.ws.trainings.CustomerOrdersPortType;
import com.mahesh.ws.trainings.GetOrdersRequest;
import com.mahesh.ws.trainings.GetOrdersResponse;
import com.mahesh.ws.trainings.Order;

@SpringBootApplication
public class ApacheCxfExample3Application {

	public static void main(String[] args) throws MalformedURLException {
		//SpringApplication.run(ApacheCxfExample3Application.class, args);
		CustomerOrderWsImplService service = new CustomerOrderWsImplService(new URL("http://localhost:8080/wsdlfirstws/customerordersservice?wsdl"));
		CustomerOrdersPortType customerOrderWsImplPort = service.getCustomerOrderWsImplPort();
	
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerOrderWsImplPort.getOrders(request);
		List<Order> order = response.getOrder();
		System.out.println(order.size());
	}

}
	