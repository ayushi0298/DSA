/*
public class InterviewExperience {
/*public void finalize(){System.out.println("object is garbage collected");}
        public static void main(String args[]){
            InterviewExperience s1=new InterviewExperience();
            InterviewExperience s2=new InterviewExperience();
            s1=null;
            s2=null;
            System.gc();

/* public static void main(String args[]) {
Predicate<Integer> p = i -> (i < 11);
            System.out.println(p.test(10));
            Optional<String> optionalS= Optional.empty();
            System.out.println(optionalS);
            String book = null;
            if(book!=null){
                System.out.println(book.toUpperCase());
            }
 */
/*optionalS = Optional.ofNullable(book);
            if(optionalS.isPresent()){
                System.out.println(optionalS.get().toUpperCase());


*/  
/* HASHEDIN EXPERIENCE:
    Round 1:selected
       1) Question: https:  //www.geeksforgeeks.org/efficiently-compute-sums-of-diagonals-of-a-matrix/
          I answered it correctly and provided the solution as expected.
       2) Question:https://www.geeksforgeeks.org/palindrome-pair-in-an-array-of-words-or-strings/
          I started with brute force and was not able to give efficient solution.

       Round 2:rejected
       many mistakes i made and various things im not aware of
       -java 8 features
       -hashcode making

       ACCOLITE EXPERIENCE:
       Round 1:
       1) Question: Count pair whose sum= k.
       2) Tell me the approach that u use for implementation for stack: I told him first Array and the LinkedList.
       3) multithreading deep mein(Unable to answer)
       4) Hashmap in deep (Able to answer)
       5) Autoboxing

       PUBLIICS SAPHIENT EXPERIENCE:(Rejected)
       1) JAVA 8 features: Streams and Lambda expressions: have written that
       2) Design patterns:
           1) write a singelton class- I was not able to write it
           2)Write a factory class: started but then he stopped
       3)Callable and Runnable- done
       4)Internal working of HashMap
       5)Multithreading- fork anf join and executer service
       6) Tools and all
       7) In pom.xml depedencies which we need to add.
/*
 * PAYU experience
 * Round 1: Duration(30 minutes)
 * Questions related to core java: Polymorphism, Comparable and Comparator, Immuatablity and why strings are immuatable, JAVA 8 features, STATIC method can be overloaded or overrided.
 * Coding question: remove duplicates from a string without using Collection framework.
 * */
/*
Can we override a static method?
  No, we cannot override static methods because method overriding is based on dynamic binding at runtime and the static methods are bonded using static binding at compile time. So, we cannot override static methods.
  The calling of method depends upon the type of object that calls the static method. It means:
  If we call a static method by using the parent class object, the original static method will be called from the parent class.
  If we call a static method by using the child class object, the static method of the child class will be called.
*/


/*  Siemens experience:
*ROUND 1:
*DSA:  Tree traversals(Iterative and recursive approaches) with tc and sc. Inorder,PreOrder,Postorder,LevelOrder
*
*
*
* */


/* DELL Interview Expereince:

Round 1:
1. Basic java questions like: Method overloading and method overriding, Inheritance---Improvement: Could be more precise
2. Coding questions: Print k frequent elements in an array-- solved successfully
3. Aptitude questions: 2

Round 2:
1. Few java code questions which are pasted below:

What is the output?
A: public class Demo{
public static void main(String[] arr){
 System.out.println(“Main1”);
 }
public static void main(String arr){ 
System.out.println(“Main2”);
}
}
Main1
Main2

B: What is the output?
class Test
{
 static int i;
 static
 {
 System.out.println(“a”);
 i = 100;
 }
}
public class StaticBlock
{
 static
 {
 System.out.println(“b”);
 }
 public static void main(String[] args)
 {
 System.out.println(“c”);
 System.out.println(Test.i);
 }
}

C:
What is the output?
public class Test {
public void print(Integer i) {
System.out.println("Integer");
}

public void print(int i) {
System.out.println("int");
}

public void print(long i) {
System.out.println("long");
}

public static void main(String args[]) {
Test test = new Test();
test.print(10);
}
}

D: lass BaseClass{
int arr[10];
};

class DerivedBaseClass1: public BaseClass { };

class DerivedBaseClass2: public BaseClass { };

class DerivedClass: public DerivedBaseClass1, public DerivedBaseClass2{};

int main(void)
{
cout<<sizeof(DerivedClass);
return 0;
}
20—

3. Questions related to java 8 features: Functional interface, Default and static methods
4. Second-highest salary: SELECT Salary FROM
(SELECT Salary FROM Employee ORDER BY salary DESC LIMIT 2) AS Emp ORDER BY salary LIMIT 1;

* */







