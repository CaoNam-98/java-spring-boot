package vn.tayjava.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO user) {
        return "User added";
    } // Thêm @Valid để validate data request

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO user) { // Thêm @Valid để validate data request
        System.out.println("Update user");
        return "User updated";
    }

    @PatchMapping("/{userId}")
    public String changeUserStatus(@PathVariable @Min(1) int userId, @Min(1) @RequestParam int status) { // Gán @Min(1) trước hay sau anotation gì cũng đươc
        return "User Status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@Min(1) @PathVariable int userId){
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(@RequestParam(required=false) String email, @RequestParam(defaultValue="0") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
        System.out.println("Get user list");
        return List.of(new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"), new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
    }
}
