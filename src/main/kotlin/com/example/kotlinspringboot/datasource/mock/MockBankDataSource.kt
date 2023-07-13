package com.example.kotlinspringboot.datasource.mock

import com.example.kotlinspringboot.datasource.BankDataSource
import com.example.kotlinspringboot.models.Bank
import org.springframework.stereotype.Repository

@Repository(value = "mock")
class MockBankDataSource : BankDataSource {
    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100)
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: Bank): Bank {
        require(!banks.any { it.accountNumber == bank.accountNumber }) { "Bank with account number ${bank.accountNumber} already exists" }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val currentNumber = banks.firstOrNull() { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")
        banks.remove(currentNumber)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val account = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
        banks.remove(account)
    }

}