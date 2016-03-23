#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int swap=0;
int comp=0;
void quicksort(int x[],int first,int last){
    int pivot,j,temp,i;

     if(first<last){
         comp++;
         pivot=first;
         i=first;
         j=last;

         while(i<j){
             while(x[i]<=x[pivot]&&i<last)
                 i++;
             while(x[j]>x[pivot])
                 j--;
             if(i<j){
                 temp=x[i];
                  x[i]=x[j];
                  x[j]=temp;
                  swap++;
                  comp++;
             }
         }

         temp=x[pivot];
         x[pivot]=x[j];
         x[j]=temp;
         
         quicksort(x,first,j-1);
         quicksort(x,j+1,last);

    }
}

int main(int argc, char *argv[])
{
  int i;
  int lenght=500;
  clock_t t1,t2;
  
  for(i=0;i<10;i++){
              int array[lenght];
              int j;
              for(j=0;j<lenght;j++){
                   array[j]=rand()%1000;
              }
              t1=clock();
              quicksort(array,0,lenght-1);
              t2=clock();
              float diff = ((float)(t2 - t1) / 1000000.0F ) * 1000;  
              printf("N:%d \n",lenght);
              printf("Swap: %d \n",swap);
              printf("Comp: %d \n",comp);
              printf("Time:%f \n",diff);
              lenght*=2;      
  }
  system("PAUSE");	
  return 0;
}
