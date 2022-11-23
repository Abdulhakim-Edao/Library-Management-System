package borrowingService.controller;

import borrowingService.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class BorrowingController {

    //Autowire borrowingService and execute the methods

    @Autowired
    BorrowingService borrowingService;

    @Autowired
    CustomerFeignClient customerFeignClient;

    @Autowired
    BookFeignClient bookFeignClient;

    // borrowing using isbn and customerNumber
    @RequestMapping("/borrowing/{isbn}/{customerNumber}")
    public void addBorrowing(@PathVariable String isbn, @PathVariable int customerNumber){
        //create today's date
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String customerName = customerFeignClient.getCustomerName(customerNumber);
        String bookTitle = bookFeignClient.getBookTitle(isbn);
        borrowingService.add(date, customerNumber, customerName, isbn, bookTitle);
    }

    //get borrowing using borrowingNumber
    @RequestMapping("/borrowing/{borrowingNumber}")
    public String getBorrowing(@PathVariable int borrowingNumber){
        return borrowingService.getBorrowing(borrowingNumber);
    }

    //get all borrowing
    @RequestMapping("/borrowing")
    public String getAllBorrowing(){
        return borrowingService.getAllBorrowing();
    }

    //update borrowing using borrowingNumber, isbn, customerNumber read from request body
    @RequestMapping("/borrowing/{borrowingNumber}/{isbn}/{customerNumber}")
    public void updateBorrowing(@PathVariable int borrowingNumber, @PathVariable String isbn, @PathVariable int customerNumber){
        //create today's date
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());

        String customerName = customerFeignClient.getCustomerName(customerNumber);
        String bookTitle = bookFeignClient.getBookTitle(isbn);
        borrowingService.update(borrowingNumber, date, customerNumber, customerName, isbn, bookTitle);
    }

    //delete borrowing using borrowingNumber
    @RequestMapping("/borrowing/delete/{borrowingNumber}")
    public void deleteBorrowing(@PathVariable int borrowingNumber){
        borrowingService.delete(borrowingNumber);
    }

    @FeignClient(name = "CustomerService")
    interface CustomerFeignClient{
        @RequestMapping("/customer/{customerNumber}")
        public String getCustomerName(@PathVariable int customerNumber);
    }

    @FeignClient(name = "BookService")
    interface BookFeignClient{
        ///get book title using isbn
        @RequestMapping("/book/{isbn}")
        public String getBookTitle(@PathVariable String isbn);
    }

}
