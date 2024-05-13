const calculator = new Calculator();

// Event listeners for operation buttons
document.getElementById('add').addEventListener('click', function() {
    const number1 = parseFloat(document.getElementById('number1').value);
    const number2 = parseFloat(document.getElementById('number2').value);
    document.getElementById('calculation-result').textContent = calculator.add(number1, number2);
});

document.getElementById('subtract').addEventListener('click', function() {
    const number1 = parseFloat(document.getElementById('number1').value);
    const number2 = parseFloat(document.getElementById('number2').value);
    document.getElementById('calculation-result').textContent = calculator.subtract(number1, number2);
});

document.getElementById('multiply').addEventListener('click', function() {
    const number1 = parseFloat(document.getElementById('number1').value);
    const number2 = parseFloat(document.getElementById('number2').value);
    document.getElementById('calculation-result').textContent = calculator.multiply(number1, number2);
});

document.getElementById('divide').addEventListener('click', function() {
    const number1 = parseFloat(document.getElementById('number1').value);
    const number2 = parseFloat(document.getElementById('number2').value);
    document.getElementById('calculation-result').textContent = calculator.divide(number1, number2);
});
