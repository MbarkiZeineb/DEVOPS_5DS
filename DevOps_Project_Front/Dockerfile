FROM node AS build
WORKDIR /
COPY . .
RUN npm install
# Étape de production
FROM nginx:alpine
COPY --from=build /app/dist/crudtuto-Front /usr/share/nginx/html/
