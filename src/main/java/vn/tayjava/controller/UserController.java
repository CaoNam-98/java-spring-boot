package vn.tayjava.controller;

import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

// Cho nó biết đây là tầng controller
@RestController
// Cho nó biết có thể nhận request
@RequestMapping("/user")
public class UserController {

    // @PostMapping("/", headers = "apiKey=v1.0")
    // 2 cách viết @PostMapping("/", headers = "apiKey=v1.0") và @RequestMapping(method = POST, path="/", headers = "apiKey=v1.0") là như nhau nhé
    // headers: muốn sau này đễ maintain thì nên thêm headers này vào
    @RequestMapping(method = POST, path="/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO user) {
        return "User added";
    }

    @PutMapping("/{userId}")
    // Thêm PathVariable để lấy giá trị từ userId hoặc có thể viết @PathVariable("userId") int id
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO user) {
        System.out.println("Update user");
        return "User updated";
    }

    @PatchMapping("/{userId}")
    // Thêm PathVariable để lấy giá trị từ userId hoặc có thể viết @PathVariable("userId") int id
    // Cần truyền trên trạng thái của nó nữa nên để là @RequestParam và dạng parameter sau dấu ?
    // Example: /user/1?status=true
    // Nếu ta để @RequestParam boolean status nghĩa laf bắt buộc phải nhập giá trị cho status
    // Nếu ta muốn status là trường không bắt buộc thì có thể dùng @RequestParam boolean status
    public String changeUserStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
        return "User Status changed";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
        return "User deleted";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789");
    }

    @GetMapping("/list")
    // @RequestParam(required=false) nghĩa là trường này nếu không nhập thì cũng sẽ không bị lỗi
    // @RequestParam(defaultValue="0") nếu không nhập thì sẽ lấy mặc định là 0, Ngược lại thì lấy theo giá trị mà mình nhập
    public List<UserRequestDTO> getAllUsers(@RequestParam(required=false) String email, @RequestParam(defaultValue="0") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
        System.out.println("Get user list");
        return List.of(new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"), new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
    }
}
