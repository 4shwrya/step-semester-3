# STEP Semester 3

This repository contains the assignments and practice problems completed using Java as part of STEP Semester 3. Work is organised week by week, with one branch per week.

**Author:** Aishwarya

---

## Branch Structure

| Branch | Purpose |
|---|---|
| `main` | README only |
| `dev` | Project skeleton |
| `feature/week1` | Week 1: Java String Concepts |
| `feature/week2` | Week 2: String Operations and Performance |
| `feature/week3` | Week 3: OOP Introduction, Classes and Objects |
| `feature/week4` | Week 4: Programming Constructs & OOP Fundamentals (Constructors, Java Keywords) |
| `feature/week5` | Week 5: Access Modifiers and Encapsulation |
| `feature/week6` | Week 6: OOP Inheritance and Polymorphism |
| `feature/week7` | Week 7: Abstraction and Interfaces |
| `feature/week8` | Week 8: Object Class Methods, Inner Classes & UML Diagrams |
| `feature/week9` | Week 9: Introduction to Data Structures |

---

## Folder Structure (inside every week branch)

```
feature/weekN
├── PracticeProblems/   → small problems to practise that week's topic
└── Assignment/         → the given assignments for that week
```

---

## Weekly Overview

### Week 1: Java String Concepts
Core ideas behind Strings in Java: creating and comparing strings, immutability, and common built-in methods.

### Week 2: String Operations and Performance
Working with strings in depth, including manipulation operations and the performance differences between `String`, `StringBuilder` and `StringBuffer`.

### Week 3: OOP Introduction, Classes and Objects
First steps into object-oriented programming: defining classes, creating objects, fields and methods.

### Week 4: Programming Constructs & OOP Fundamentals
Constructors (default, parameterised, overloaded) and important Java keywords such as `this`, `static` and `final`.

### Week 5: Access Modifiers and Encapsulation
Using `private`, `default`, `protected` and `public` to control access, and applying encapsulation with getters and setters.

### Week 6: OOP Inheritance and Polymorphism
Reusing code with inheritance, method overriding, and compile-time and run-time polymorphism.

### Week 7: Abstraction and Interfaces
Abstract classes and interfaces, and when to use each to design flexible code.

### Week 8: Object Class Methods, Inner Classes & UML Diagrams
Methods inherited from the `Object` class (`toString`, `equals`, `hashCode`), inner classes, and modelling designs with UML diagrams.

### Week 9: Introduction to Data Structures
Arrays and the basics of choosing a data structure, with problems on:
- Binary search
- Hashing
- Two pointers
- Sliding window
- Time and space complexity analysis (Big-O)

---

## How to Run

Check out the week you want, then compile and run from inside the folder:

```bash
git checkout feature/week9
cd PracticeProblems
javac *.java
java <ClassName>
```

Each file has its own `main` method, and the class name matches the file name.

---

## Tech Used

- Java
- Git and GitHub
