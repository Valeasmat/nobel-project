locals {
    #Debe ser único, ejemplo, alias = "jlgc"
    alias = "vmam"
    #ejemplo, region = "East US 2"
    region = "Central US"
    workers = 2
    instancia = "Standard_D2_v2"
    subscripcion = "Azure subscription 1"
    #az ad sp create-for-rbac --role="Contributor" --scopes="/subscriptions/<subscriptionId>/resourceGroups/<resourceGroupName>"
    clientid = "a08cefc4-d30a-4cca-b8e1-7e8ec5356c6a"
    clientsecret = "o_nUopOwwEocZbuE78dk~mJz_~-~aY91r6"
}
