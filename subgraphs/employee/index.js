const { ApolloServer, gql } = require('apollo-server');
const { readFileSync } = require('fs');

const port = process.env.APOLLO_PORT || 4100;

const employees = [
    { id: 1, name: 'Unis Badri', address: "Jl. Kedung Turi 3 no. 55" },
    { id: 2, name: 'Namikaze Minato', address: "Jl. Kalibata Raya no. 1" }
]

const typeDefs = gql(readFileSync('./employee.graphql', { encoding: 'utf-8' }));

const resolvers = {
    Query: {
        allEmployees: (_, args, context) => {
            return employees;
        },
        employee: (_, args, context) => {
            return employees.find(p => p.id === args.id);
        }
    },
}
const server = new ApolloServer({ typeDefs, resolvers });

server.listen( {port: port} ).then(({ url }) => {
    console.log(`🚀 Employee subgraph ready at ${url}`);
}).catch(err => {console.error(err)});