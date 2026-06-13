package com.frudev.invoicing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wld-clients")
public class WldClientController {

    @GetMapping()
    public void getWldClients() {
        
    }
}
