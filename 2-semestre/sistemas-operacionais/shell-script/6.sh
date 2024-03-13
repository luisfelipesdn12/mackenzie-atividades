#!/bin/bash

#Faça  um  programa  shell  script,  usando  o  comando  enquanto,  que  some  todos  os valores entre início e fim, intervalo que deve ser informado pelo usuário.

#!/bin/bash

echo "Digite o início do intervalo:"
read inicio

echo "Digite o fim do intervalo:"
read fim

soma=0
while [ $inicio -le $fim ]; do
  soma=$((soma + inicio))
  inicio=$((inicio + 1))
done

echo "A soma dos valores entre $inicio e $fim é: $soma"
