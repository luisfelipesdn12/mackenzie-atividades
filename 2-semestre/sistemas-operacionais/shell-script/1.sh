#!/bin/bash
# Produzir um arquivo em Shell Script para realizar a soma de duas variáveis digitadas pelo usuário.

echo "Digite o primeiro número:"
read num1

echo "Digite o segundo número:"
read num2

soma=$((num1 + num2))

echo "A soma dos dois números é: $soma"
