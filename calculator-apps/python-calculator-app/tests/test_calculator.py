import unittest
from app import app

class TestCalculator(unittest.TestCase):
    def setUp(self):
        app.testing = True
        self.app = app.test_client()

    def test_addition(self):
        response = self.app.get('/add?a=10&b=5')
        # ensure a correct status code
        self.assertEqual(response.status_code, 200)
        # ensure correct result
        self.assertEqual(response.json['result'], 15)

    #def test_subtraction(self):

    #def test_multiplication(self):

    #def test_division(self):
        
    #def test_division_by_zero(self):

    #def test_wrong_args_passed(self):
        #self.assertEqual(response.json['error'], "float() argument must be a string or a real number, not 'NoneType'")

    #def test_square_root(self):

    """
        You done with the simpler tests? ... Can you make sure they handle exemptions? 
        1. What happens if an argument is not provided?
        2. What happens if the user provides a string instead of an integer?
        3. What if negative numbers are given to the square root GET request?

        And like these cases, all things to take into account can be tested!
        We need those tests to ensure automatically that our code behaves as we expect it to :)
    """
    
if __name__ == '__main__':
    unittest.main()
