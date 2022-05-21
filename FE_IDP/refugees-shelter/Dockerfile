FROM node:alpine AS my-app-build

#RUN apk add --update nodejs npm
RUN mkdir /app
WORKDIR /app
COPY . .
RUN npm ci && npm run build
FROM nginx:1.17.1-alpine


COPY static.conf /etc/nginx/conf.d/default.conf
COPY --from=my-app-build /app/dist/winter-sports-advisor /usr/share/nginx/html
# COPY  /build /usr/share/nginx/html


CMD ["nginx", "-g", "daemon off;"]
