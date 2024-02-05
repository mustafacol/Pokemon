
<h1 align="center">Soostone Pokemon</h1>



<p align="center">  
🗡️ Application demonstrates modern Android development with Hilt, Coroutines, Flow, Jetpack Compose, and Material Design based on MVVM architecture.
</p>
</br>



## Tech stack
- Minimum SDK level 24
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Jetpack
    - [Compose](https://developer.android.com/jetpack/compose): Jetpack Compose is Android’s recommended modern toolkit for building native UI. It simplifies and accelerates UI development on Android. Quickly bring your app to life with less code, powerful tools, and intuitive Kotlin APIs.
    - [Navigation](https://developer.android.com/jetpack/compose/navigation) The Navigation component provides support for Jetpack Compose applications. You can navigate between composables while taking advantage of the Navigation component's infrastructure and features.
    - Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
    - ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
    - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
    - MVVM Architecture (View - ViewModel - Model)
    - [Use Case Pattern](https://proandroiddev.com/why-you-need-use-cases-interactors-142e8a6fe576)
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging network data.
- [Gson](https://github.com/google/gson): Google's modern JSON library for Kotlin and Java.
- [Material-Components](https://github.com/material-components/material-components-android): Material design components for building ripple animation, and CardView.
- [Coil](https://coil-kt.github.io/coil/compose/):  An image loading library for Android backed by Kotlin Coroutines.

## Architecture
**Application** is based on the MVVM architecture and the Use Case pattern, which follows the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

The overall architecture of application is composed of three layers; the presentation layer, domain layer and the data layer. Each layer has dedicated components and they have each different responsibilities, as defined below:

<img src="https://developer.android.com/static/topic/libraries/architecture/images/mad-arch-overview.png" style="width:50%;"/>


### Architecture Overview

- Each layer follows (https://developer.android.com/topic/architecture/ui-layer#udf); the UI layer emits user events to the data layer, and the data layer exposes data as a stream to other layers.
- The data layer is designed to work independently from other layers and must be pure, which means it doesn't have any dependencies on the other layers.

With this loosely coupled architecture, you can increase the reusability of components and scalability of your app.

### Presentation Layer

The presenation layer consists of UI elements to configure screens that could interact with users and [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) that holds app states and restores data when configuration changes.

### Data Layer

The data Layer consists of repositories, which include business logic, such as querying data from the local database and requesting remote data from the network. It is implemented as an offline-first source of business logic and follows the [single source of truth](https://en.wikipedia.org/wiki/Single_source_of_truth) principle.<br>

### Domain Layer

The domain layer is responsible for encapsulating complex business logic, or simple business logic that is reused by multiple ViewModels. This layer is optional because not all apps will have these requirements. You should use it only when needed—for example, to handle complexity or favor reusability.
