// Name: Chengzhe Xue
// USC NetID: chengzhx
// CSCI 455 PA5
// Spring 2018

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>

int main(int argc, char * argv[]) {

  // gets the hash table size from the command line

  int hashSize = Table::HASH_SIZE;

  Table * grades;  // Table is dynamically allocated below, so we can call
                   // different constructors depending on input from the user.

  if (argc > 1) {
    hashSize = atoi(argv[1]);  // atoi converts c-string to int

    if (hashSize < 1) {
      cout << "Command line argument (hashSize) must be a positive number" 
	   << endl;
      return 1;
    }

    grades = new Table(hashSize);

  }
  else {   // no command line args given -- use default table size
    grades = new Table();
  }


  grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*
  bool flag = true;
  while(flag){
    cout << "cmd>";
    string command;
    cin >> command;
    if(command == "insert"){
      string name;
      cin >> name;
      int score;
      cin >> score;
      if(!grades->insert(name, score)){
        cout << "This name was already present" << endl;
      }
    }
    else if(command == "change"){
      string name;
      cin >> name;
      int newscore;
      cin >> newscore;
      int *val = grades->lookup(name);
      if(val == NULL){
        cout << "This name is not present" << endl;
      }
      else{
        *val = newscore;
      }
    }
    else if(command == "lookup"){
      string name;
      cin >> name;
      int *val = grades->lookup(name);
      if(val == NULL){
        cout << "This name is not present" << endl;
      }
      else{
        cout << name << "'s score is" << *val << endl;
      }
    }
    else if(command == "remove"){
      string name;
      cin >> name;
      if(!grades->remove(name)){
        cout << "This name is not present" << endl;
      }
    }
    else if(command == "print"){
      grades->printAll();
    }
    else if(command == "size"){
      grades->numEntries();
    }
    else if(command == "stats"){
      grades->hashStats(cout);
    }
    else if(command == "help"){
      cout << "Command Summary:" << endl;
      cout << "insert name score" << endl;
      cout << "change name newscore" << endl;
      cout << "lookup name" << endl;
      cout << "remove name" << endl;
      cout << "print" << endl;
      cout << "size" << endl;
      cout << "stats" << endl;
      cout << "help" << endl;
      cout << "quit" << endl;
    }
    else if(command == "quit"){
      flag = false;
    }
    else{
      cout << "ERROR: invalid command" << endl;
      cout << "Command Summary:" << endl;
      cout << "insert name score" << endl;
      cout << "change name newscore" << endl;
      cout << "lookup name" << endl;
      cout << "remove name" << endl;
      cout << "print" << endl;
      cout << "size" << endl;
      cout << "stats" << endl;
      cout << "help" << endl;
      cout << "quit" << endl;
    }
  }

  return 0;
}
