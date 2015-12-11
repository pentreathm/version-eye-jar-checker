- Create a table in the DB named "versioneye-test"
- Create an unique constraint:
	ALTER TABLE versioneye-test ADD CONSTRAINT jar_unique UNIQUE (jarName, licenseName)