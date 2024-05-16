#include <iostream>
#include "Calculator.h"

int main() {
    Calculator calc;
    double number1, number2, result;
    char operation;

    std::cout << "Enter first number: ";
    std::cin >> number1;

    std::cout << "Enter second number: ";
    std::cin >> number2;

    std::cout << "Enter operation (+, -, *, /): ";
    std::cin >> operation;

    try {
        switch (operation) {
            case '+':
                result = calc.add(number1, number2);
                break;
            case '-':
                result = calc.subtract(number1, number2);
                break;
            case '*':
                result = calc.multiply(number1, number2);
                break;
            case '/':
                result = calc.divide(number1, number2);
                break;
            default:
                std::cout << "Invalid operation" << std::endl;
                return 1;
        }

        std::cout << "Result: " << result << std::endl;
    } catch (const char* msg) {
        std::cerr << "Error: " << msg << std::endl;
    }

    return 0;
}
