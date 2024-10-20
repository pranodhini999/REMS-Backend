package com.demo.RestApis;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {

    private final JdbcTemplate jdbcTemplate;

    public CityController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/city")
    public String registerCity(@RequestBody City city) {
        String sql = "INSERT INTO city (name, state, country) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, city.getName(), city.getState(), city.getCountry());
            return "City registered successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failed.";
        } 
    }

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        String sql = "SELECT id, name, state, country FROM city"; // Include ID
        List<City> cities = jdbcTemplate.query(sql, new CityRowMapper());
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @PutMapping("/city/{id}")
    public ResponseEntity<String> editCity(@PathVariable int id, @RequestBody City city) {
        String sql = "UPDATE city SET name = ?, state = ?, country = ? WHERE id = ?";
        try {
            int updatedRows = jdbcTemplate.update(sql, city.getName(), city.getState(), city.getCountry(), id);
            if (updatedRows > 0) {
                return new ResponseEntity<>("City updated successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("City not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Update failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable int id) {
        String sql = "DELETE FROM city WHERE id = ?";
        try {
            int deletedRows = jdbcTemplate.update(sql, id);
            if (deletedRows > 0) {
                return new ResponseEntity<>("City deleted successfully!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("City not found.", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Deletion failed.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static class CityRowMapper implements RowMapper<City> {
        @Override
        public City mapRow(ResultSet rs, int rowNum) throws SQLException {
            City city = new City();
            city.setId(rs.getInt("id")); // Map the ID
            city.setName(rs.getString("name"));
            city.setState(rs.getString("state"));
            city.setCountry(rs.getString("country"));
            return city;
        }
    }
}
