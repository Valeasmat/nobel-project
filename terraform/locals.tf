locals {
    #Debe ser único, ejemplo, alias = "jlgc"
    alias = "vmam"
    #ejemplo, region = "East US 2"
    region = "Central US"
    workers = 2
    instancia = "Standard_D2_v2"
    subscripcion = "Azure subscription 1"
    #az ad sp create-for-rbac --role="Contributor" --scopes="/subscriptions/df66ee14-34fe-4b86-bd0f-ed07d8ab379a/resourceGroups/<resourceGroupName>"
    clientid = "e2e30284-d6de-48e4-ba8c-6c43ad828362"
    clientsecret = "kmJNpTHI.EdQZ1DxhVs3UAnrs~G7hJdex~"
}
