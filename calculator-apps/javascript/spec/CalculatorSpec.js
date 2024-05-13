describe("Calculator", function () {
  var calculator;

  beforeEach(function () {
    calculator = new Calculator();
  });

  it("should be able to add two numbers", function () {
    expect(calculator.add(1, 2)).toEqual(3);
  });

  // it("should be able to subtract two numbers", function() {

  // it("should be able to multiply two numbers", function() {

  // it("should be able to divide two numbers", function() {

  // it("should throw an error when dividing by zero", function() {
});
