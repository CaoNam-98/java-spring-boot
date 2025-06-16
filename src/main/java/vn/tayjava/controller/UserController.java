package vn.tayjava.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.tayjava.dto.UserRequestDTO;
import vn.tayjava.dto.response.ResponseData;
import vn.tayjava.dto.response.ResponseError;
import vn.tayjava.dto.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
// Do code lằng nhằng nên ta chuyển sang dùng generic để thay thế
//    @Operation(summary = "summary", description = "description", responses = {
//            @ApiResponse(responseCode="201", description = "User added sucessfully",
//                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//                    examples = @ExampleObject(name = "ex name", summary = "ex summary", value = """
//                            {
//                                "status": 201,
//                                "message": "User added successfully",
//                                "data": 1
//                            }
//                            """ )
//                )
//            )
//    })
    @PostMapping("/")
    // @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO user) {
        System.out.println("Request add user: " + user.getFirstName());
        //return new ResponseData<>(HttpStatus.CREATED.value(), "user add successfully", 1);
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), "can not create user");
    }

    @Operation(summary = "summary", description = "description", responses = {
            @ApiResponse(responseCode="202", description = "User updated sucessfully",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(name = "ex name", summary = "ex summary", value = """
                            {
                                "status": 202,
                                "message": "User updated successfully",
                                "data": null
                            }
                            """ )
                    )
            )
    })
    @PutMapping("/{userId}")
    // @ResponseStatus(HttpStatus.ACCEPTED)
    // Không có param cho data thì thêm ?
    public ResponseData<?> updateUser(@PathVariable int userId, @Valid @RequestBody UserRequestDTO user) { // Thêm @Valid để validate data request
        System.out.println("Update user");
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "user updated successfully");
    }

    @PatchMapping("/{userId}")
    // @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseData<?> changeUserStatus(@PathVariable @Min(1) int userId, @Min(1) @RequestParam int status) { // Gán @Min(1) trước hay sau anotation gì cũng đươc
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "user status changed");
    }

    @DeleteMapping("/{userId}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseData<?> deleteUser(@Min(1) @PathVariable int userId){
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "user deleted successfully");
    }

    @GetMapping("/{userId}")
    // @ResponseStatus(HttpStatus.OK)
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
        // return new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789");
        return new ResponseData<>(HttpStatus.OK.value(), "user", new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"));
    }

    @GetMapping("/list")
    // @ResponseStatus(HttpStatus.OK)
    public ResponseData<List<UserRequestDTO>> getAllUsers(@RequestParam(required=false) String email, @RequestParam(defaultValue="0") int pageNo, @RequestParam(defaultValue="10") int pageSize) {
        System.out.println("Get user list");
        return new ResponseData<>(HttpStatus.OK.value(), "users", List.of(
                new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789"),
                new UserRequestDTO("Tay", "Java", "admin@tayjava.vn", "0123456789")
        ));
    }
}
