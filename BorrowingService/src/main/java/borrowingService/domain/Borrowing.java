package borrowingService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//borrowing class with borrowingNumber, date, customerNumber, customer name, isbn, book title
@Document(collection = "borrowing")
public class Borrowing {

    //auto generate borrowingNumber
    @Id
    private int borrowingNumber;
    private String date;
    private int customerNumber;
    private String customerName;
    private String isbn;
    private String bookTitle;

    //constructor with auto generate borrowingNumber
    public Borrowing(String date, int customerNumber, String customerName, String isbn, String bookTitle) {
        this.date = date;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
    }

    public Borrowing(int borrowingNumber, String date, int customerNumber, String customerName, String isbn, String bookTitle) {
        this.borrowingNumber = borrowingNumber;
        this.date = date;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.isbn = isbn;
        this.bookTitle = bookTitle;
    }

    public int getBorrowingNumber() {
        return borrowingNumber;
    }

    public void setBorrowingNumber(int borrowingNumber) {
        this.borrowingNumber = borrowingNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "borrowingNumber=" + borrowingNumber + ", " +
                "date='" + date + "', " +
                "customerNumber=" + customerNumber + ", " +
                "customerName='" + customerName + "', " +
                "isbn='" + isbn + "', " +
                "bookTitle='" + bookTitle + "'}";
    }

}
