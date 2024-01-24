This is a starting point for a Java player of [Extreme Startup](https://github.com/rchatley/extreme_startup).

### install fly

```bash
brew install flyctl
```

### login to fly

```bash
fly auth login
```

### initial deployment to fly

```bash
fly launch
```

### deploy to fly

```bash
fly deploy
```

### debug running app

```bash
fly logs
```

### build docker image

```bash
docker build -t extreme_startup_player .
```

### run docker container based on that image

```bash
docker run -p 8123:8123 extreme_startup_player
```

Then view http://localhost:8123/

### cleanup

```bash
docker container prune -f
```

### CI/CD

from: https://fly.io/docs/app-guides/continuous-deployment-with-github-actions/

```bash
fly tokens create deploy -x 999999h
```
