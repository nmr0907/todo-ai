# AI Todo – dev infra

## 使い方（DBだけ）
```bash
cd infra
docker compose up -d
docker ps
docker exec -it todo-postgres psql -U todo -d todoapp -c "\dt"
