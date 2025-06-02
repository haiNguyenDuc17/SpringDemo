#this is a Spring boot application for demo


mvn clean package
docker build -t pma4acr.azurecr.io/springdemo:latest .
az account set --subscription BD-XDV-Learning-Sandbox
az acr login --name pma4acr
docker login pma4acr.azurecr.io
docker push pma4acr.azurecr.io/springdemo:latest
az acr repository list --name pma4acr --output table

az aks get-credentials --resource-group pma4hc --name pma4aks