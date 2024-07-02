## Dependency:
- Java 17
- Jakarta 10
- Primefaces 13
- Wildfly 31
- Postgres

## Install:
- standalone: Add the standalone.xml in the root project
- Postgres Wildfly:
	download: https://jdbc.postgresql.org/download/
	add:
	modules\org\postgresql\main
	module.xml:
		<?xml version='1.0' encoding='UTF-8'?>
		<module xmlns="urn:jboss:module:1.1" name="org.postgresql">
			<resources>	
			<!--the name of your driver -->
				<resource-root path="postgresql-42.2.6.jar"/>
			</resources>
			<dependencies>
				<module name="javax.api"/>
				<module name="javax.transaction.api"/>
			</dependencies>
		</module>