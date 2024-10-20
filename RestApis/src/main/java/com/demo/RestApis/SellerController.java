//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/seller")
//public class SellerController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // Add seller details to the database
//    @PostMapping
//    public String addSeller(@RequestBody Seller seller) {
//        String sql = "INSERT INTO sellerData (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getPhoneNumber());
//            return "Seller added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add seller.";
//        }
//    }
//}
//
//
//

//
//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/seller")
//public class SellerController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // Add seller details to the database
//    @PostMapping("/details")
//    public String addSeller(@RequestBody Seller seller) {
//        String sql = "INSERT INTO sellerData (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getPhoneNumber());
//            return "Seller added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add seller.";
//        }
//    }
//
//    
//    
//    
//    
//    
//    // Add property details to the database
//    @PostMapping("/property")
//    public String addPropertyDetails(@RequestBody PropertyDetails propertyDetails) {
//        String sql = "INSERT INTO propertyData (type, squareFeet, amount) VALUES (?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, propertyDetails.getType(), propertyDetails.getSquareFeet(), propertyDetails.getAmount());
//            return "Property details added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add property details.";
//        }
//    }
//
//    // Add address details to the database
//    @PostMapping("/address")
//    public String addAddress(@RequestBody Address address) {
//        String sql = "INSERT INTO addressData (street, city, state, zipCode) VALUES (?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
//            return "Address added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add address.";
//        }
//    }
//}


//
//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//import java.util.List; // Import this for List
//import java.util.ArrayList; // Import if you're using ArrayList in your code
//
//@RestController
//@RequestMapping("/api/seller")
//public class SellerController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
////    // Add seller details to the database
//    @PostMapping("/details")
//    public String addSeller(@RequestBody Seller seller) {
//        String sql = "INSERT INTO sellerData (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
//        
//        try {
//            jdbcTemplate.update(sql, seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getPhoneNumber());
//            return "Seller added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add seller.";
//        }
//    }
////
////    // Add property details to the database
//    @PostMapping("/property")
//    public String addPropertyDetails(@RequestBody PropertyDetails propertyDetails) {
//        String sql = "INSERT INTO propertyData (type, squareFeet, amount) VALUES (?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, propertyDetails.getType(), propertyDetails.getSquareFeet(), propertyDetails.getAmount());
//            return "Property details added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add property details.";
//        }
//    }
////
////    // Add address details to the database
//    @PostMapping("/address")
//    public String addAddress(@RequestBody Address address) {
//        String sql = "INSERT INTO addressData (street, city, state, zipCode) VALUES (?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
//            return "Address added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add address.";
//        }
//    }
////
////    // Get seller details from the database
//    @GetMapping("/details")
//    public List<Seller> getSellers() {
//        String sql = "SELECT * FROM sellerData";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> 
//            new Seller(
//                rs.getString("firstName"),
//                rs.getString("lastName"),
//                rs.getString("email"),
//                rs.getString("phoneNumber")
//            )
//        );
//    }
//}
//



package com.demo.RestApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Add seller details to the database
    @PostMapping("/details")
    public String addSeller(@RequestBody Seller seller) {
        String sql = "INSERT INTO sellerData (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
        
        try {
            jdbcTemplate.update(sql, seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getPhoneNumber());
            return "Seller added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add seller.";
        }
    }

    // Add property details to the database
    @PostMapping("/property")
    public String addPropertyDetails(@RequestBody PropertyDetails propertyDetails) {
        String sql = "INSERT INTO propertyData (type, squareFeet, amount) VALUES (?, ?, ?)";

        try {
            jdbcTemplate.update(sql, propertyDetails.getType(), propertyDetails.getSquareFeet(), propertyDetails.getAmount());
            return "Property details added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add property details.";
        }
    }

    // Add address details to the database
    @PostMapping("/address")
    public String addAddress(@RequestBody Address address) {
        String sql = "INSERT INTO addressData (street, city, state, zipCode) VALUES (?, ?, ?, ?)";

        try {
            jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
            return "Address added successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add address.";
        }
    }

    // Get seller details from the database
    @GetMapping("/details")
    public List<Seller> getSellers() {
        String sql = "SELECT * FROM sellerData";
        return jdbcTemplate.query(sql, (rs, rowNum) -> 
            new Seller(
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("phoneNumber")
            )
        );
    }

    // Get property details from the database
    @GetMapping("/property")
    public List<PropertyDetails> getProperties() {
        String sql = "SELECT * FROM propertyData";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new PropertyDetails(
                rs.getString("type"),
                rs.getInt("squareFeet"),
                rs.getDouble("amount")
            )
        );
    }

    // Get address details from the database
    @GetMapping("/address")
    public List<Address> getAddresses() {
        String sql = "SELECT * FROM addressData";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
            new Address(
                rs.getString("street"),
                rs.getString("city"),
                rs.getString("state"),
                rs.getString("zipCode")
            )
        );
    }
}


//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/seller")
//public class SellerController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // Add seller details to the database
//    @PostMapping("/details")
//    public String addSeller(@RequestBody Seller seller) {
//        String sql = "INSERT INTO sellerData (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)";
//        
//        try {
//            jdbcTemplate.update(sql, seller.getFirstName(), seller.getLastName(), seller.getEmail(), seller.getPhoneNumber());
//            return "Seller added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add seller.";
//        }
//    }
//
//    // Add property details to the database
//    @PostMapping("/property")
//    public String addPropertyDetails(@RequestBody PropertyDetails propertyDetails) {
//        String sql = "INSERT INTO propertyData (type, squareFeet, amount) VALUES (?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, propertyDetails.getType(), propertyDetails.getSquareFeet(), propertyDetails.getAmount());
//            return "Property details added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add property details.";
//        }
//    }
//
//    // Add address details to the database
//    @PostMapping("/address")
//    public String addAddress(@RequestBody Address address) {
//        String sql = "INSERT INTO addressData (street, city, state, zipCode) VALUES (?, ?, ?, ?)";
//
//        try {
//            jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getState(), address.getZipCode());
//            return "Address added successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Failed to add address.";
//        }
//    }
//
//    // Get seller details from the database
//    @GetMapping("/details")
//    public List<Seller> getSellers() {
//        String sql = "SELECT * FROM sellerData";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> 
//            new Seller(
//                rs.getString("firstName"),
//                rs.getString("lastName"),
//                rs.getString("email"),
//                rs.getString("phoneNumber")
//            )
//        );
//    }
//
//    // Get property details from the database
//    @GetMapping("/property")
//    public List<PropertyDetails> getProperties() {
//        String sql = "SELECT * FROM propertyData";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> 
//            new PropertyDetails(
//                rs.getString("type"),
//                rs.getInt("squareFeet"),
//                rs.getDouble("amount")
//            )
//        );
//    }
//
//    // Get address details from the database
//    @GetMapping("/address")
//    public List<Address> getAddresses() {
//        String sql = "SELECT * FROM addressData";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> 
//            new Address(
//                rs.getString("street"),
//                rs.getString("city"),
//                rs.getString("state"),
//                rs.getString("zipCode")
//            )
//        );
//    }
//}
//

