package com.unisbadri.grapql.federated.factories

import com.unisbadri.grapql.federated.models.Book

class DataFactory {
    companion object {
        fun generateBooks(): List<Book> {
            return listOf(
                Book(1, "Ruby in Action - Second Edition"),
                Book(2, "Harry Potter and The Hagrid"),
                Book(1, "Saturn V"),
                Book(2, "Lunar Module"),
                Book(3, "Space Shuttle"),
                Book(4, "Falcon 9"),
                Book(5, "Dragon"),
                Book(6, "Starship")
            )
        }
    }
}