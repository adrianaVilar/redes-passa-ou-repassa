1) Altere o "localhost" da classe ClienteSocket para o IP do servidor;

2) Compile os arquivos:

Acesse o git bash e rode: 
```
javac -d bin $(find src -name "*.java")
```
3) Execute o jogo:
Execute o servidor: 
```
java -cp bin socket.ServidorSocket
```

Execute os clientes: 
```
java -cp bin socket.ClienteSocket
```