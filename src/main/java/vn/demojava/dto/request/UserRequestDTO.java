package vn.demojava.dto.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import vn.demojava.util.EnumPattern;
import vn.demojava.util.Gender;
import vn.demojava.util.GenderSubset;
import vn.demojava.util.PhoneNumber;
import vn.demojava.util.UserStatus;

public class UserRequestDTO implements Serializable {

    @NotBlank(message = "firstName must be not blank")
    private String firstName;

    @NotNull(message = "lastName must be not null")
    private String lastName;

    // @Pattern(regexp = "^\\d{10}$", message = "phone invalid format")
    @PhoneNumber
    private String phone;

    @Email(message = "email invalid format")
    private String email;

    @NotNull(message = "dateOfBirth must be not null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateOfBirth;

    //@Pattern(regexp = "^ACTIVE|INACTIVE|NONE$", message = "status must be one in {ACTIVE, INACTIVE, NONE}")   // chỉ dùng cho String not ENUM
    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;

    @GenderSubset(anyOf = {Gender.MALE, Gender.FEMALE})
    private Gender gender;

    @NotNull(message = "username must be not null")
    private String username;

    @NotNull(message = "password must be not null")
    private String password;

    @NotEmpty(message = "addresses can not empty")
    private Set<Address> addresses;

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
