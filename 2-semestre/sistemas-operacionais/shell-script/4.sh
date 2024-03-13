#!/bin/bash

# Construa um Shell Script para verificar se um nome digitado pelo usuário corresponde a um diretório ou um arquivo. Use os comandos:
# read  para capturar o nome digitado pelo usuário
# if para testar (use o parâmetro adequado para verificar se é diretório)
# echo para informar se é arquivo ou diretório

echo "Digite o nome do arquivo para procurar"
read arquivo

if [ -d "$arquivo" ]; then
  echo "$arquivo é um diretório"
  exit
fi

if [ -f "$arquivo" ]; then
  echo "$arquivo é um arquivo"
  exit
fi

echo "$arquivo não é nem um arquivo nem um diretório"
