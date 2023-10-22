FROM node:18-bookworm-slim

WORKDIR /usr/src/app

COPY package.json .

RUN npm install

COPY index.js .
COPY employee.graphql .

CMD [ "node", "index.js" ]