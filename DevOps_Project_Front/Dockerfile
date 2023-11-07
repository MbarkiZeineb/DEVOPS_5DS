FROM node AS build
WORKDIR /
COPY . .
RUN npm install
# Étape de production
FROM nginx:alpine
COPY /dist/* /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
