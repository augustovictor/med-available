up:
	@echo "Starting db"
	@docker run --rm --name med-available-postgres -p 5432:5432 -e POSTGRES_DB=medavailabledb -d postgres
	@docker ps

down:
	@echo "Removing db"
	@docker rm -f -v med-available-postgres

psql:
	@echo "psql med-available-postgres"
	@docker exec -it med-available-postgres psql -Upostgres -d medavailabledb