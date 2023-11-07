# Étape de production
FROM node:latest as node
WORKDIR /app
COPY . .
RUN npm config set fetch-retry-mintimeout 20000
RUN npm config set fetch-retry-maxtimeout 120000
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY --from=node /app/dist/summer-workshop-angular /usr/share/nginx/html
