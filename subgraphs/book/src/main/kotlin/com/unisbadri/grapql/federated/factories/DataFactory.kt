package com.unisbadri.grapql.federated.factories

import com.unisbadri.grapql.federated.models.Book

class DataFactory {
    companion object {
        fun generateBooks(): List<Book> {
            return listOf(
                Book(1, "Ruby in Action - Second Edition"),
                Book(2, "Harry Potter and The Hagrid"),
                Book(3, "Saturn V"),
                Book(4, "Lunar Module"),
                Book(5, "Space Shuttle"),
                Book(6, "Falcon 9"),
                Book(7, "Dragon"),
                Book(8, "Starship")
            )
        }
    }
}