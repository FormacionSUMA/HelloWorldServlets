@echo off

java -jar target/dependency/webapp-runner.jar target/*.war --access-log && start http://localhost:8080
