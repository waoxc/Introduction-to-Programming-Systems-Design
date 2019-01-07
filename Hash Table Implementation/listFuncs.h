// Name: Chengzhe Xue
// USC NetID: chengzhx
// CSCI 455 PA5
// Spring 2018


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.
void initList(ListType &list);
bool listInsert(ListType &list, string name, int theValue);
void listChange(ListType &list, string name, int theValue);
int * listLookup(ListType &list, string name);
bool listRemove(ListType &list, string name);
void listPrintAll(ListType &list);
int listSize(ListType &list);













// keep the following line at the end of the file
#endif
