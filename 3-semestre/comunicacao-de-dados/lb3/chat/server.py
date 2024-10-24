import socket

TCP_IP = 'localhost'  # ou '127.0.0.1'
TCP_PORT = 10420
BUFFER_SIZE = 1024

# Criação do socket TCP
server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((TCP_IP, TCP_PORT))
server.listen(1)

print(f"Servidor aguardando conexões na porta {TCP_PORT}...")
conn, addr = server.accept()
print(f'Cliente conectado: {addr}')

try:
    while True:
        # Recebe mensagem do cliente
        data = conn.recv(BUFFER_SIZE).decode('utf-8')
        if not data or data.upper() == 'QUIT':
            print("Cliente encerrou a conexão")
            break
        print(f"Cliente: {data}")
        
        # Envia resposta para o cliente
        message = input("Servidor: ")
        if message.upper() == 'QUIT':
            conn.send(message.encode('utf-8'))
            print("Encerrando servidor...")
            break
        conn.send(message.encode('utf-8'))

finally:
    conn.close()
    server.close()