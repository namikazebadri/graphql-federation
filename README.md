# GraphQL Federation

This project name is **Library Manager**, consists of 4 microservices which exposing its API in GraphQL. 
These microservices will sit behind Apollo Router and act as federated GraphQL API. The names of the microservices as follows:

1. User (this microservice will handle user/member/visitor related logic)
2. Employee (this microservice will handle employee related logic)
3. Shelf (this microservice will handle shelf related logic which will be used by books)
4. Book (this microservice will handle book related logic)

This federated graphql will share their schema through [this specification](https://www.apollographql.com/docs/federation/federated-types/overview).

# Requirements

This project requires us to install Rover and Router from ApolloGraphQL. 
You can refer to [this documentation](https://www.apollographql.com/docs/rover/getting-started) 
and [this documentation](https://www.apollographql.com/docs/router/quickstart) to install those 2 binaries. 
Basically you can run these commands to install those 2 binaries:

**Rover**

```shell
curl -sSL https://rover.apollo.dev/nix/latest | sh
```

**Router**

```shell
curl -sSL https://router.apollo.dev/download/nix/latest | sh
```

# Running This Project

To run this project you can do these steps:

1. Composing `supergraph` file using **Rover**.
2. Running **Router** with `supergraph` file produced in step 1.
3. Run GraphQL APIs as `subgraph`.

## Supergraph Composition

After you install those binaries, the next step is composing supergraph from your subgraph, you can do this by 2 methods:

1. Local GraphQl files
2. Introspection to all GraphQL APIs

In this project we use the first method. To achieve this, we define our supergraph in a file named `supergraph.yaml` in this repository.
We can run composition by running this command:

```shell
rover supergraph compose --config supergraph.yaml > supergraph.graphql
```

or using executable script in this project:

```shell
./compose
```

In above command, we use rover binary to compose supergraph by using `supergraph.yaml` configuration file and then write the result to a file named `supergraph.graphql` under same directory.

## Running Router

After composing supergraph, the next step is running our router. Router in the front server for our supergraph, 
that is why it needs us to specify supergraph definition when want to run it. 
In previous step we already have `supergraph.graphql` file needed by router to run, so what we need is running the router. 
You can run the router by executing this command:

```shell
./router --dev --supergraph supergraph.graphql
```

or using executable script in this project:

```shell
./routerrun
```

Then you can open your router dashboard with this url: `http://localhost:4000`

## Running GraphQL APIs

The next step is running all graphql apis federated to this federation as specified in `supergraph.yaml`. 
In this repository, graphql apis as subgraph is defined in subgraph directory. 
You can refer to how to run each api in their respective README.md folder.