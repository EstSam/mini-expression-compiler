# mini-expression-compiler
Java project for expression parsing and evaluation

# Mini Expression Compiler

## Project Overview

This project simulates a simple compiler that processes arithmetic expressions through multiple stages, similar to how real programming languages are interpreted.

The system takes a mathematical expression as input and performs:

* Lexical Analysis (Tokenization)
* Parsing using Context-Free Grammar
* Abstract Syntax Tree (AST) construction
* Evaluation of the expression

This project demonstrates core concepts from compiler design and Java programming. 

---

## Features

* Supports operators: +, -, *, /
* Handles parentheses
* Builds an expression tree (AST)
* Evaluates expressions correctly
* Displays token stream and final result

---

## Project Structure

MiniExpressionCompiler/

* Main.java → Runs the program
* Token.java → Defines token objects
* Tokenizer.java → Converts input into tokens
* Parser.java → Builds expression tree
* Node.java → Tree node structure
* Evaluator.java → Evaluates the AST

---

## How to Run

### 1. Compile the program

```bash
javac *.java
```

### 2. Run the program

```bash
java Main
```

---

## Example

### Input

```
(3 + 2) * 5 - 1
```

### Output

```
Tokens: [(, 3, +, 2, ), *, 5, -, 1]
Result: 24
```

---

## How It Works

### 1. Tokenizer

Breaks the input string into tokens such as numbers, operators, and parentheses.

### 2. Parser

Uses recursive descent parsing based on grammar rules:

* E → E + T | E - T | T
* T → T * F | T / F | F
* F → (E) | number

### 3. AST (Abstract Syntax Tree)

Builds a tree representation of the expression.

### 4. Evaluator

Traverses the tree to compute the final result.

---

## Test Cases

Valid:

* 3 + 4 * 2
* (1 + 2) * (3 + 4)

Invalid:

* 3 + * 5
* ()
* 3 + (4 - )

---

## Contributors

Samuel Estifanos 
James Lapenna 

---

## Notes

This project is a simplified simulation of compiler behavior and focuses on expression evaluation rather than full language compilation.
