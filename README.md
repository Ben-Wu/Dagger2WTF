# Dagger2WTF

<b>W</b>orking <b>T</b>echnical <b>F</b>oundations for Dagger 2


### Static Dependencies

If a dependency a module provides does not require a specific instance
of the module, it can be made static.  This provides a performance
improvement by not using a module instance.

[Example](\app\src\main\java\ca\benwu\dagger2wtf\home\HomeModule.java)
