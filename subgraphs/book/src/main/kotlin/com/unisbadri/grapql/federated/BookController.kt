package com.unisbadri.grapql.federated

import com.unisbadri.grapql.federated.models.Book
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {
    private val books = listOf(
        Book(1, "Saturn V"),
        Book(2, "Lunar Module"),
        Book(3, "Space Shuttle"),
        Book(4, "Falcon 9"),
        Book(5, "Dragon"),
        Book(6, "Starship")
    )

    @QueryMapping
    fun book(@Argument id: Int): Book? {
        return books[0]
    }

    @QueryMapping
    fun books(): List<Book?> {
        return books
    }
}
