up:
	@echo "Starting db"
	@docker run --rm --name med-available-postgres -p 5432:5432 -e POSTGRES_DB=medavailabledb -d -v $$HOME/docker/volumes/postgres:/var/lib/postgresql/data postgres
	@docker ps