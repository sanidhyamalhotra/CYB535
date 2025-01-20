import pytest
from math_utils import MathUtils

@pytest.mark.parametrize("a, b, expected", [
    (1, 2, 3),
    (-1, 1, 0),
    (0, 0, 0),
    (100, 200, 300)
])
def test_add(a, b, expected):
    assert MathUtils.add(a, b) == expected

@pytest.mark.parametrize("a, b, expected", [
    (5, 3, 2),
    (0, 5, -5),
    (-3, -3, 0),
    (100, 50, 50)
])
def test_subtract(a, b, expected):
    assert MathUtils.subtract(a, b) == expected

@pytest.mark.parametrize("a, b, expected", [
    (2, 3, 6),
    (-1, 5, -5),
    (0, 100, 0),
    (10, -10, -100)
])
def test_multiply(a, b, expected):
    assert MathUtils.multiply(a, b) == expected

@pytest.mark.parametrize("a, b, expected", [
    (10, 2, 5.0),
    (5, 2, 2.5),
    (0, 1, 0.0),
    (5, 0, -1.0)  # Edge case: division by zero
])
def test_divide(a, b, expected):
    assert MathUtils.divide(a, b) == expected