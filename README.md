# Gestión de Usuarios

Aplicación web de gestión de usuarios con arquitectura cliente-servidor: una API REST en **Spring Boot** y un frontend en **React + Vite**, con persistencia en **MySQL**.

> Estado del proyecto: **en desarrollo**. El backend ya expone una API básica; el frontend todavía es la plantilla inicial de Vite.

## Tecnologías

| Capa | Tecnologías |
|------|-------------|
| Backend | Java 21, Spring Boot 4.1.2, Spring Web MVC, Spring Data JPA, Bean Validation, Maven Wrapper |
| Base de datos | MySQL (conector `mysql-connector-j`) |
| Frontend | React 19, Vite 8, ESLint |

## Estructura del proyecto

```
.
├── backend/                  # API REST (Spring Boot)
│   ├── src/main/java/com/vlndev/gestion_usuarios/
│   │   ├── controller/       # UsuarioController
│   │   ├── models/           # Entidad Usuario
│   │   ├── repository/       # UsuarioRepository (JpaRepository)
│   │   └── GestionUsuariosApplication.java
│   ├── src/main/resources/application.properties
│   └── pom.xml
└── frontend/                 # Cliente web (React + Vite)
    ├── src/
    ├── public/
    └── package.json
```

## Requisitos previos

- JDK 21
- Node.js 20.19+ o 22.12+ (requerido por Vite 8)
- MySQL en ejecución con una base de datos creada

## Puesta en marcha

### Backend

```bash
cd backend
./mvnw spring-boot:run      # En Windows: mvnw.cmd spring-boot:run
```

La API queda disponible por defecto en `http://localhost:8080`.

### Frontend

```bash
cd frontend
npm install
npm run dev
```

El cliente queda disponible por defecto en `http://localhost:5173`.

Otros scripts: `npm run build` (build de producción), `npm run lint` (ESLint), `npm run preview`.

## Modelo de datos

Entidad `Usuario` (tabla `usuarios`):

| Campo | Tipo | Notas |
|-------|------|-------|
| `id` | long | Clave primaria autoincremental |
| `nombre` | String(50) | Obligatorio |
| `apellidos` | String(100) | Obligatorio |
| `email` | String | Obligatorio |
| `password` | String | Obligatorio |
| `telefono` | String(15) | Opcional |
| `rol` | String(10) | Por defecto `USER` |
| `activo` | boolean | Por defecto `true` |
| `fecha_registro` | LocalDateTime | Se asigna automáticamente al crear |

## API REST

Base: `/api/usuario`

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `GET` | `/api/usuario/todos` | Lista todos los usuarios |
| `POST` | `/api/usuario/insertarUsuario` | Crea un usuario |

Ejemplo de petición:

```bash
curl -X POST http://localhost:8080/api/usuario/insertarUsuario \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Ana",
    "apellidos": "García López",
    "email": "ana@example.com",
    "password": "secreto123",
    "telefono": "600123456"
  }'
```

## Hoja de ruta

- [ ] Cifrar contraseñas (BCrypt) y no devolverlas en las respuestas JSON
- [ ] Validaciones con Bean Validation (`@NotBlank`, `@Email`, ...) y email único
- [ ] Usar DTOs en lugar de exponer la entidad directamente
- [ ] CRUD completo (obtener por id, actualizar, eliminar / desactivar)
- [ ] Manejo global de errores (`@ControllerAdvice`)
- [ ] Configurar CORS para el frontend
- [ ] Autenticación y autorización por roles (Spring Security)
- [ ] Sustituir la plantilla de Vite por la interfaz real (listado, alta y edición de usuarios)
- [ ] Tests de integración y de repositorio
- [ ] Dockerización (backend, frontend y MySQL)

## Autor

Santiago Valentino Reyna Yepez
