// Name: Chengzhe Xue
// USC NetID: chengzhx
// CSCI 455 PA5
// Spring 2018

// Table.cpp  Table class implementation


#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************

typedef Node * ListType;
ListType * data;
int numOfBuckets = 0;

Table::Table() {
  data = new ListType[HASH_SIZE]();
  numOfBuckets = HASH_SIZE;
}


Table::Table(unsigned int hSize) {
  data = new ListType[hSize]();
  numOfBuckets = hSize;
}


int * Table::lookup(const string &key) {
  return listLookup(data[hashCode(key)%numOfBuckets], key);
}

bool Table::remove(const string &key) {
  return listRemove(data[hashCode(key)%numOfBuckets], key);
}

bool Table::insert(const string &key, int value) {
  return listInsert(data[hashCode(key)%numOfBuckets], key, value);
}

int Table::numEntries() const {
  int num = 0;
  for(int i=0; i<numOfBuckets; i++){
      num = num + listSize(data[i]);
  }
  return num;
}


void Table::printAll() const {
  for(int i=0; i<numOfBuckets; i++){
      listPrintAll(data[i]);
  }
}

void Table::hashStats(ostream &out) const {
  int numOfEntries = 0;
  for(int i=0; i<numOfBuckets; i++){
      numOfEntries = numOfEntries + listSize(data[i]);
  }
  int numOfNonEnpty = 0;
  for(int i=0; i<numOfBuckets; i++){
    if(data[i]!=NULL){
      numOfNonEnpty++;
    }
  }
  int longestChain = 0;
  for(int i=0; i<numOfBuckets; i++){
    if(longestChain<listSize(data[i])){
      longestChain = listSize(data[i]);
    }
  }
  cout << "number of buckets: " << numOfBuckets << endl;
  cout << "number of entries: " << numOfEntries << endl;
  cout << "number of non-empty buckets: " << numOfNonEnpty << endl;
  cout << "longest chain: " << longestChain << endl;
}


// add definitions for your private methods here
