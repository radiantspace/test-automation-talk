import unittest
from app import app

class TestCalculator(unittest.TestCase):
    def setUp(self):
        app.testing = True
        self.app = app.test_client()

    def test_addition(self):
        response = self.app.get('/add?a=10&b=5')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json['result'], 15)

    #def test_subtraction(self):

    #def test_multiplication(self):

    #def test_division(self):
        
    #def test_division_by_zero(self):
        
if __name__ == '__main__':
    unittest.main()
