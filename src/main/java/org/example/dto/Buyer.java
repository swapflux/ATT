package org.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Buyer {

    @NotBlank(message = "Buyer id cannot be blank")
    private String buyerId;

    @NotBlank(message = "Buyer name cannot be blank")
    private String buyerName;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;

    // -------- GETTERS --------

    public String getBuyerId() {
        return buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // -------- SETTERS --------

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}