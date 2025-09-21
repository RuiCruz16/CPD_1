# Parallel and Distributed Computing (CPD)  
## Project – Matrix Multiplication

### Objectives
The main goal of this project, developed in the **second semester of the third year**, was to **analyze the impact of memory hierarchy and parallelism** on the performance of matrix multiplication algorithms.  

Specifically, the objectives were to:  
- Compare different matrix multiplication algorithms in **C/C++** and **Java**.  
- Evaluate performance metrics such as **execution time, cache misses (L1/L2), and MFLOPS**.  
- Explore **parallelization techniques on multicore systems** and measure gains in terms of *speedup* and *efficiency*.  

---

### Implemented Algorithms
1. **Simple Multiplication**  
   - Classical row × column approach.  
   - Used as a baseline for comparisons.  

2. **Line × Line Multiplication**  
   - Sequential memory access, reducing cache misses.  
   - Implemented in **C/C++** and **Java**.  

3. **Block Multiplication**  
   - Matrices are divided into smaller blocks to improve **spatial locality**.  
   - Implemented only in **C/C++**.  

4. **Parallel Versions (Line × Line)**  
   - **Outer loop parallelization**: each thread processes contiguous rows.  
   - **Inner loop parallelization**: better scalability for very large matrices.  

---

### Performance Metrics
The following metrics were collected:  
- **Execution time**  
- **Cache misses** (L1 and L2)  
- **MFLOPS (Floating Point Operations per Second)**  
- **Speedup** and **Efficiency** for parallel versions  

Measurements were performed using **PAPI (Performance API)** on a system with:  
- Intel i5-1135G7 @ 2.40GHz  
- 96 KB L1 cache per core  
- 1.25 MB L2 cache per core  
- 8 MB shared L3 cache  
- Ubuntu 22.04  

---

### Results & Conclusions
- The **Line × Line algorithm** outperformed the **Simple algorithm** due to better cache usage.  
- **Block Multiplication** showed advantages for very large matrices, with fewer L2 cache misses.  
- **Parallel versions** achieved significant gains compared to the single-core version:  
  - **Outer loop parallelization** was more efficient for small/medium matrices.  
  - **Inner loop parallelization** scaled better with large matrices.  

This project highlights that **memory access patterns** and **parallelization strategies** are crucial to optimizing performance in modern multicore systems.  

---

### Project Structure
- `report_assign1_t09g16.pdf` – Full project report  
- `matrixproduct.cpp` – C/C++ implementation of the algorithms  
- `MatrixProduct.java` – Java implementation (Simple and Line × Line)  

---

### How to Compile & Run

#### C/C++ (Linux / g++)  
```bash
g++ -O2 -lpapi matrixproduct.cpp -o matrixproduct
./matrixproduct
```

#### Java
```bash
javac MatrixProduct.java
java MatrixProduct
```
