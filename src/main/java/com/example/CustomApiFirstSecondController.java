package com.example;


import com.example.second.api.CustomApiSecondApi;

import com.example.second.model.SecondGetResponse;
import io.micronaut.http.annotation.Controller;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class CustomApiFirstSecondController implements CustomApiSecondApi {


    @Override
    public List<@Valid SecondGetResponse> secondGet() {
        return List.of();
    }
}
