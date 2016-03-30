#include <cstdlib>
#include <iostream>

using namespace std;

class dynamicArray{
      public:
       dynamicArray( int initSize = 0 )
      : theSize( initSize ), theCapacity( initSize + 20 )
      {
                sayilar=new int[theCapacity];
      }
      int size(){return theSize;}
      int resize(){
          cout<<"......................."<<endl;
          cout<<"yer degisimi yapiliyor"<<endl;
          cout<<"......................."<<endl;
          int *eski_sayilar=sayilar;
          sayilar=new int[theCapacity*2];
          for(int k=0;k<s;k++){
                  sayilar[k]=eski_sayilar[k];
                  theSize=s;
                  theCapacity=newCapacity*2;
                  }
      }
      void add(int x){
                   if(s==size()resize();
                   sayilar[s]=x;
                   s++;
           }
      private:
              int s;
              int theSize;
              int theCapacity;
              int * sayilar;
              
}
int main(int argc, char *argv[])
{   
    dynamicArray myda=new dynamicArray(5000);
    cout<<myda.size<<endl;
    myda.resize();,
    cout<<myda.size()<<endl;
    for(int k=0;k<10;k++){
            myda.add(4);
            cout<<myda.size()<<endl;
            } 
    system("PAUSE");
    return EXIT_SUCCESS;
}
