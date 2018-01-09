# Dagger2WTF

<b>W</b>orking <b>T</b>echnical <b>F</b>oundations for Dagger 2

This is a project that demonstrates usage of [Dagger 2](https://google.github.io/dagger/).
There are working examples of many of the features of Dagger.

[Official Dagger Documentation](https://google.github.io/dagger/api/2.0/)

### Modules

Class that contributes objects to the dependency graph.  Methods are
annotated with `@Provides` to indicate that they contribute a dependency.

[Example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeModule.java)

[Example](/app/src/main/java/ca/benwu/dagger2wtf/network/NetworkModule.java)

### Components

Interface or abstract class connecting a module with an injection target.

[Example](app\src\main\java\ca\benwu\dagger2wtf\application\AppComponent.java)

### Component Dependencies

Components can be dependent on other components, allowing them to use
those bindings.  The dependent component can only use bindings exposed
by the other component.  Scoped components cannot depend on unscoped
components.

e.g.: [AppComponent](app\src\main\java\ca\benwu\dagger2wtf\application\AppComponent.java)
is dependent on
[NetworkComponent](\app\src\main\java\ca\benwu\dagger2wtf\network\NetworkComponent.java)

### Subcomponents

A subcomponent is a component that inherits all the bindings of its
parent.  The parent must know of its subcomponents so the parent and
subcomponent are tightly coupled.

e.g.: [HomeComponent](app\src\main\java\ca\benwu\dagger2wtf\home\HomeComponent.java)
is a subcomponent of
[AppComponent](app\src\main\java\ca\benwu\dagger2wtf\application\AppComponent.java)

### Scope

Components and bindings can be scoped so they are only instantiated the
appropriate number of times.  e.g. `@Singleton` means only one instantiation
per app.  Scoped components can only use same scoped or unscoped bindings.

[Custom scopes](app/src/main/java/ca/benwu/dagger2wtf/activity/ActivityScope.java) can also be used.

### Named Qualifier

The `@Named` qualifier allows a module to provide multiple dependencies
of the same type.

[Provides example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeModule.java#L25)

[Inject example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeActivity.java#L30)

### Constructor Injection

The constructor of an object can be annotated with `@Inject` so that a
module can use it as an argument to one of its objects.  The annotated
objects should be scoped to make it clear where they go in the graph.

[Annotated Constructor](/app/src/main/java/ca/benwu/dagger2wtf/utils/Child1Utils.java)

[Provides Example](/app/src/main/java/ca/benwu/dagger2wtf/home/HomeModule.java#L28)

### Binds Annotation

`@Binds` can be used instead of provides if the provided object has an
`@Inject`-annotated constructor.  This reduces code in the module.  The
module must be abstract and can only use `@Provide` with static objects.

[Example](/app/src/main/java/ca/benwu/dagger2wtf/comments/CommentUtilsModule.java)

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
