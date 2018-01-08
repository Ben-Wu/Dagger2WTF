# Dagger2WTF

<b>W</b>orking <b>T</b>echnical <b>F</b>oundations for Dagger 2


### Named Qualifier

The `@Named` qualifier allows a module to provide multiple dependencies
of the same type.

[Provides example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeModule.java#L25)
[Inject example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeActivity.java#L30)

### Lazy Initialization

`Lazy<T>` and `Provider<T>` can be used to postpone initialization of injected object.
This can speed up activity startup.  `Lazy<T>.get()` will create the
 object and then cache it so future calls to `get()` will return the
 same object.  On the other hand, `Provider<T>.get()` will return a new
 instance each time.

[Example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeActivity.java#L30)

### Static Dependencies

If a dependency a module provides does not require a specific instance
of the module, it can be made static.  This provides a performance
improvement by not using a module instance.

[Example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeModule.java#L28)
