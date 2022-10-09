# MicroServices-Hotel
Estudo sobre arquitetura de microserviços.


## Módulo 5: Segurança da API com Keycloak:

[Start Keycloak](https://www.keycloak.org/getting-started/getting-started-docker)

### Step by step (Ooh baby):

- Created a new Client
	- cliendID: keyclockclient
	- Valid redirect URIs: http://localhost:8080
	- Client authentication (ON)
	- Standard flow (X)
	- Direct access grants (x)
	- Service accounts roles (x)
	- Logout settings:
		- Front channel logout (ON)
		- Backchannel logout session required (ON)

	- SAVE!!!

- INSONMIA OR POSTMAN:
	- Created GET
	- Authentication Type : OAuth 2.0

	- In http://localhost:8080/admin/master/console/#/keyclockerealm/realm-settings
		- CLICK endpoints -> OpenID Endpoint Configuration 

		PHOTO:
			![Alt text](/image/image1.png "Image 01")
			![Alt text](/image/clientid.png "clientid")
			![Alt text](/image/secret.png "secret")
			![Alt text](/image/gettoken.png "gettoken")
			![Alt text](/image/copytoken.png "copytoken")
	

