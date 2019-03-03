# Faux
Annotation based generation of **fake** data class instances

#### If you can't mock it, fake it.

## Proof of concept
Given the following, Faux annotated model:
```kotlin
data class UserModel(

    @Faux(["1", "fakeUser"])
    val id: Int,

    @Faux(["faker", "fakeUser"])
    val username: String

)
```
The compiler generates the following top level function:
```kotlin
fun fakeUser() = UserModel(
    id = 1, username = "faker"
)
```
