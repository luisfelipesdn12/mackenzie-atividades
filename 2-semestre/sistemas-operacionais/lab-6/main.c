#include <stdio.h>
#include <pthread.h>

void *msg()
{
    printf("Hello world! - Handle --> %d\n", pthread_self());
}

int main()
{
    pthread_t thread[2];
    pthread_create(&thread[0], NULL, msg, NULL);
    pthread_create(&thread[1], NULL, msg, NULL);
    pthread_join(thread[0], NULL);
    pthread_join(thread[1], NULL);
    return 0;
}

