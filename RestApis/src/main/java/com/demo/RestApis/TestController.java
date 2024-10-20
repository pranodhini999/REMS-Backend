//
//
//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@SpringBootApplication
//public class TestController {
//
//    public static void main(String[] args) {
//        SpringApplication.run(TestController.class, args);
//    }
//}
//
//// CORS Configuration
//@Configuration
//class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:5173") // Replace with your frontend's URL
//                .allowedMethods("GET", "POST", "PUT", "DELETE")
//                .allowedHeaders("*")
//                .allowCredentials(true)
//                .maxAge(3600);
//    }
//}
//
//class User {
//    private String name;
//    private String email;
//    private String password;
//    private String role; // Added role field
//
//    // Getters and setters
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRole() {
//        return role;
//    }
//    
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//}
//
//// Controller for User-related endpoints
//@RestController
//@RequestMapping("/auth")
//class UserController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping("/login")
//    public Response loginUser(@RequestBody User user) {
//        // Check if the email and password match in the database
//        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
//        try {
//            User dbUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail(), user.getPassword()}, (rs, rowNum) -> {
//                User u = new User();
//                u.setName(rs.getString("name"));
//                u.setEmail(rs.getString("email"));
//                u.setPassword(rs.getString("password"));
//                u.setRole(rs.getString("role"));
//                return u;
//            });
//
//            if (dbUser != null) {
//                // User found and credentials match, return the role
//                return new Response("Login successful!", dbUser.getRole());
//            } else {
//                // Invalid email or password
//                return new Response("Invalid email or password.", null);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new Response("Login failed. Please try again.", null);
//        }
//    }

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
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getAllUsers() {
//        String sql = "SELECT name, email FROM users"; // Only select name and email
//        try {
//            List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Response class to return message and role
//    public static class Response {
//        private String message;
//        private String role;
//
//        public Response(String message, String role) {
//            this.message = message;
//            this.role = role;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public String getRole() {
//            return role;
//        }
//    }
//}





//@PostMapping("/register")
//public String registerUser(@RequestBody User user) {
//  // Insert user details into the 'users' table (create it if it doesn't exist)
//  String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
//  try {
//      jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole());
//      return "User registered successfully!";
//  } catch (Exception e) {
//      e.printStackTrace();
//      return "Registration failed.";
//  }
//}
//
//
//@GetMapping("/users")
//public ResponseEntity<List<User>> getAllUsers() {
//  String sql = "SELECT name, email FROM users"; // Only select name and email
//  try {
//      List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
//      return new ResponseEntity<>(users, HttpStatus.OK);
//  } catch (Exception e) {
//      e.printStackTrace();
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//  }
//}
//






package com.demo.RestApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class TestController {

    public static void main(String[] args) {
        SpringApplication.run(TestController.class, args);
    }

    // CORS Configuration
    @Configuration
    static class WebConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:5173") // Replace with your frontend's URL
                    .allowedMethods("GET", "POST", "PUT", "DELETE")
                    .allowedHeaders("*")
                    .allowCredentials(true)
                    .maxAge(3600);
        }
    }

    // User Entity
    static class User {
        private String name;
        private String email;
        private String password;
        private String role; // Added role field

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    // Controller for User-related endpoints
    @RestController
    @RequestMapping("/auth")
    static class UserController {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        @PostMapping("/register")
        public String registerUser(@RequestBody User user) {
            String sql = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, ?)";
            try {
                jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getPassword(), user.getRole());
                return "User registered successfully!";
            } catch (Exception e) {
                e.printStackTrace();
                return "Registration failed.";
            }
        }
        
        
        
//        @PostMapping("/login")
//        public Response loginUser(@RequestBody User user) {
//            // Check if the email and password match in the database
//            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
//            try {
//                User dbUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail(), user.getPassword()}, (rs, rowNum) -> {
//                    User u = new User();
//                    u.setName(rs.getString("name"));
//                    u.setEmail(rs.getString("email"));
//                    u.setPassword(rs.getString("password"));
//                    u.setRole(rs.getString("role"));
//                    return u;
//                });
//
//                if (dbUser != null) {
//                    // User found and credentials match, return the role
//                    return new Response("Login successful!", dbUser.getRole());
//                } else {
//                    // Invalid email or password
//                    return new Response("Invalid email or password.", null);
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                return new Response("Login failed. Please try again.", null);
//            }
//        }
//
        

        @PostMapping("/login")
        public Response loginUser(@RequestBody User user) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            try {
                User dbUser = jdbcTemplate.queryForObject(sql, new Object[]{user.getEmail(), user.getPassword()},
                        (rs, rowNum) -> {
                            User u = new User();
                            u.setName(rs.getString("name"));
                            u.setEmail(rs.getString("email"));
                            u.setPassword(rs.getString("password"));
                            u.setRole(rs.getString("role"));
                            return u;
                        });

                if (dbUser != null) {
                    return new Response("Login successful!", dbUser.getRole());
                } else {
                    return new Response("Invalid email or password.", null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return new Response("Login failed. Please try again.", null);
            }
        }

        @GetMapping("/users")
        public ResponseEntity<List<User>> getAllUsers() {
            String sql = "SELECT name, email FROM users"; // Only select name and email
            try {
                List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
                return new ResponseEntity<>(users, HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        // Response class to return message and role
        static class Response {
            private String message;
            private String role;

            public Response(String message, String role) {
                this.message = message;
                this.role = role;
            }

            public String getMessage() {
                return message;
            }

            public String getRole() {
                return role;
            }
        }
    }
}




// Add a new class for Property
class Property {
	private int id;
    private String name;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}





@RestController
@RequestMapping("/property")
class PropertyController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/add")
    public String addProperty(@RequestBody Property property) {
        String sql = "INSERT INTO property (name) VALUES (?)";
        try {
            jdbcTemplate.update(sql, property.getName());
            return "Property added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add property.";
        }
    }

//    // New API to get all properties
    @GetMapping("/all")
    public List<Property> getAllProperties() {
        String sql = "SELECT * FROM property";
        List<Property> properties = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Property.class));
        return properties;
    }
    

    // New API to edit a property
    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editProperty(@PathVariable int id, @RequestBody Property property) {
        String sql = "UPDATE property SET name = ? WHERE id = ?";
        try {
            int updatedRows = jdbcTemplate.update(sql, property.getName(), id);
            if (updatedRows > 0) {
                return ResponseEntity.ok("Property updated successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update property.");
        }
    }
    

    // New API to delete a property
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable int id) {
        String sql = "DELETE FROM property WHERE id = ?";
        try {
            int deletedRows = jdbcTemplate.update(sql, id);
            if (deletedRows > 0) {
                return ResponseEntity.ok("Property deleted successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Property not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete property.");
        }
    }
}


//Country Model
class Country {
 private String name;

 // Getter and Setter
 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }
}



@RestController
@RequestMapping("/api/")
class CountryController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to add a country
    @PostMapping("/countries")
    public ResponseEntity<String> addCountry(@RequestBody Country country) {
        String sql = "INSERT INTO country (name) VALUES (?)"; // Ensure this matches your DB
        try {
            jdbcTemplate.update(sql, country.getName());
            return new ResponseEntity<>("Country added successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add country.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to get all countries
    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountries() {
        String sql = "SELECT name FROM country"; // Ensure this matches your DB structure
        try {
            List<Country> countries = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Country.class));
            return new ResponseEntity<>(countries, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    

    @DeleteMapping("/countries/{name}")
    public ResponseEntity<String> deleteCountry(@PathVariable String name) {
        String sql = "DELETE FROM country WHERE name = ?"; // Ensure this matches your DB
        try {
            int rowsAffected = jdbcTemplate.update(sql, name);
            if (rowsAffected > 0) {
                return new ResponseEntity<>("Country deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Country not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete country.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/countries/{name}")
    public ResponseEntity<String> updateCountry(@PathVariable String name, @RequestBody Country updatedCountry) {
        String sql = "UPDATE country SET name = ? WHERE name = ?"; // Ensure this matches your DB
        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedCountry.getName(), name);
            if (rowsAffected > 0) {
                return new ResponseEntity<>("Country updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Country not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update country.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}



