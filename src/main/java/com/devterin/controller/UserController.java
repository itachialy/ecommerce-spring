package com.devterin.controller;

import com.devterin.dto.request.CreateUserRequest;
import com.devterin.dto.request.UpdateUserRequest;
import com.devterin.dto.response.ApiResponse;
import com.devterin.dto.response.UserResponse;
import com.devterin.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody(required = false)
                                                    CreateUserRequest request) {

        return ApiResponse.<UserResponse>builder()
                .message("Created user successfully.")
                .result(userService.createUser(request))
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers(){

        return ApiResponse.<List<UserResponse>>builder()
                .message("Success")
                .result(userService.getUsers())
                .build();
    }

    @PutMapping("/{userId}")
    public ApiResponse<UserResponse> updateUser(@PathVariable Long userId,
                                                @RequestBody(required = false)
                                                UpdateUserRequest request) {

    return ApiResponse.<UserResponse>builder()
            .message("Updated user successfully.")
            .result(userService.updateUser(userId,request))
            .build();
    }

    @DeleteMapping("/{userId}")
    public ApiResponse<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return ApiResponse.<Void>builder()
                .message("Deleted user successfully.")
                .build();
    }

}
