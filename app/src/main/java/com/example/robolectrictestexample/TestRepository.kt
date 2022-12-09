package com.example.robolectrictestexample

class TestRepository {

    fun getProducts(): List<Product> {
        return listOf(
            Product("Papa", "5"),
            Product("Arroz", "8")
        )
    }

}