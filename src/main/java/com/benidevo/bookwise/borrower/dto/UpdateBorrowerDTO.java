package com.benidevo.bookwise.borrower.dto;

import com.benidevo.bookwise.borrower.entity.Borrower;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UpdateBorrowerDTO {
    private Long id;

    @Size(min = 3, max = 20)
    private String firstName;

    @Size(min = 3, max = 20)
    private String lastName;

    @Email
    private String email;

    @Size(min = 10, max = 255)
    private String address;

    public UpdateBorrowerDTO(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void updateFields(Borrower borrower) {
        if (this.firstName != null) {
            borrower.setFirstName(this.firstName);
        }
        if (this.lastName != null) {
            borrower.setLastName(this.lastName);
        }
        if (this.email != null) {
            borrower.setEmail(this.email);
        }
        if (this.address != null) {
            borrower.setAddress(this.address);
        }
    }

}
