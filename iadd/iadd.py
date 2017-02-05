# Special methods in Python: Use __iadd__ to increment in-place; use __add__ to increment and create a new instance.
# Author: Zhuo Lu

# Test suite 1
print("\nTest suite 1\n")

_i = i = 0      # Test int
_t = t = (1, 2) # Test tuple
_l = l = [1, 2] # Test list

i += 1
t += (3,)
l += [3]

print(_i, i, _i is i) # Output: 0 1 False
print(_t, t, _t is t) # Output: (1, 2) (1, 2, 3) False
print(_l, l, _l is l) # Output: [1, 2, 3] [1, 2, 3] True

# Test suite 2
print("\nTest suite 2\n")

class Foo:
    i = 0
    t = (1, 2)
    l = [1, 2]

    def inc(self):
        self.i += 1
        self.t += (3,)
        self.l += [3]

f = Foo()
print(Foo.i, f.i, Foo.i is f.i) # Output: 0 0 True
print(Foo.t, f.t, Foo.t is f.t) # Output: (1, 2) (1, 2) True
print(Foo.l, f.l, Foo.l is f.l) # Output: [1, 2] [1, 2] True

f.inc()
print("After calling `inc()`:")
print(Foo.i, f.i, Foo.i is f.i) # Output: 0 1 False
print(Foo.t, f.t, Foo.t is f.t) # Output: (1, 2) (1, 2, 3) False
print(Foo.l, f.l, Foo.l is f.l) # Output: [1, 2, 3] [1, 2, 3] True

# Test suite 3
print("\nTest suite 3\n")

class Foo:
    i = 0
    t = (1, 2)
    l = [1, 2]

    def inc(self):
        self.i = self.i + 1
        self.t = self.t + (3,)
        self.l = self.l + [3]

f = Foo()
print(Foo.i, f.i, Foo.i is f.i) # Output: 0 0 True
print(Foo.t, f.t, Foo.t is f.t) # Output: (1, 2) (1, 2) True
print(Foo.l, f.l, Foo.l is f.l) # Output: [1, 2] [1, 2] True

f.inc()
print("After calling `inc()`:")
print(Foo.i, f.i, Foo.i is f.i) # Output: 0 1 False
print(Foo.t, f.t, Foo.t is f.t) # Output: (1, 2) (1, 2, 3) False
print(Foo.l, f.l, Foo.l is f.l) # Output: [1, 2] [1, 2, 3] False
