# Personal Document Identification Automaton

This project is a simple **Java console application** that validates two types of Brazilian identification documents:

- **RG (Registro Geral)** → Brazilian identity card  
- **CPF (Cadastro de Pessoa Física)** → Brazilian individual taxpayer registry  

It uses **automaton-like logic** with digit checking and validation rules to ensure the entered document follows the correct format and verification digits.

---

## 📌 Features

- Detects whether the input is a **CPF** or **RG**  
- Supports both **formatted** and **unformatted** documents:
  - CPF → `345.570.950-89` or `34557095089`
  - RG → `21.527.759-4` or `215277594`
- Performs **check digit validation** according to Brazilian official rules
- Uses `try/catch` structure to first attempt **RG validation**, and if invalid, tries **CPF validation**
- Provides feedback on whether the document is valid or invalid

---

## 🛠️ Project Structure

```
├── 📁 .git/ 🚫 (auto-hidden)
├── ☕ DocumentVerifier.java
├── ☕ GeneralFunctions.java
├── 📖 README.md
├── ☕ VerifyCpf.java
└── ☕ VerifyRg.java
```

---

## ▶️ How to Run

1. Compile the project:
   ```bash
   javac *.java
   ```

2. Run the program:
   ```bash
   java DocumentVerifier
   ```

3. Enter a CPF or RG when prompted:
   ```
   Write the document you want to verify: 345.570.950-89
   ```

---

## 📖 Example Outputs

### ✅ Valid CPF
```
Write the document you want to verify: 345.570.950-89
Everything looks fine! Your document is a CPF!
First final digit calculated: 8
Second final digit calculated: 9
```

### ✅ Valid RG
```
Write the document you want to verify: 21.527.759-4
Everything looks fine! Your document is a RG
Final Digit Calculated: 4
```

### ❌ Invalid Document
```
Write the document you want to verify: 12345678900
The value collected isn't a CPF!
Exception in thread "main" java.lang.IllegalArgumentException: Invalid CPF!
```

---

## 📚 Notes

- This project is **educational**, created to demonstrate automaton-like validation in Java.
- The logic follows simplified versions of the Brazilian CPF and RG validation algorithms.
- You can extend this project to:
  - Handle other document types
  - Provide a graphical user interface (GUI)
  - Integrate with a database for storage and verification

---

## 👨‍💻 Author

Developed by **Heitor Ferreira**.
