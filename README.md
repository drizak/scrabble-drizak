# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

## CC3002 - Scrabble
Inside `src` folder there are 2 folders:

* `main` stores the logic of the program.
* `test` stores the JUnit5 tests classes.

### Building and Testing
Build with `gradle build`, and test with `gradle test`.


### Implementation details
* Binary types `SBinary` can be arithmetically operated with Float types `SFloat`,
  but as the decimal part of Float type will carry on to the output, the output
  type will be a `SFloat` too.
  
* `BinaryUtils.toInt` can only transform strings accurately into integers when  
  they hold less than 32 bits of data (or 32 characters).
  
* The package `cl.uchile.dcc.scrabble.utils` store utility (helper) classes, to avoid
  code cluttering inside others. ie: `BinaryUtils` stores some code related
  to binary numbers, in particular to avoid cluttering the `SBinary` class. 
  All classes in this package are well documented, and their purpose should be clear.
  
* Nodes inside the _Abstract Syntax Tree_ (AST) can be created with the `NodeFactory` class,
  this will create nodes with `null` children, so these must be manually set using
  `setOperandL(IEvaluable)`, `setOperandR(IEvaluable)`, `setOperand(IEvaluable)` (for internal nodes) or use `setValue(ISType)` for external nodes.
  
* ASTs may be created using the usual `new` statement, these require a root `IEvaluable` node as
  a constructor argument, and can be evaluated using the `evaluate()` method.
  
* Variable storing has been implemented via a singleton class `variableMap`, that must be instanced using the
  static method `variableMap.getInstance()`. Variables then can be stored in the instance with a String hash, 
  using the `setVar(String, ISType)`, and retrieved with `getVar(String)`.
  
* Flow Control is implemented via nodes that work inside an AST, to ensure a correct usage of
  `while` nodes within Scrabble, both executed and condition ASTs may need to refer to variables
  using the `variableMap` instance.

* An example AST using a While and If Nodes is present in the tests, using the Euclides Algorithm.

  * First, two integer values are randomized between 1 and 100 and stored into the Scrabble Variables
    `a` and `b`.
  * Then, the algorithm runs following this diagram:
    
    If the image below does not display correctly, it can be found [here](https://github.com/CC3002-Metodologias/scrabble-drizak/blob/tarea-3/diagrams/Tarea%203/AST_Euclides.png).
  
  ![Euclides Algorithm AST](https://raw.githubusercontent.com/CC3002-Metodologias/scrabble-drizak/tarea-3/diagrams/Tarea%203/AST_Euclides.png?token=ADGR52W5K6PAXK22JMYQCWDBA45OY)

  * Finally, the computed GCD is stored into the `b` variable 
  
