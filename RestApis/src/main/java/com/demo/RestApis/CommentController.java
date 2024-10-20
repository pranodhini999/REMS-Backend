//package com.demo.RestApis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/comments")
//public class CommentController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @PostMapping
//    public String submitComment(@RequestBody Comment comment) {
//        // SQL query to insert comment into the database
//        String sql = "INSERT INTO comments (comment) VALUES (?)";
//
//        try {
//            // Inserting the comment into the 'comments' table
//            jdbcTemplate.update(sql, comment.getComment());
//            return "Comment submitted successfully!";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Comment submission failed.";
//        }
//    }
//}

package com.demo.RestApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Method to submit a comment
    @PostMapping
    public String submitComment(@RequestBody Comment comment) {
        String sql = "INSERT INTO comments (comment) VALUES (?)";
        try {
            jdbcTemplate.update(sql, comment.getComment());
            return "Comment submitted successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Comment submission failed.";
        }
    }

    // Method to fetch all comments
    @GetMapping
    public List<Comment> getAllComments() {
        String sql = "SELECT * FROM comments";

        return jdbcTemplate.query(sql, new RowMapper<Comment>() {
            @Override
            public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
                Comment comment = new Comment();
                comment.setId(rs.getLong("id"));
                comment.setComment(rs.getString("comment"));
                return comment;
            }
        });
    }
}
