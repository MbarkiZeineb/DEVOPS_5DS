FROM node AS build
WORKDIR /
COPY . .
RUN npm install --legacy-peer-deps
RUN npm run build --prod
# Étape de production
FROM nginx:alpine
COPY --from=build /app/dist/crudtuto-Front /usr/share/nginx/html/
