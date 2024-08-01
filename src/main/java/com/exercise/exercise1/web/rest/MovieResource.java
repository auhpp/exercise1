package com.exercise.exercise1.web.rest;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MovieResource {

    private MovieService movieService;

    public MovieResource(@Qualifier("reverseMovieService") MovieService movieService) {
        this.movieService = movieService;
    }

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
    public MovieResponse movieInfo(@RequestBody MovieRequest movieRequest) {
        return movieService.getMovieResponse(movieRequest);
    }

}
