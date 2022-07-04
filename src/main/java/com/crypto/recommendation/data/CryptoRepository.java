package com.crypto.recommendation.data;

import com.crypto.recommendation.models.Crypto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CryptoRepository extends JpaRepository<Crypto, Integer> {
    @Query(value = "SELECT Symbol, (MAX(Price)-MIN(Price))/MIN(Price) AS Price" +
            " FROM Crypto" +
            " GROUP BY Symbol" +
            " ORDER BY Price", nativeQuery = true)
    List<String> getAllNormalized();

    @Query(value = "SELECT MIN(Timestamp), MAX(Timestamp), MIN(Price), MAX(Price)" +
            "FROM Crypto " +
            "WHERE Symbol =?1 ", nativeQuery = true)
    List<String> getValuesForCrypto(String symbol);

    @Query(value = "SELECT 0 AS id, (MAX(Price)-MIN(Price))/MIN(Price) AS Price, Symbol,  ?1 AS TimeStamp " +
            "FROM Crypto " +
            "WHERE DATEDIFF(DAY, Timestamp, DATE (?1)) = 0 " +
            "GROUP BY Symbol", nativeQuery = true)
    List<Crypto> getMaxNormalizedCrypto(String day);
}
