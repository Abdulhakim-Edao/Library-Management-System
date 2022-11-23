package borrowingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableKafka
public class BorrowingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BorrowingServiceApplication.class, args);
    }

}
