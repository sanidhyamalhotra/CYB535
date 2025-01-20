import pytest
from math_utils import MathUtils

class TestMathUtils:

    def test_add(self):
        assert MathUtils.add(2, 3) == 5
        assert MathUtils.add(-1, 5) == 4
        assert MathUtils.add(0, 0) == 0

    def test_subtract(self):
        assert MathUtils.subtract(10, 5) == 5
        assert MathUtils.subtract(0, 5) == -5
        assert MathUtils.subtract(5, 0) == 5

    def test_multiply(self):
        assert MathUtils.multiply(2, 3) == 6
        assert MathUtils.multiply(-1, 5) == -5
        assert MathUtils.multiply(0, 5) == 0

    def test_divide(self):
        assert MathUtils.divide(10, 2) == 5.0
        assert MathUtils.divide(10, 0) == -1.0
        assert MathUtils.divide(0, 5) == 0.0
        assert MathUtils.divide(-6, 3) == -2.0
