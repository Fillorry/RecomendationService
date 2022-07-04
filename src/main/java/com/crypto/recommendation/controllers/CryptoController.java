package com.crypto.recommendation.controllers;

import com.crypto.recommendation.models.Crypto;
import com.crypto.recommendation.services.CryptoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CryptoController {
    private final CryptoService cryptoService;
    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("/prices")
    public List<Double> getAllStaff(Model model){
        List<Double> cryptos = cryptoService.getAllPrices();
        model.addAttribute("prices",  cryptos);
        return cryptos;
    }

    @GetMapping("/values")
    public List<String> getValues(Model model){
        List<String> cryptos = cryptoService.getValues();
        model.addAttribute("values",  cryptos);
        return cryptos;
    }

}
