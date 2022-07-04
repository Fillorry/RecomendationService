package com.crypto.recommendation.services;

import com.crypto.recommendation.data.CryptoRepository;
import com.crypto.recommendation.models.Crypto;
import com.crypto.recommendation.models.Symbol;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CryptoService {
    private final CryptoRepository cryptoRepository;

    public CryptoService(CryptoRepository cryptoRepository) {
        this.cryptoRepository = cryptoRepository;
    }

    public List<Double> getAllPrices() {
        List<Crypto> allCryptos = cryptoRepository.findAll();
        return allCryptos.stream().map(Crypto::getPrice).collect(Collectors.toList());
    }

    public List<String> getValues() {
        List<String> values = new ArrayList<>();
        List<Crypto> allCryptos = cryptoRepository.findAll();
        Crypto crypto;
        crypto = allCryptos
                .stream()
                .min(Comparator.comparing(Crypto::getTimestamp))
                .orElseThrow(NoSuchElementException::new);
        values.add(String.valueOf(crypto.getTimestamp()));

        crypto = allCryptos
                .stream()
                .max(Comparator.comparing(Crypto::getTimestamp))
                .orElseThrow(NoSuchElementException::new);
        values.add(String.valueOf(crypto.getTimestamp()));

        crypto = allCryptos
                .stream()
                .min(Comparator.comparing(Crypto::getPrice))
                .orElseThrow(NoSuchElementException::new);
        values.add(String.valueOf(crypto.getPrice()));

        crypto= allCryptos
                .stream()
                .max(Comparator.comparing(Crypto::getPrice))
                .orElseThrow(NoSuchElementException::new);
        values.add(String.valueOf(crypto.getPrice()));

        return values;
    }

    public List<String> getAllNormalizedCrypto() {
        return cryptoRepository.getAllNormalized();
    }

    public List<String> getValuesForCrypto(Symbol symbol) {
        return cryptoRepository.getValuesForCrypto(symbol.name());
    }

    public Crypto getMaxNormalizedCrypto(Date day) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String date = df.format(day);
        List<Crypto> cryptos = cryptoRepository.getMaxNormalizedCrypto(date);
        return cryptos.stream()
                .max(Comparator.comparing(Crypto::getPrice))
                .orElse(null);
    }
}
