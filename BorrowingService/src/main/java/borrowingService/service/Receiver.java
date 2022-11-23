package borrowingService.service;

import borrowingService.domain.BookDTO;
import borrowingService.domain.CustomerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Receiver {
    @Autowired
    BorrowingService borrowingService;

    BookDTO book;
    CustomerDTO customer;

    @KafkaListener(topics = "book", groupId = "group_id")
    public void receiveMessage(String message) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            book = objectMapper.readValue(message, BookDTO.class);
            borrowingService.updateByIsbn(book.getIsbn(), book.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "customer", groupId = "group_id")
    public void receiveMessage2(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            customer = objectMapper.readValue(message, CustomerDTO.class);
            borrowingService.updateByCustomerNumber(customer.getCustomerNumber(), customer.getName());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
