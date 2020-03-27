package com.cypherx.coronavirus.model

class IndiaStateResult(
    val state_name : String,
    val total_case : String,
    val total_deaths : String,
    val total_recovered : String,
    val helpline_number : String
)

class IndiaState(
    val countries_stat: List<IndiaStateResult>
)