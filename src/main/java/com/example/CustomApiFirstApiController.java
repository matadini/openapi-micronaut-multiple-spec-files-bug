package com.example;


import com.example.first.api.CustomApiFirstApi;
import com.example.first.model.FirstGetResponse;
import io.micronaut.http.annotation.Controller;
import jakarta.validation.Valid;

import java.util.List;

@Controller
public class CustomApiFirstApiController implements CustomApiFirstApi {


    @Override
    public List<@Valid FirstGetResponse> firstGet() {
        return List.of();
    }
}
