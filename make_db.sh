set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE postgresTestDocker;
    GRANT ALL PRIVILEGES ON DATABASE postgresTestDocker TO postgres;
EOSQL