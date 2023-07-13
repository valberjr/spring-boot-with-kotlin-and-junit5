package com.example.kotlinspringboot.datasource.network

import com.example.kotlinspringboot.datasource.BankDataSource
import com.example.kotlinspringboot.models.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository(value = "network")
class NetworkDatasource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {
    override fun retrieveBanks(): Collection<Bank> {
        val response: ResponseEntity<BankList> =
            restTemplate.getForEntity<BankList>("https://demo2907128.mockable.io/banks")
        return response.body?.results
            ?: throw IOException("Couldn't retrieve banks from network")
    }

    override fun retrieveBank(accountNumber: String): Bank {
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNumber: String) {
        TODO("Not yet implemented")
    }
}