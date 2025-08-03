#this is a Spring boot application for demo
APIs in the repo with default profile: 
/demo/hello?name=${text}        sleep 10s then return Hello ${text}!
/demo/setting                   return value of property demo_setting
/demo/secret                    return value of property demo_secret
/demo/call                      call external api method get with full endpoint is value of property api_test


#Enable SQL profile
To enable Azure SQL features on this repo, you should set following environment variables: 
    SPRING_PROFILES_ACTIVE=sql
    connection_string=${your connection string}

Then the api will be enabled for using Azure SQL as the database. 
GET - /sql/check                return success if profile "sql" was enabled successful
GET - /sql/insert               insert a record to integrated Azure SQL database - todo table
GET - /sql/get                  get all records in todo table


#Enable Key Vault profile
if the profile is enabled, you can add environment variables to your app service to integrate with this app:
    DEMO_SECRET=@Microsoft.KeyVault(SecretUri=https://${your-keyvault-name}.vault.azure.net/secrets/demo-secret/)
    value of property demo_secret will be retrieved from Azure Key Vault and return to api /keyvault/secret

GET - /keyvault/secret                  return value of DEMO_SECRET



#Steps to build docker image and push it to ACR
mvn clean package
docker build -t pma4acr.azurecr.io/springdemo:latest .
az account set --subscription BD-XDV-Learning-Sandbox
az acr login --name pma4acr
docker login pma4acr.azurecr.io
docker push pma4acr.azurecr.io/springdemo:latest
az acr repository list --name pma4acr --output table

az aks get-credentials --resource-group pma4hc --name pma4aks