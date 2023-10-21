package com.unisbadri.grapql.federated

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FederatedApplication

fun main(args: Array<String>) {
    runApplication<FederatedApplication>(*args)
}