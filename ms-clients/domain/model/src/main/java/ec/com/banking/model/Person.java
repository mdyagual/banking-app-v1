package ec.com.banking.model;

public abstract class Person {
    protected String name;
    protected String genre;
    protected Integer age;
    protected String idNumber;
    protected String address;
    protected String phone;

    public Person(String name, String genre, Integer age, String idNumber, String address, String phone) {
        this.name = name;
        this.genre = genre;
        this.age = age;
        this.idNumber = idNumber;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
