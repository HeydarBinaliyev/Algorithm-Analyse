#include <stdio.h>
#include <stdlib.h>

int fib(int no,int *memory){
    
    if(memory[no]==-1)memory[no]=fib(no-1,memory)+fib(no-2,memory);
    return memory[no];
}

int main(int argc, char *argv[])
{
  int *memory=malloc(sizeof(int)*11);
  int i;
  memory[0]=0;
  memory[1]=1;
  for(i=2;i<11;i++){
                 memory[i]=-1;
                   }
  printf("%d",fib(10,memory));
  system("PAUSE");	
  return 0;
}
