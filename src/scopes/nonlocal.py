# Lexical scoping in Python and an interesting scenario with resolving value in class.
# Author: Zhuo Lu

# Test suite 1

def test1():
    """
    Try to change a nonlocal variable of a parent frame.
    """

    def noeffect():
        # Uncomment the following line to show that local variable referenced before assignment
        # NB: UnboundLocalError will be raised
        # print(a)

        a = 2 # Does not affect `a` in the frame of `test1()`
        print(a)

    a = 1
    print(a)
    noeffect()
    print(a)

# Test suite 2

def test2():
    """
    Correct way to change a nonlocal variable.
    """

    def affect():
        # Uncomment the following lines to show use of local variable before calling nonlocal
        # NB: SyntaxWarning will be raised on that `a` is assigned before nonlocal declaration
        # print(a)
        # a = 3
        # print(a)

        # Use of nonlocal statement to modify variable from parent frame (excluding global)
        nonlocal a
        print(a)
        a = 2
        print(a)

    a = 1
    print(a)
    affect()
    print(a)
