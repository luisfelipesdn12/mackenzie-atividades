#include <stdio.h>
#include <pthread.h>
long value = 0;
void *accumulator();
int main()
{
    pthread_t thread[2];
    pthread_create(&thread[0], NULL, accumulator, NULL);
    pthread_create(&thread[1], NULL, accumulator, NULL);
    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);
    printf("Accumulator: %d\n", value);
    return 0;
}
void *accumulator()
{
    long i;
    for (i = 0; i < 1000000; i++)
    {
        value++;
    }
}