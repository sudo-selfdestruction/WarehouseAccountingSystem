package by.bsu.rfict.WarehouseAccountingSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public void getMainPage() {

    }
}
