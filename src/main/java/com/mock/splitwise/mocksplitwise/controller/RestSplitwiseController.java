package com.mock.splitwise.mocksplitwise.controller;

import com.mock.splitwise.mocksplitwise.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestSplitwiseController {

    @GetMapping("/hello/{name}")
    public Response helloPath(@PathVariable String name) {
        return new Response(name);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchBooks(
            @RequestParam(required = false, defaultValue = "") String title,
            @RequestParam(required = false, defaultValue = "") String author) {

        // Your search logic here
//        return ResponseEntity.ok(1);
        return ResponseEntity.ok("Searching for title: " + title + ", author: " + author);
    }

    @GetMapping("/hello")
    public Response hello() {
        return new Response("hello");
    }

    @PostMapping("/hello")
    public String helloP(@RequestBody String name) {
        return "hello" + name;
    }
}
