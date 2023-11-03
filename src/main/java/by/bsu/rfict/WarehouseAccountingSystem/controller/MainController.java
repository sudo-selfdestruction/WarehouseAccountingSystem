package by.bsu.rfict.WarehouseAccountingSystem.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {
    @GetMapping("/")
    public String getMainPage() {
        return "Main";
    }
}
