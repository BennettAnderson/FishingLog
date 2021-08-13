-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER fishing_log_owner
WITH PASSWORD 'fishinglog';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO fishing_log_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO fishing_log_owner;

CREATE USER fishing_log_appuser
WITH PASSWORD 'fishinglog';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO fishing_log_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO fishing_log_appuser;
