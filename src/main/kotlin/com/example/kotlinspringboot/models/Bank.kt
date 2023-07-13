package com.example.kotlinspringboot.models

import com.fasterxml.jackson.annotation.JsonProperty

class Bank(
    @JsonProperty("account_number")
    val accountNumber: String,

    @JsonProperty("trust")
    val trust: Double,

    @JsonProperty("default_transaction_fee")
    val transactionFee: Int
)