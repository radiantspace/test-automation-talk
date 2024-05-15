# Python Calculator App

## Overview
This simple web-based calculator app is written in Python using Flask. It supports basic arithmetic operations: addition, subtraction, multiplication and division.

## Setup and Usage

### Requirements
- Python 3.8 or higher
- Flask

### Installation
1. Set up a Codespace from this repo (Recommended). Alternatively, clone the repository to your local machine.
2. Navigate to the `calculator-apps/python-calculator-app` directory.
3. Install the required dependencies using `pip install -r requirements.txt`.

### Running the App
To run the app, execute the following command in the terminal:
```
python app.py
```
The app will start running on `http://localhost:5000`. You can perform calculations by accessing this URL in your web browser. Ex: `http://127.0.0.1:5000/add?a=3&b=2`

### Running Unit Tests
Unit tests are located in the `tests` directory. To run them, execute the following command:
```
python -m unittest discover -s tests
```

Note: Initially running this command you should see how 1 test runs and passes. 

# To do
Implement the missing methods inside the `app.py` script and their respective tests in the `test_calculator.py` file. 
You can go as far as you want! 
Starting to test the simple functionality and going deeper into more specific cases! (Check the comment in the test file for ideas)
