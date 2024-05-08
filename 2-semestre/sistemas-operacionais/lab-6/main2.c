#include <stdio.h>
#include <pthread.h>
void *counter();
int main()
{
    pthread_t thread[2];
    pthread_create(&thread[0], NULL, counter, NULL);
    pthread_create(&thread[1], NULL, counter, NULL);
    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);
    return 0;
}
void *counter()
{
    long i;
    long sum = 0;
    for (i = 0; i < 1000000000; i++)
        sum++;
    printf("Counting... - Handle --> %d\n", pthread_self());
}