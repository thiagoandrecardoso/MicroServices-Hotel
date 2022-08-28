package com.example.managerhotel.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manager-hotel")
@RequiredArgsConstructor
public class ManagerHotelController {

    private final ManagerHotelService managerHotelService;

    @GetMapping
    public String status() {
        return "Ok";
    }

}
