package com.unisbadri.grapql.federated

import com.unisbadri.grapql.federated.models.Book

class Data {
    companion object {
        fun generateBooks(): List<Book> {
            return listOf(
                Book(1, "Ruby in Action - Second Edition"),
                Book(2, "Harry Potter and The Hagrid"),
            )
        }
    }
}