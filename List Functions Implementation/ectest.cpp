// ectest.cpp
// CSCI 455 Spring 2018, Extra Credit assignment

// Note: this uses separate compilation.  You put your code in listFuncs.cpp
// Code in this file calls those funcs.
// You do not need to modify or submit this file.


#include <iostream>
#include <cctype>
#include <cassert>
#include <string>

// for istringstream
#include <sstream>

#include "ecListFuncs.h"

using namespace std;

void swap(Node * a, Node * b);

//*************************************************************************


/* a little test program */

void swap(Node * a, Node * b) {
 Node * tmp = a;
 a = b;
 b = tmp;
 cout << a->data << " " << b->data << endl;
}
int main() {
 Node * x = new Node(3);
 Node * y = new Node(8);
 cout << x->data << " " << y->data << endl;
 swap(x, y);
 cout << x->data << " " << y->data << endl;
 return 0;
}

Node::Node(int item) { 
  data = item;
  next = NULL;
}

Node::Node(int item, Node *n) {
  data = item;
  next = n;
}
