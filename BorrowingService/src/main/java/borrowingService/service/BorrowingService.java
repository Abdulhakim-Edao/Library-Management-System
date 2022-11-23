package borrowingService.service;

import borrowingService.domain.Borrowing;
import borrowingService.repository.BorrowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class BorrowingService {

    //Autowire borrowingRepo and execute the methods

    @Autowired
    BorrowingRepo borrowingRepo;

    //add borrowing using isbn, customerNumber, customerName, bookTitle
    public void add(String date, int customerNumber, String customerName, String isbn, String bookTitle){
        borrowingRepo.save(new Borrowing(date, customerNumber, customerName, isbn, bookTitle));
    }

    public String getBorrowing(int borrowingNumber) {
        return borrowingRepo.findById(borrowingNumber);
    }

    public String getAllBorrowing() {
        return borrowingRepo.findAll().toString();
    }

    public void update(int borrowingNumber, String date, int customerNumber, String customerName, String isbn, String bookTitle) {
        borrowingRepo.save(new Borrowing(borrowingNumber, date, customerNumber, customerName, isbn, bookTitle));
    }

    public void delete(int borrowingNumber) {
        borrowingRepo.deleteById(borrowingNumber);
    }

    //update using isbn
    public void updateByIsbn(String isbn, String bookTitle){
        borrowingRepo.updateByIsbn(isbn, bookTitle);
    }

    //update using customerNumber
    public void updateByCustomerNumber(int customerNumber, String customerName){
        borrowingRepo.updateByCustomerNumber(customerNumber, customerName);
    }
}
