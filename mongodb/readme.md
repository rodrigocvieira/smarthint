# Docker mongoDB

## Passos para o uso da imagem.

- Criar um arquivo .env
    - Utilize o arquivo default.env como base para criar seu arquivo .env
## Executando o docker na raiz do projeto mongodb
`docker run -d -p 27017:27017 --env-file .env --name mongodb mongo:latest`