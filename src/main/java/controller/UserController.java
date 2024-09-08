package controller;


import dto.ApiResponse;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import respository.respositoryInterface.IUserRespository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserRespository userRespository;


    @GetMapping("/get-all")
    public ResponseEntity findAll(){
        List<User> users = userRespository.findAll();
        ApiResponse<List> api = new ApiResponse<>(200,"success",users, null);
        return ResponseEntity.ok(api);

    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable int id){
        User u = userRespository.findById(id);
        ApiResponse<User> api = new ApiResponse<>(200,"success",u,null);
        return ResponseEntity.ok(api);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable int id){
        return ResponseEntity.ok(id);
    }


}
