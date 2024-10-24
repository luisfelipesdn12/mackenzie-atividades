import socket

TCP_IP = 'localhost'  # ou '127.0.0.1'
TCP_PORT = 10420
BUFFER_SIZE = 1024

# Criação do socket TCP
client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((TCP_IP, TCP_PORT))

print("Conectado ao servidor! Digite suas mensagens (QUIT para sair)")

try:
    while True:
        # Envia mensagem para o servidor
        message = input("Cliente: ")
        client.send(message.encode('utf-8'))
        
        if message.upper() == 'QUIT':
            print("Encerrando conexão...")
            break
            
        # Recebe resposta do servidor
        data = client.recv(BUFFER_SIZE).decode('utf-8')
        if not data or data.upper() == 'QUIT':
            print("Servidor encerrou a conexão")
            break
        print(f"Servidor: {data}")

finally:
    client.close()