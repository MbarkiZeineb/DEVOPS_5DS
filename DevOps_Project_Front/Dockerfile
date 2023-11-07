# Étape de production
FROM node
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build
WORKDIR /app/dist
CMD ["npm", "start"]
