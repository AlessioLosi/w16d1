package com.example.w16d1.Controller;

import com.example.w16d1.Entities.Blogpost;
import com.example.w16d1.Payload.BlogpostPayload;
import com.example.w16d1.Service.BlogpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogpostController {
    @Autowired
    private BlogpostService BpS;

    // 1. GET http://localhost:3001/users
    @GetMapping
    public List<Blogpost> getBLogposts() {
        return this.BpS.findAll();
    }

    // 2. POST http://localhost:3001/users (+ payload) --> 201
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    public Blogpost createBlogpost(@RequestBody BlogpostPayload body) {
        return this.BpS.saveBlogpost(body);
    }

    // 3. GET http://localhost:3001/users/{userId}
    @GetMapping("/{postId}")
    public Blogpost findPostById(@PathVariable int blogpostId) {
        return this.BpS.findById(blogpostId);
    }


    // 4. PUT http://localhost:3001/users/{userId} (+ payload)
    @PutMapping("/{postId}")
    public Blogpost findPostByIdAndUpdate(@PathVariable int BlogpostId, @RequestBody BlogpostPayload body) {
        return this.BpS.findByIdAndUpdate(BlogpostId, body);
    }


    // 5. DELETE http://localhost:3001/users/{userId} --> 204
    @DeleteMapping("/{postId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    public void findPostByIdAndDelete(@PathVariable int BlogpostId) {
        this.BpS.findByIdAndDelete(BlogpostId);
    }
}
