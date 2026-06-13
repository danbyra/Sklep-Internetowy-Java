package com.example.sklepinternetowy.kontroler;

import lombok.Locked;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/summary")
public class SummaryControler {

    @GetMapping()
    public String showSummary() {
        return "summary";
    }
}
