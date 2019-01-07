// Name: Chengzhe Xue
// USC NetID: chengzhx
// CSCI 455 PA5
// Spring 2018


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below
void initList(ListType &list){
	list = NULL;
}

bool listInsert(ListType &list, string name, int theValue){
	Node *p = list;
	bool flag = true;
	while(p!= NULL){
		if(name == p->key) flag = false;
		p = p->next;
	}
	if(flag){
		Node *newGuy = new Node(name, theValue);
		newGuy->next = list;
		list = newGuy;
	}
	return flag;
}

void listChange(ListType &list, string name, int theValue){
	Node *p = list;
	bool flag = false;
	while(p!= NULL){
		if(name == p->key){
			p->value = theValue;
			flag = true;
		}
		p = p->next;
	}
	if(!flag) cout << name << " isn't present." << endl;
}

int * listLookup(ListType &list, string name){
	Node *p = list;
	bool flag = false;
	while(p!=NULL){
		if(name == p->key) {
			flag = true;
			return &p->value;
		}
		p = p->next;
	}
	if(!flag) return NULL;
}

bool listRemove(ListType &list, string name){

	bool flag = false;
	if(list == NULL) return false;
	Node *p = list;
	if(name == p->key){
		Node *save = p->next;
		delete list;
		list = save;
		flag = true;
	}
	else{
		while(p->next!= NULL){
			if(name == p->next->key){
				flag = true;
				Node *deadGuy = p->next;
				p->next = p->next->next;
				delete deadGuy;
				break;
			}
		p = p->next;
		}
	}
	return flag;
}

void listPrintAll(ListType &list){
	Node *p = list;
	while(p!=NULL){
		cout<< p->key << " " << p->value << endl;
		p = p->next;
	}
}

int listSize(ListType &list){
	Node *p = list;
	int count = 0;
	while(p!=NULL){
		count++;
		p = p->next;
	}
	return count;
}