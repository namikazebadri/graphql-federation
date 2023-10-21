package com.unisbadri.grapql.federated

import com.apollographql.federation.graphqljava.Federation
import com.apollographql.federation.graphqljava.tracing.FederatedTracingInstrumentation
import graphql.TypeResolutionEnvironment
import graphql.schema.DataFetchingEnvironment
import graphql.schema.idl.RuntimeWiring
import graphql.schema.idl.TypeDefinitionRegistry
import com.unisbadri.grapql.federated.models.Book
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.GraphQlSource.SchemaResourceBuilder
import org.springframework.graphql.execution.RuntimeWiringConfigurer

@Configuration
class GraphQLConfiguration {
    private val books = listOf(
        Book(1, "Ruby in Action - Second Edition"),
        Book(2, "Harry Potter and The Hagrid"),
    )

    @Bean
    fun federatedTracingInstrumentation(): FederatedTracingInstrumentation {
        return FederatedTracingInstrumentation()
    }

    @Bean
    fun federationTransform(): GraphQlSourceBuilderCustomizer {
        return GraphQlSourceBuilderCustomizer { builder: SchemaResourceBuilder ->
            builder.schemaFactory { registry: TypeDefinitionRegistry?, wiring: RuntimeWiring? ->
                Federation
                .transform(registry, wiring)
                .fetchEntities{ env: DataFetchingEnvironment ->
                    env.getArgument<List<Map<String, Any>>>("representations").map { representation ->
                        when(representation["__typename"]) {
                            "Book" -> {
                                val prod = books.firstOrNull { it.id == representation["id"] } ?: error("Book not found: $representation")

                                prod
                            }
                            else -> error("Unknown type: $representation")
                        }
                    }
                }.resolveEntityType { env: TypeResolutionEnvironment ->
                    when(env.getObject<Any>()) {
                        is Book ->  env.schema.getObjectType("Book")
                        else -> null
                    }
                }.build()
            }
        }
    }
}
