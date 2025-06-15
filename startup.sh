git pull
kubectl delete -f manifests/deployment.yaml
kubectl apply -f manifests/deployment.yaml
kubectl delete -f manifests/ingress.yaml
kubectl apply -f manifests/ingress.yaml