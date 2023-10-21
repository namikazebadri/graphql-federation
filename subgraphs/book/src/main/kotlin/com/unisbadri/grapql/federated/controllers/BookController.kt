package com.unisbadri.grapql.federated.controllers

import com.unisbadri.grapql.federated.factories.DataFactory
import com.unisbadri.grapql.federated.models.Book
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class BookController {
    private val books = DataFactory.generateBooks()

    @QueryMapping
    fun book(@Argument id: Int): Book? {
        return books.stream().filter { book -> book.id == id }.findFirst().get()
    }

    @QueryMapping
    fun books(): List<Book?> {
        return books
    }
}
