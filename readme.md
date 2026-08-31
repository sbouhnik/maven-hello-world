# maven-hello-world

A minimal Java application that prints a personalized greeting. Used as a reference project for Maven, Docker, GitHub Actions CI/CD, and Helm.

## Prerequisites

- JDK 25
- Maven 3.9+
- Docker (optional)
- Helm + Kubernetes (optional)

## Build and run locally

```bash
cd myapp
mvn package -B
java -jar target/maven-hello-world-*.jar "Your Name"
# Your Name is saying you Hello World!!!
```

## Docker

**Build:**
```bash
cd myapp
docker build -f Dockerfile -t maven-hello-world .
```

**Run:**
```bash
docker run --rm maven-hello-world "Your Name"
# Your Name is saying you Hello World!!!
```

The image is published to Docker Hub at [`sbouhnik/maven-hello-world`](https://hub.docker.com/r/sbouhnik/maven-hello-world).

```bash
docker run --rm sbouhnik/maven-hello-world:latest "Your Name"
```

## CI/CD

Two GitHub Actions workflows are defined in `.github/workflows/`:

| Workflow | Trigger | What it does |
|---|---|---|
| `PR Docker Build` | Pull request / manual | Bumps patch version in `pom.xml`, builds and pushes Docker image to Docker Hub, then runs the image |
| `Build and Run` | Manual | Builds with Maven and runs the jar |

Requires `DOCKERHUB_USERNAME` and `DOCKERHUB_TOKEN` repository secrets.

## Helm

A Helm chart is provided under `helm/myapp/` for running the app as a Kubernetes Job.

```bash
helm install myapp helm/myapp \
  --set name="Your Name" \
  --set image.tag=latest
```

## Project structure

```
├── myapp/
│   ├── Dockerfile
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/myapp/App.java
│       └── test/java/com/myapp/AppTest.java
├── helm/
│   └── myapp/
│       ├── Chart.yaml
│       ├── values.yaml
│       └── templates/job.yaml
└── .github/workflows/
    ├── pr-docker-build.yml
    └── build-and-run-on-demand.yml
```
