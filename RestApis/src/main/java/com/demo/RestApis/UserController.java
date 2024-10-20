////
////package com.demo.RestApis;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.jdbc.core.JdbcTemplate;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController // Ensure this annotation is present
////@RequestMapping("/api") // Base path for your API
////public class UserController {
////
////    @Autowired
////    private JdbcTemplate jdbcTemplate;
////
////    @PostMapping("/register") 
////    public String registerUser(@RequestBody User user) {
////        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
////        try {
////            jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole());
////            return "User registered successfully!";
////        } catch (Exception e) {
////            e.printStackTrace();
////            return "Registration failed.";
////        }
////    }
////
////    @GetMapping("/users")
////    public ResponseEntity<List<User>> getAllUsers() {
////        String sql = "SELECT name, email FROM users"; // Only select name and email
////        try {
////            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
////            return new ResponseEntity<>(users, HttpStatus.OK);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////    }
////}
//
//
//package com.demo.RestApis;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api") // Define a base path
//public class UserController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping("/register") 
//    public String registerUser(@RequestBody User user) {
//        String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
//        try {
//            jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole());
//            return "User registered successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Registration failed.";
//        }
//    }
//}
//
