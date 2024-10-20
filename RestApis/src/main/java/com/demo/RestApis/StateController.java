//package com.demo.RestApis;
//
//@RestController
//@RequestMapping("/api/")
//public class StateController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    // Method to add a state
//    @PostMapping("/state")
//    public ResponseEntity<String> addState(@RequestBody State state) {
//        String sql = "INSERT INTO state (name, code) VALUES (?, ?)"; // Ensure this matches your DB
//        try {
//            jdbcTemplate.update(sql, state.getName(), state.getCode());
//            return new ResponseEntity<>("State added successfully!", HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to add state.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Method to get all states (optional)
//    @GetMapping("/state")
//    public ResponseEntity<List<State>> getAllStates() {
//        String sql = "SELECT name, code FROM state"; // Ensure this matches your DB structure
//        try {
//            List<State> states = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(State.class));
//            return new ResponseEntity<>(states, HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    
//    // Method to delete a state (optional)
//    @DeleteMapping("/state/{code}")
//    public ResponseEntity<String> deleteState(@PathVariable String code) {
//        String sql = "DELETE FROM state WHERE code = ?"; // Ensure this matches your DB
//        try {
//            int rowsAffected = jdbcTemplate.update(sql, code);
//            if (rowsAffected > 0) {
//                return new ResponseEntity<>("State deleted successfully!", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("State not found.", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to delete state.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    // Method to update a state (optional)
//    @PutMapping("/state/{code}")
//    public ResponseEntity<String> updateState(@PathVariable String code, @RequestBody State updatedState) {
//        String sql = "UPDATE state SET name = ? WHERE code = ?"; // Ensure this matches your DB
//        try {
//            int rowsAffected = jdbcTemplate.update(sql, updatedState.getName(), code);
//            if (rowsAffected > 0) {
//                return new ResponseEntity<>("State updated successfully!", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("State not found.", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>("Failed to update state.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//}

package com.demo.RestApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StateController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to add a state
    @PostMapping("/state")
    public ResponseEntity<String> addState(@RequestBody State state) {
        String sql = "INSERT INTO state (name, code) VALUES (?, ?)"; // Ensure this matches your DB
        try {
            jdbcTemplate.update(sql, state.getName(), state.getCode());
            return new ResponseEntity<>("State added successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to add state.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to get all states (optional)
    @GetMapping("/state")
    public ResponseEntity<List<State>> getAllStates() {
        String sql = "SELECT name, code FROM state"; // Ensure this matches your DB structure
        try {
            List<State> states = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(State.class));
            return new ResponseEntity<>(states, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Method to delete a state (optional)
    @DeleteMapping("/state/{code}")
    public ResponseEntity<String> deleteState(@PathVariable String code) {
        String sql = "DELETE FROM state WHERE code = ?"; // Ensure this matches your DB
        try {
            int rowsAffected = jdbcTemplate.update(sql, code);
            if (rowsAffected > 0) {
                return new ResponseEntity<>("State deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("State not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete state.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Method to update a state (optional)
    @PutMapping("/state/{code}")
    public ResponseEntity<String> updateState(@PathVariable String code, @RequestBody State updatedState) {
        String sql = "UPDATE state SET name = ? WHERE code = ?"; // Ensure this matches your DB
        try {
            int rowsAffected = jdbcTemplate.update(sql, updatedState.getName(), code);
            if (rowsAffected > 0) {
                return new ResponseEntity<>("State updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("State not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to update state.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
