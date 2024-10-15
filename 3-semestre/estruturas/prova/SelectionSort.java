public class SelectionSort {
    public static void main(String[] args) {
        int []v = {2210,13,117,1,2,4,3,5,7,6,8,7,9,7,6,68,34};
        int x, y, indice_min, aux;
        
        for(x=0; x < v.length-1; x++) {
            indice_min = x;
            for(y=x+1; y < v.length; y++) {
                if(v[y] < v[indice_min]) {  // se encontrar um novo mínimo
                    indice_min = y;  // atualiza "indice_min" para o novo mínimo
                }
            }
            // Faz a troca
            aux = v[x];
            v[x] = v[indice_min];
            v[indice_min] = aux;

            System.out.println("");
            for(int i = 0; i < v.length; i++)
                System.out.print(v[i] + " ");

        }
        
        // imprime vetor ordenado
        for(int i = 0; i < v.length; i++)
            System.out.print(v[i] + " ");
    }
}
