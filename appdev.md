<!--
Android app development
  Java vs Kotlin
  Kotlin preferred
Android DX
  Android Studio vs Intellj
  Android Studio preferred
UI development
  XML vs Compose
  Compose preferred
-->

Jetpack Compose  
  Compose functions are building blocks that describe UI but don't return anything.  
  They can take input and generate it on screen  

Annotations  
> @Composable  
>     fun greet(){...} //Name of composable function and {contents}  
Other annotations  
> @Preview(parameters)  

The Compose function:  
MUST be a noun: DoneButton()  
NOT a verb or verb phrase: DrawTextField()  
NOT a nouned preposition: TextFieldWithLink()  
NOT an adjective: Bright()  
NOT an adverb: Outside()  
Nouns MAY be prefixed by descriptive adjectives: RoundIcon()  

Architecture Principles  
Unidirectional flow. Events move up, data flows down.  

|![image](https://github.com/lsrprntr/android-kotlin-projects-practice/assets/39038103/b86ce376-fc66-4185-847c-0d14bb8f5dd0)|![image](https://github.com/lsrprntr/android-kotlin-projects-practice/assets/39038103/88b7fae6-5c49-4724-bc89-ded4d4eafa06)|
|---|---|

DATA LAYER (Data sources)  
vvv  
UI LAYER (UI and state holders)  
- view models are stateholders  

UI elements send events to view model.  
View model updates ui state and recomposes Ui elements.  

Passing in the required objects is called dependency injection (DI). It is also known as inversion of control.  

DI is when a dependency is provided at runtime instead of being hardcoded into the calling class.  

Implementing dependency injection:  
    Helps with the reusability of code. Code is not dependent on a specific object, which allows for greater flexibility.  
    Makes refactoring easier. Code is loosely coupled, so refactoring one section of code does not impact another section of code.  
    Helps with testing. Test objects can be passed in during testing.  

ViewModel  
There are three ways to declare a MutableState object in a composable:  
> val mutableState = remember { mutableStateOf(defaultvalue) }  
> var value by remember { mutableStateOf(defaultvalue) }  
> val (value, setValue) = remember { mutableStateOf(defaultvalue) }


You make a viewModel which holds states.  
You split the states into UiStates with their own interfaces.  
That should cover the Ui Layer.  

Retrofit  
- takes parameters then performs GET request; receives JSON and returns Kotlin Objects
![image](https://github.com/lsrprntr/android-kotlin-projects-practice/assets/39038103/45603eec-40a6-4148-ad82-786f624c6d8a)



To split the Data Layer, you need to add dependency injection and repositories.  

**What is a repository?**  
In general a repository class:  
- Exposes data to the rest of the app.  
- Centralizes changes to data.  
- Resolves conflicts between multiple data sources.  
- Abstracts sources of data from the rest of the app.  
- Contains business logic.  
- The repository naming convention is type of data + Repository.

![image](https://github.com/lsrprntr/android-kotlin-projects-practice/assets/39038103/2f2b5b13-ea57-47c9-90b5-4cfb2684e330)


DI is when a dependency is provided at runtime instead of being hardcoded into the calling class.  

Implementing dependency injection:  
- Helps with the reusability of code. Code is not dependent on a specific object, which allows for greater flexibility.
- Makes refactoring easier. Code is loosely coupled, so refactoring one section of code does not impact another section of code.
- Helps with testing. Test objects can be passed in during testing.
To fix this issue, instead of the ViewModel creating the repository, we need a way to decide and pass a repository instance to use for production and test dynamically.

This process is done by implementing an application container that provides the repository to the ViewModel.  

A container is an object that contains the dependencies that the app requires. These dependencies are used across the whole application, so they need to be in a common place that all activities can use. You can create a subclass of the Application class and store a reference to the container.  

To me dependency injection is hoisting the variables into the constructors.  

This process is done by implementing an application container that provides the repository to MarsViewModel.  



