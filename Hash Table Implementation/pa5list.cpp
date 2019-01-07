// Name: Chengzhe Xue
// USC NetID: chengzhx
// CS 455 PA5

// pa5list.cpp
// a program to test the linked list code necessary for a hash table chain

// You are not required to submit this program for pa5.

// We gave you this starter file for it so you don't have to figure
// out the #include stuff.  The code that's being tested will be in
// listFuncs.cpp, which uses the header file listFuncs.h

// The pa5 Makefile includes a rule that compiles these two modules
// into one executable.

#include <iostream>
#include <string>
#include <cassert>

using namespace std;

#include "listFuncs.h"


int main() {

	ListType list;
	initList(list);
	
	cout << listInsert(list, "Ann", 98) << endl;
	listPrintAll(list);
	cout << listInsert(list, "Ben", 97) << endl;
	listPrintAll(list);
	cout << listInsert(list, "Cat", 96) << endl;
	listPrintAll(list);
	cout << listInsert(list, "Ann", 98) << endl;
	listPrintAll(list);
	cout << listLookup(list, "Ann") << endl;
	cout << listLookup(list, "Fred") << endl;
	
	cout << listRemove(list,"Frank") << endl;
	listPrintAll(list);
	cout << listRemove(list,"Ann") << endl;
	listPrintAll(list);
	cout << listRemove(list,"Cat") << endl;
	listPrintAll(list);
	cout << listRemove(list,"Ann") << endl;
	listPrintAll(list);
	cout << listRemove(list,"Ben") << endl;
	listPrintAll(list);
	cout << listRemove(list,"Ben") << endl;
	listPrintAll(list);

	return 0;
}
