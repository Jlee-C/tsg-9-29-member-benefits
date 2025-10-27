# Launching the Full‑Stack App

This guide walks a new developer through running the backend (Spring Boot + Postgres in Docker) and the frontend (React + React Router + Google OAuth) locally.

---

## Prerequisites

* **Java 21**
* **Maven 3.9+** (`mvn -v`)
* **Node 18+** and **npm 9+** (`node -v`, `npm -v`)
* **Docker Desktop** or Docker Engine (`docker -v`)
* An IDE (VS Code / IntelliJ / WebStorm) for the frontend
* **Google OAuth client ID** (from Google Cloud Console) for local login

> If any ports below are in use, change them as needed.

---

## 1) Clone and open the project

```bash
git clone <YOUR_REPO_URL>
cd <YOUR_REPO_ROOT>
```

The repository is assumed to look roughly like this:

```
/ (repo root)
├─ backend/
│  ├─ src/
│  ├─ pom.xml
│  └─ docker/
│     └─ postgres/
│        └─ Dockerfile   # Postgres Dockerfile lives here (adjust if different)
└─ frontend/
   ├─ src/
   ├─ package.json
   └─ ...
```

---

## 2) Start PostgreSQL in Docker (from **backend**)

1. **Build the Postgres image** (path may vary—update if your Dockerfile is elsewhere):

   ```bash
   cd backend
   docker build -t myapp-postgres -f docker/postgres/Dockerfile .
   ```

2. **Run the container**:

   ```bash
   docker run --name myapp-postgres \
     -e POSTGRES_DB=myapp \
     -e POSTGRES_USER=myapp \
     -e POSTGRES_PASSWORD=localdev \
     -p 5432:5432 -d myapp-postgres
   ```

3. **(Optional) Verify it’s up**:

   ```bash
   docker ps
   ```

> If you already have Postgres running locally on 5432, stop it or change the published port (e.g., `-p 55432:5432`) and update your Spring `spring.datasource.url` accordingly.

---

## 3) Configure backend to use the database

Create (or update) your `application.yml` (or `application.properties`) under `backend/src/main/resources/`.

**application.yml** example:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/myapp
    username: myapp
    password: localdev
  jpa:
    hibernate:
      ddl-auto: update   # or validate/create/create-drop as you prefer for dev
    properties:
      hibernate:
        format_sql: true
  sql:
    init:
      mode: never
server:
  port: 8080
```

---

## 4) Build & run the backend (Spring Boot)

From the **backend** directory:

1. **Install & compile**

   ```bash
   mvn clean install -DskipTests
   ```

2. **Run the app** (pick one):

   ```bash
   # Option A: via Maven plugin (recommended in dev)
   mvn spring-boot:run

   # Option B: run the built JAR
   java -jar target/*.jar
   ```

The backend should now be available at **[http://localhost:8080](http://localhost:8080)**.

---

## 5) Set up & run the frontend (React)

> Open the **frontend** folder in your IDE.

From the **frontend** directory:

1. **Install base dependencies**

   ```bash
   npm install
   ```

2. **Install routing & Google OAuth**

   ```bash
   npm install react-router-dom @react-oauth/google@latest
   ```

3. **Configure environment variables**

   Create a `.env` file in the **frontend** folder and add your Google client ID. If you use **Vite**, prefix with `VITE_`; if Create React App, use `REACT_APP_`.

   **Vite example (.env):**

   ```dotenv
   VITE_GOOGLE_CLIENT_ID=YOUR_GOOGLE_OAUTH_CLIENT_ID
   VITE_API_BASE_URL=http://localhost:8080
   ```

   **CRA example (.env):**

   ```dotenv
   REACT_APP_GOOGLE_CLIENT_ID=YOUR_GOOGLE_OAUTH_CLIENT_ID
   REACT_APP_API_BASE_URL=http://localhost:8080
   ```

   Make sure your frontend code reads the same variable names you choose here.

4. **Start the dev server**

   ```bash
   # Vite
   npm run dev

   # or CRA
   npm start
   ```

   The app will typically open on **[http://localhost:5173](http://localhost:5173)** (Vite) or **[http://localhost:3000](http://localhost:3000)** (CRA). Check your terminal output for the exact URL.

---

## 6) Test the flow

* Navigate to the frontend URL.
* Use the **Google Sign‑In** button to authenticate.
* The frontend should send the ID token to the backend and call protected endpoints (e.g., `GET /api/auth/me`).
* Verify the backend logs for successful requests and that DB operations work (creates/reads) against the Dockerized Postgres.

---

## Common issues & fixes

* **Port 5432 already in use**: Stop your local Postgres or run Docker on another host port: `-p 55432:5432` and update Spring datasource URL to `jdbc:postgresql://localhost:55432/myapp`.
* **Cannot connect to DB**: Confirm the container is running (`docker ps`), credentials match, and `spring.datasource.url` points to the correct host/port.
* **Maven errors**: Ensure you’re using Java 21 and Maven 3.9+. Clear your local repo cache if needed: `mvn -U clean install`.
* **Node dependency conflicts**: Delete `node_modules` and `package-lock.json`, then `npm install`.
* **OAuth pop‑up blocked or failing**: Confirm the **Google OAuth client ID** and that your authorized origins include your dev URL (e.g., `http://localhost:5173` or `http://localhost:3000`).

---

## Useful scripts (optional)

Add these to `package.json` (frontend) if you use Vite:

```json
{
  "scripts": {
    "dev": "vite",
    "build": "vite build",
    "preview": "vite preview"
  }
}
```

For backend, you can add a Maven profile for dev if desired, or rely on `spring-boot:run`.

---

## Shut down & clean up

```bash
# Stop backend (Ctrl+C if running in foreground)
# Stop and remove DB container
docker stop myapp-postgres && docker rm myapp-postgres
```

---

## Recap

1. Build & run Postgres Docker from **backend**.
2. `mvn clean install` then `mvn spring-boot:run` in **backend**.
3. Open **frontend** in an IDE, `npm install`, `npm install react-router-dom @react-oauth/google@latest`, set up `.env`, and start with `npm run dev` (or `npm start`).

You’re good to go! ✅
