#!/bin/bash
# Preparar um Shell Script para calcular e exibir o valor de y, considerando que o usuário digitará seu próprio nome e o valor de x,   para a expressão: y=3x-1. Não se esqueça de exibir a expressão que está sendo calculada e o valor de x indicado pelo usuário.

echo "Digite seu nome:"
read nome

echo "Digite o valor de x:"
read x

y=$((3 * x - 1))

echo "Tendo que x = $x, o valor de y para y = 3x - 1 é: $y"
