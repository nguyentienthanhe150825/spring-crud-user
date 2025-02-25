package vn.demojava.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import vn.demojava.dto.request.UserRequestDTO;
import vn.demojava.dto.response.ResponseData;
import vn.demojava.dto.response.ResponseSuccess;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable("userId") int id, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request Update UserId = " + id);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@Min(1) @PathVariable("userId") int id,
            @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status, userId = " + id + " with status is " + status);
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User Status changed");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@Min(1) @PathVariable("userId") int id) {
        System.out.println("Request delete userId = " + id);

        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
    }

    @GetMapping("/{userId}")
    public ResponseData<UserRequestDTO> getUser(@Min(1) @PathVariable("userId") int id) {
        System.out.println("Request get user by userId = " + id);
        return new ResponseData<>(HttpStatus.OK.value(), "User",
                new UserRequestDTO("Nguyen Van", "A", "0964593840", "nguyenthanh@gmail.com"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUsers(@RequestParam(defaultValue = "0", required = false) int pageNo,
            @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize) {
        List<UserRequestDTO> listUsers = new ArrayList<>();
        UserRequestDTO user1 = new UserRequestDTO("Nguyen Van", "A", "0964593840", "xyz@gmail.com");
        UserRequestDTO user2 = new UserRequestDTO("Tran Hoai", "B", "0101020302", "abc@gmail.com");
        listUsers.add(user1);
        listUsers.add(user2);
        return new ResponseData<>(HttpStatus.OK.value(), "User", listUsers);
    }
}
