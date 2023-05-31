build:
	docker compose up --build -d --remove-orphans

up:
	docker compose up

up-d:
	docker compose -d

down:
	docker compose down
down-v:
	docker compose down -v

test:
	docker compose -f local.yml run --rm api pytest -p no:warnings --cov=. -v

show-logs-db:
	docker compose logs bw-db

show-logs-api:
	docker compose logs bw-api
