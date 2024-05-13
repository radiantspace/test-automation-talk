from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/add', methods=['GET'])
def add():
    """Perform addition"""
    try:
        a = float(request.args.get('a'))
        b = float(request.args.get('b'))
        result = a + b
        return jsonify(result=result)
    except Exception as e:
        return jsonify(error=str(e))

@app.route('/subtract', methods=['GET'])
def subtract():
    """Perform subtraction"""
    try:
        a = float(request.args.get('a'))
        b = float(request.args.get('b'))
        result = a - b
        return jsonify(result=result)
    except Exception as e:
        return jsonify(error=str(e))

@app.route('/multiply', methods=['GET'])
def multiply():
    """Perform multiplication"""
    try:
        a = float(request.args.get('a'))
        b = float(request.args.get('b'))
        result = a * b
        return jsonify(result=result)
    except Exception as e:
        return jsonify(error=str(e))

@app.route('/divide', methods=['GET'])
def divide():
    """Perform division"""
    try:
        a = float(request.args.get('a'))
        b = float(request.args.get('b'))
        if b == 0:
            raise ValueError("Cannot divide by zero.")
        result = a / b
        return jsonify(result=result)
    except Exception as e:
        return jsonify(error=str(e))

if __name__ == '__main__':
    app.run(debug=True)
