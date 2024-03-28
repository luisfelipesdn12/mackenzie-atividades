#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

void create_fork() {
    int pid = fork();

    if (pid < 0) {
        fprintf(stderr, "error\n");
    }

    if (pid == 0) {
        printf("FILHO: \t ID é %d, PID é %d\n", getpid(), pid);
    } else {
        printf("PAI: \t ID é %d, PID é %d\n", getpid(), pid);
    }
}

int main() {
    for (int i = 0; i < 10; i++) {
        create_fork();
    }

    return 0;
}
