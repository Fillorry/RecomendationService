package com.crypto.recommendation.controllers;

import com.crypto.recommendation.models.Crypto;
import com.crypto.recommendation.models.Symbol;
import com.crypto.recommendation.services.CryptoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cryptos")
public class CryptoRestController {
    private final CryptoService cryptoService;

    public CryptoRestController(CryptoService cryptoService1) {
        this.cryptoService = cryptoService1;
    }

    @GetMapping("/normalized")
    public List<String> getAllNormalizedCrypto() {
        return cryptoService.getAllNormalizedCrypto();
    }


    @GetMapping("/values")
    public List<String> getAllNormalizedCrypto(@RequestParam("symbol") Symbol symbol) {
        return cryptoService.getValuesForCrypto(symbol);
    }

    @GetMapping("/max")
    public Crypto getMaxNormalizedCrypto(@RequestParam("day") @DateTimeFormat(pattern = "yyyy-mm-dd") Date day) {
        return cryptoService.getMaxNormalizedCrypto(day);
    }
}

