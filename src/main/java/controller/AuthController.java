package controller;


import dto.ApiResponse;
import entity.User;
import exception.AppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ServiceInterface.IAuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    IAuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody User user) throws AppException {
        boolean check = authService.register(user);
        if(check){
            user.setPassword(null);
            ApiResponse<User> apiResponse = new ApiResponse<User>(200, "success", user,null);
            return ResponseEntity.status(201).body(apiResponse);
        }
       else{
           return null;
        }

    }
}
