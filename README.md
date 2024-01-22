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

### build docker image

```bash
docker build -t extreme_startup_player .
```

### run docker container based on that image

```bash
docker run extreme_startup_player
```

### cleanup

```bash
docker container prune -f
```
