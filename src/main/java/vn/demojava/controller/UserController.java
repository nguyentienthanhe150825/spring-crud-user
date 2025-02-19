package vn.demojava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import vn.demojava.dto.request.UserRequestDTO;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") int id, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request Update UserId = " + id);
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable("userId") int id, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status, userId = " + id + " with status is " + status);
        return "User status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable("userId") int id) {
        System.out.println("Request delete userId = " + id);

        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable("userId") int id) {
        System.out.println("Request get user by userId = " + id);
        return new UserRequestDTO("Nguyen Van", "A", "0964593840", "nguyenthanh@gmail.com");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers() {
        List<UserRequestDTO> listUsers = new ArrayList<>();
        UserRequestDTO user1 = new UserRequestDTO("Nguyen Van", "A", "0964593840", "xyz@gmail.com");
        UserRequestDTO user2 = new UserRequestDTO("Tran Hoai", "B", "0101020302", "abc@gmail.com");
        listUsers.add(user1);
        listUsers.add(user2);
        return listUsers;
    }
}
