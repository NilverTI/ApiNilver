API DE PEDIDOS - README

API REST desarrollada con Spring Boot para la gestión de pedidos, productos, clientes y trabajadores.
Proyecto desplegado en Render usando PostgreSQL.

==================================================
TECNOLOGÍAS
==================================================
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Docker
- Render
- Insomnia / Postman

==================================================
URL BASE (PRODUCCIÓN)
==================================================
https://apinilver.onrender.com

==================================================
ENDPOINTS
==================================================

PRODUCTOS
GET     /api/products
GET     /api/products/{id}
POST    /api/products
PUT     /api/products/{id}
DELETE  /api/products/{id}

BÚSQUEDAS
GET /api/products/search
GET /api/products/search/multi
GET /api/products/page

PEDIDOS
GET  /api/pedidos
POST /api/pedidos
GET  /api/pedidos/{id}

==================================================
CONFIGURACIÓN (RENDER)
==================================================
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
PORT=10000

==================================================
DOCKER
==================================================
- Imagen base: eclipse-temurin:21-jdk
- Build con Maven Wrapper
- Ejecuta JAR empaquetado
- Puerto dinámico de Render

==================================================
PRUEBAS
==================================================
Herramientas:
- Insomnia
- Postman

Ejemplo:
GET https://apinilver.onrender.com/api/products

==================================================
ESTADO
==================================================
- API activa
- Base de datos conectada
- Despliegue exitoso en Render

==================================================
AUTOR
==================================================
Nilver T.I
Backend Developer - Java / Spring Boot

Redes sociales:
https://nilverti.bio.link/

==================================================
LICENCIA
==================================================
Proyecto académico y demostrativo.
Uso libre para aprendizaje.
