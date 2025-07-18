package com.cognizant.account_service.controller;

import org.springframework.web.bind.annotation.*;
        import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @GetMapping("/{number}")
    public Map<String,Object> get(@PathVariable String number){
        return Map.of(
                "number",  number,
                "type",    "savings",
                "balance", 234_343
        );
    }
}
