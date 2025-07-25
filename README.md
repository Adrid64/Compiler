# 📦 Lenguaje.2025 Compiler

This repository contains a complete compiler designed for the *Programming Language Design* course at the University of Oviedo.

## 🎯 Project Objective

The goal is to implement a full compiler for a custom, statically-typed, structured programming language. It features primitive and composite types, procedures and functions,
expressions, control flow, casting, and structured I/O — all compiled into an intermediate assembly language known as **MAPL**.

---

## 🛠️ Technologies Used

- **Java 17**
- **ANTLR 4** — for lexical and syntactic analysis
- **VGen** — for generating the abstract syntax tree (AST)
- **MAPL (Mini Assembly Programming Language)** — intermediate target code
- **TextVM** — for interpreting and executing MAPL code

---

## 🧱 Compiler Phases

This compiler is organized into modular phases:

1. **Lexical Analysis**: Defined using regular expressions and ANTLR.
2. **Syntactic Analysis**: Grammar written in ANTLR4 to parse valid programs.
3. **AST Construction**: Built using VGen based on the concrete parse tree.
4. **Semantic Analysis**:
   - Identification of variable/function declarations
   - Type checking
   - Scope and context validation
5. **Memory Allocation**: Calculates offsets for local/global variables and parameters.
6. **Code Generation**:
   - Generates valid MAPL code from AST
   - Supports expressions, statements, control structures, I/O, and function calls
7. **Execution**: Output MAPL can be executed using the `TextVM` interpreter.

---

## 💡 Language Features

### ✅ Syntax Overview

```plaintext
class CLASS_NAME;

global
  types
    deftuple struct1 as
      x: INTEGER;
      y: DOUBLE;
    end
  vars
    a: struct1;
    arr: [10] INTEGER;

create
  main;

feature main is
  local
    i: INTEGER;
  do
    print 'H', 'i';
    read i;
    println factorial(i);
end

run main();
```

### 🧩 Language Highlights

- **Primitive types**: INTEGER, DOUBLE, CHARACTER
- **Composite types**: arrays, deftuple structs
- **Functions and procedures** (`feature`)
- **Explicit casting**: e.g. `to<INTEGER>(5.5)`
- **Unary and binary expressions**: arithmetic, logical, relational
- **Control flow**: if, from...until...loop
- **I/O**: read, print, println (character-by-character only)
- *No string type, no implicit conversions*
