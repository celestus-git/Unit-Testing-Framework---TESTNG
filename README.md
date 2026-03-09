# 📝 QA Automation Project: Calculator Library Testing

## 📌 Project Overview
This project contains a comprehensive automated unit testing suite for the `Calculator-1.0.jar` library. The framework was built using **Java**, **TestNG**, and **Maven**, focusing on validating arithmetic, trigonometric, and logical operations through a data-driven approach.

---

## 🛠️ Tech Stack
* **Language:** Java 11/17
* **Testing Framework:** TestNG (Data-Driven with `@DataProvider`)
* **Reporting:** ExtentReports (Interactive HTML)
* **Build Tool:** Maven
* **Execution Mode:** Parallel execution at the class level (4 threads).

---

## 🧪 Test Coverage (16 Methods Tested)

Below is the detailed list of the methods tested from the `Calculator` library, categorized by functional groups.

### 1. Arithmetic Operations (`groups = "arithmetic"`)
| Method | Data Type | Description | Status |
| :--- | :---: | :--- | :---: |
| `sum` | `long` | Addition of long integers | ✅ PASS |
| `sum` | `double` | Addition of decimal numbers | ✅ PASS |
| `sub` | `long` | Subtraction of long integers | ✅ PASS |
| `sub` | `double` | Subtraction of decimal numbers | ✅ PASS |
| `mult` | `long` | Multiplication of long integers | ✅ PASS |
| `mult` | `double` | Multiplication of decimal numbers | ❌ FAIL |
| `div` | `long` | Integer division (with `/0` handling) | ✅ PASS |
| `div` | `double` | Decimal division | ✅ PASS |
| `pow` | `double` | Calculation of number powers | ❌ FAIL |
| `sqrt` | `double` | Square root calculation | ❌ FAIL |

### 2. Trigonometric Operations (`groups = "trigonometric"`)
| Method | Data Type | Description | Status |
| :--- | :---: | :--- | :---: |
| `sin` | `double` | Sine of an angle | ✅ PASS |
| `cos` | `double` | Cosine of an angle | ❌ FAIL |
| `tg` | `double` | Tangent of an angle | ❌ FAIL |
| `ctg` | `double` | Cotangent of an angle | ❌ FAIL |

### 3. Logical Operations (`groups = "logic"`)
| Method | Data Type | Description | Status |
| :--- | :---: | :--- | :---: |
| `isPositive` | `long` | Checks if a number is > 0 | ✅ PASS |
| `isNegative` | `long` | Checks if a number is < 0 | ✅ PASS |

---

## 📊 Execution Summary & Bug Analysis
Based on the generated `calculator-report.html`, the suite executed **28 tests** with **22 passes** and **6 failures**.



### 1. Trigonometric Bugs
The library maps incorrect mathematical functions:
* **The Cosine Bug:** `public double cos(double a) { return Math.sin(a); }`
   * *Result:* Tests for `cos` fail because it returns the Sine value.
* **The Cotangent Bug:** `public double ctg(double a) { return Math.tanh(a); }`
   * *Result:* It returns the Hyperbolic Tangent instead of the Cotangent ($1/tan$).
* **The Tangent Ripple Effect:** `tg` fails because it relies on the broken `cos` method (`sin/cos`).
---
### 2. Precision and Rounding Defects (`double`)
The library suffers from forced data loss in decimal operations:
* **Forced Rounding in Mult:** `public double mult(double a, double b) { return Math.floor(a * b); }`
   * *Result:* Any decimal result is rounded down to the nearest integer, failing precision tests.
* **Truncated Exponents:** `public double pow(double a, double b) { return Math.pow(a, Math.floor(b)); }`
   * *Result:* The decimal part of any exponent is ignored. $9^{0.5}$ becomes $9^0 = 1.0$.
* **Square Root "Correction":** `return Math.sqrt(Math.abs(a));`
   * *Result:* Forced absolute value prevents standard `NaN` or `Exception` handling for negative inputs.
---

## 🚀 How to Run the Tests

1. Ensure `calculator.jar` is in the `/lib` folder.
2. Run the following command in the terminal:
   ```bash
   mvn clean test
   
3. Open the report: target/calculator-report.html.
