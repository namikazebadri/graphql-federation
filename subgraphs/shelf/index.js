const { ApolloServer, gql } = require('apollo-server');
const { readFileSync } = require('fs');

const port = process.env.APOLLO_PORT || 4200;

const pandas = [
    {id: 1, name: 'IT Books', description: "IT book shelf." },
    {is: 2, name: 'Novel Books', description: "Novel book shelf." }
]

const typeDefs = gql(readFileSync('./shelf.graphql', { encoding: 'utf-8' }));
const resolvers = {
    Query: {
        allShelves: (_, args, context) => {
            return pandas;
        },
        shelf: (_, args, context) => {
            return pandas.find(p => p.id === args.id);
        }
    },
}
const server = new ApolloServer({ typeDefs, resolvers });
server.listen( {port: port} ).then(({ url }) => {
    console.log(`🚀 Shelf subgraph ready at ${url}`);
}).catch(err => {console.error(err)});