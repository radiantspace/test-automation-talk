#include <gtest/gtest.h>
#include "../Calculator.h"

class CalculatorTests : public ::testing::Test {
protected:
    Calculator calc;
};

TEST_F(CalculatorTests, AdditionTest) {
    EXPECT_DOUBLE_EQ(5.0, calc.add(2, 3));
}

TEST_F(CalculatorTests, SubtractionTest) {
    EXPECT_DOUBLE_EQ(-1.0, calc.subtract(2, 3));
}

TEST_F(CalculatorTests, MultiplicationTest) {
    EXPECT_DOUBLE_EQ(6.0, calc.multiply(2, 3));
}

TEST_F(CalculatorTests, DivisionTest) {
    EXPECT_DOUBLE_EQ(2.0, calc.divide(6, 3));
}

TEST_F(CalculatorTests, DivisionByZeroTest) {
    EXPECT_THROW(calc.divide(1, 0), const char*);
}

TEST_F(CalculatorTests, InvalidInputTest) {
    // This test is a placeholder for future implementation
    // It's intended to test handling of invalid inputs such as strings or special characters
    // Currently, the Calculator class does not handle such cases
    // EXPECT_THROW(calc.add("a", 2), std::invalid_argument);
}
