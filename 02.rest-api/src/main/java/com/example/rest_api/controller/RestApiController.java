package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html><body><h1>HEllo Spring boot</h1></body></html>";
        return html;
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String message,
            @PathVariable(name = "age") int age,
            @PathVariable(name ="isMan") boolean isMan
    ){
        System.out.println("echo message : " + message);
        return message.toUpperCase();
    }

    //localhost:8080/api/book?category=it&issuedYear=2023&issued-month=01&issued-day=23
    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issueMonth,
            @RequestParam(name = "issued-day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issueMonth);
        System.out.println(issuedDay);
    }

    //http://localhost:8080/api/book2?category=it&issuedYear=2023&issuedMonth=01&issuedDay=23
    @GetMapping(path = "/book2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println(bookQueryParam);
    }

    @DeleteMapping(path ="/user/{userName}/delete")
    public void delete(
            @PathVariable(value = "userName") String userName
    ){
        log.info("user-name : {}" , userName);
    }
}
