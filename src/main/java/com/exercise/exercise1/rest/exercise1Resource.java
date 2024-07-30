package com.exercise.exercise1.rest;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class exercise1Resource {

    @GetMapping("/calculation")
    public Float calculationTwoNumbers(Float num1, Float num2, Character operator) {
        Float result = null;
        if (num1 != null && num2 != null) {
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else {
                        System.out.println("Loi! Mau so phai khac 0!");
                    }
                    break;
                default:
                    System.out.println("Sai cu phap toan tu!");
            }
        }
        return result;
    }

    @PostMapping("/movie")
    public MovieResponse movieInfo(@RequestBody MovieRequest movieRequest){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(movieRequest.getName().toUpperCase());
        movieResponse.setAuthor(movieRequest.getAuthor().toUpperCase());
        movieResponse.setYearOfRelease(movieRequest.getYearOfRelease());
        return movieResponse;
    }

}
