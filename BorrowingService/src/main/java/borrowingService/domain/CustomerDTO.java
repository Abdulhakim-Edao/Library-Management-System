package borrowingService.domain;

//customerNumber, name, phone, email, street, city, zip
public class CustomerDTO {
    private int customerNumber;
    private String name;

    public CustomerDTO(int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
