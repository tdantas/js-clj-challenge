### Help wanted

first of all, please bear with me, I'm very noob using clojure and I'm trying to solve some hackerrank/codility/project-euler challenges to get the clojure spirit.

one problema caught my attention. I wasn't able to pass all the tests using the clojure solution. I've got a timeout issue, the limit is 6 seconds to problem. the funny part is that using JS I've got less than 1 second on response time.

can you help me to improve my clojure code and make it faster than 5s ?


## Challenge

We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

### Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

### Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.
Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

### Sample Input - [download](https://github.com/tdantas/js-clj-challenge/blob/master/input.txt)

```
add hack
add hacker
find hac
find hak
```

### Sample Output - [download](https://github.com/tdantas/js-clj-challenge/blob/master/output.txt)
```
2
0
```

### Explanation

We perform the following sequence of operations:

Add a contact named hack.  
Add a contact named hacker.  
Find and print the number of contact names beginning with hac.   
There are currently two contact names in the application and both of them start with hac, so we print  on a new line.  
Find and print the number of contact names beginning with hak.   
There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.  
