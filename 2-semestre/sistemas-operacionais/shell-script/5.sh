#!/bin/bash

# Modifique o exercício anterior, para que caso o nome digitado seja um diretório, o Shell  Script  exiba  o  conteúdo  do  diretório  (ls  –  la)  e  se  for  um  arquivo,  exibir  o conteúdo do arquivo (cat)

echo "Digite o nome do arquivo para procurar"
read nome

if [ -d "$nome" ]; then
  echo "$nome é um diretório"
  echo "Conteúdo do diretório:"
  ls $nome
  exit
fi

if [ -f "$nome" ]; then
  echo "$nome é um arquivo"
  echo "Conteúdo:"
  cat $nome
  exit
fi

echo "$nome não é nem um arquivo nem um diretório"

