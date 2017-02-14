# Inheritance

## Java

### Abstract

The static type of a variable, especially when coupled with a dynamic subclass instance, is useful but confusing in the following scenarios:

- **Calling a method with the variable being an argument**

    If an overloaded method somewhere takes in the type of both a superclass and a subclass, the static type of the variable is used to determine which method is called. Even if an instance is of the type subclass and the static type of superclass, the overloaded method will identify the superclass.

- **Looking up an overloaded method**

    When a subclass extends a superclass while *overloading* a new method (in simpler words, making a new method with a same name but different parameters), calling a method when the static type is the superclass will *not* invoke the overloaded method in the subclass. Only the methods defined in the superclass may be looked up dynamically as like the superclass is unaware of the presence of the overloaded methods in the subclass. 
    
    See: [OverridingAndOverloading.java](OverridingAndOverloading.java)

- **Invoking a static method**

    Calling a static method from an instance depends on the static type of the instance. For example, even though the instance dynamic type could be a subclass, the superclass static type of that instance calls the static method from the superclass.
     
     See: [StaticPlayground.java](StaticPlayground.java)

- **Static type of this**

    Not directly linked to inheritance in Java, the `this` keyword should of the type inferred from the class in which `this` is used. For example, let there be a subclass extending a superclass: `this` in a method in the superclass should have the static type of the superclass.
    
    See: [WhatTypeIsType.java](WhatTypeIsThis.java)

- **Looking up an instance field**
    
    When hiding field, the content of a field may be different depending on the static type of a instance even for pointing to a same object.

    See: [FieldHiding.java](FieldHiding.java)

### Field Hiding

> Within a class, a field that has the same name as a field in the superclass hides the superclass's field, even if their types are different. Within the subclass, the field in the superclass cannot be referenced by its simple name. Instead, the field must be accessed through super, which is covered in the next section. Generally speaking, we don't recommend hiding fields as it makes code difficult to read.

From: [Hiding Fields](https://docs.oracle.com/javase/tutorial/java/IandI/hidevariables.html)

### Overriding and Overloading

> An instance method in a subclass with the same signature (name, plus the number and the type of its parameters) and return type as an instance method in the superclass overrides the superclass's method.

From: [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)

### Static Method Hiding

> If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.
> 
> The distinction between hiding a static method and overriding an instance method has important implications:
>
> - The version of the overridden instance method that gets invoked is the one in the subclass.
>
> - The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.

From: [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)
