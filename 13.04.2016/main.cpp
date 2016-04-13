#include <cstdlib>
#include <iostream>

using namespace std;

class node{
  
  private:
          int _value;
          node *_next;
          
  public:
        node(int value=10){_value=value;_next=NULL;}
        int getV(){return _value;}
        void add(int i){
             
             if(_next!=0)_next=new node(i);
             else{
                  node *n=this;
                  while(n->_next!=0)n=n->_next;
                  n->_next=new node(i);
                  }
             
             }
       
      
};
int main(int argc, char *argv[])
{
    node n1=node(10);
    cout<<n1.getV()<<endl;
    
    system("PAUSE");
    return EXIT_SUCCESS;
}
