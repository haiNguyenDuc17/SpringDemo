#this is a Spring boot application for demo


mvn clean package
docker build -t acr.azurecr.io/springdemo:latest .
az account set --subscription BD-XDV-Learning-Sandbox
az acr login --name acr
docker login acr.azurecr.io
docker push acr.azurecr.io/springdemo:latest