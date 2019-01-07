/*  Name:
 *  USC NetID:
 *  CS 455 Spring 2018, Extra Credit assignment
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


bool isInOrder(ListType list) {
  Node *p = list;
  if(p==NULL) return true;
  else if(p->next==NULL) return true;
  else{
    while(p->next!=NULL){
      if(p->data > p->next->data) {return false;}
      p = p->next;
    }
    return true;
  }
}



void insertInOrder(ListType & list, Node *itemP) {
  assert(isInOrder(list));     // checks the preconditions
  assert(itemP->next == NULL);
  // add the rest of the code after this line
  Node *p = list;
  if(p==NULL){
    list = itemP;
  }
  else if(p->next==NULL){
    if(itemP->data>p->data){
      p->next = itemP;
    }
    else{
      itemP->next = list;
      list = itemP;
    }
  }
  else{
    if(itemP->data<p->data){
        itemP->next = p;
        list = itemP;
        return;
    }
    else{
      while(p->next!=NULL){
        if(itemP->data<p->next->data){
          itemP->next = p->next;
          p->next = itemP;
          return;
        }
        p = p->next;
      }
      if(itemP->data>=p->data){
        p->next = itemP;
      }
    }
  }
}



void insertionSort(ListType &list) {
  if(list==NULL) ;
  else if(list->next==NULL) ;
  else{
    Node *newList = NULL;
    while(list->next!=NULL){
      Node *temp = new Node(list->data);
      insertInOrder(newList,temp);
      list = list->next;
    }
    insertInOrder(newList,new Node(list->data));
    list = newList;
  }
}




void splitEvenOdd(ListType &list, ListType &a, ListType &b){
  if(list==NULL){
    a = NULL;
    b = NULL;
  }
  else if(list->next==NULL){
    a = list;
    b = NULL;
  }
  else if(list->next->next==NULL){
    a = list;
    list = list->next;
    a->next = NULL;
    b = list;
    list = list->next;
    b->next = NULL;
  }
  else{
    a = list;
    list = list->next;
    a->next = NULL;
    b = list;
    list = list->next;
    b->next = NULL;
    Node *odd = a;
    Node *even = b;
    int i = 3;
    while(list->next!=NULL){
      if(i%2==1){
        odd->next = list;
        list = list->next;
        odd->next->next = NULL;
        odd = odd->next;
      }
      else {
        even->next = list;
        list = list->next;
        even->next->next = NULL;
        even = even->next;
      }
      i++;
    }
    if(i%2==1){
        odd->next = list;
        list = list->next;
        odd->next->next = NULL;
      }
      else {
        even->next = list;
        list = list->next;
        even->next->next = NULL;
      }
  }
}
