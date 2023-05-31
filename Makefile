build:
	docker compose up --build -d --remove-orphans

up:
	docker compose up

up-d:
	docker compose up -d

down:
	docker compose down
down-v:
	docker compose down -v

show-logs-db:
	docker compose logs bw-db

show-logs-api:
	docker compose logs bw-api
