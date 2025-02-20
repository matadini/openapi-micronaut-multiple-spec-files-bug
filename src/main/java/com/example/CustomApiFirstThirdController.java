package com.example;


import com.example.third.api.CustomApiThirdApi;

import com.example.third.model.ThirdGetResponse;
import io.micronaut.http.annotation.Controller;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class CustomApiFirstThirdController implements CustomApiThirdApi {


    @Override
    public List<@Valid ThirdGetResponse> thirdGet() {
        return List.of();
    }
}
