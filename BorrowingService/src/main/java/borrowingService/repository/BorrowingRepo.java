package borrowingService.repository;

import borrowingService.domain.Borrowing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//borrowing repository from mongodb
@Repository
public interface BorrowingRepo extends MongoRepository<Borrowing, Integer> {

    String findById(int borrowingNumber);

    void deleteById(int borrowingNumber);

    //update using isbn
    void updateByIsbn(String isbn, String bookTitle);

    //update using customerNumber
    void updateByCustomerNumber(int customerNumber, String customerName);

}
