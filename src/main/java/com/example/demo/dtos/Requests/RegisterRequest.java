package com.example.demo.dtos.Requests;

public class RegisterRequest {
    String firstName;
    String lastName;
    String username;
    String validVoter_sCardNumber;
    String password;
    int age;


    @Override
    public String toString() {
        return "RegisterRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", validVoter_sCardNumber='" + validVoter_sCardNumber + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getValidVoter_sCardNumber() {
        return validVoter_sCardNumber;
    }

    public void setValidVoter_sCardNumber(String validVoter_sCardNumber) {
        this.validVoter_sCardNumber = validVoter_sCardNumber;
    }
}
