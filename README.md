<h1 align="center">ValorantInfo</h1>
<p align="center">  
Valorant Info app is a to demonstrate tech stacks with a MVVM architecture, with emphazies on Unit & UI testing.This app includes Valorant weapons and their features.
  </p>
</br>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.4.xxx-blue"/></a>
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>
  <a href="https://developer.android.com/kotlin/coroutines"><img alt="Coroutines" src="https://img.shields.io/badge/Coroutines-Asynchronous-red"/></a>
  
</p>

## Screenshots
<table>
    <tr>
    <td>Splash</td>
    <td>Home</td>
    <td>Detail</td>
    <td>Demo</td>
   </tr> 
  <tr>
    <td><img src="https://user-images.githubusercontent.com/57602386/216441590-e5a50a5a-3487-4566-bff0-37b8e69ea010.png" width="100%"></td>
    <td><img src="https://user-images.githubusercontent.com/57602386/216450952-6a72b6e5-e707-4a79-91e8-7715c91254f7.png" width="100%"></td>
    <td><img src="https://user-images.githubusercontent.com/57602386/216451187-7973cf88-e976-4e1e-b954-1ce122386f97.png" width="100%"></td>
    <td><img src="https://user-images.githubusercontent.com/77745850/216458781-fb821299-fe4d-4eca-a431-494540122c9f.gif" width="100%"></td>
   </tr>  
  </tr>
</table>


## Tech stack & Open-source libraries

- Minimum SDK level 21
- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) and [Flow](https://developer.android.com/kotlin/flow)
- [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google suggested app architecture
- [Material Design 3](https://m3.material.io/) is the latest version of Google’s open-source design system.
- [Navigation Component](https://developer.android.com/guide/navigation) - Single activity multiple fragments approach
- [JetPack](https://developer.android.com/jetpack)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify domain layer data to views.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Dispose of observing data when lifecycle state changes.
    - [Fragment-ktx](https://developer.android.com/kotlin/ktx#fragment) - A set of Kotlin extensions that helps with fragment lifecycle.
    - [View Binding](https://developer.android.com/topic/libraries/view-binding) - Allows you to more easily write code that interacts with views
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
  - Clean Architecture approach.
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) is a dependency injection library for Android
- [Retrofit](https://square.github.io/retrofit/) A type-safe HTTP client for Android and Java
- [Gson](https://github.com/google/gson) Google Gson is of libraries for handling JSON objects 
- [Navigation Component](https://developer.android.com/guide/navigation) - Single activity multiple fragments approach
- [Coil](https://coil-kt.github.io/coil/) - An image loading library for Android backed by Kotlin Coroutines
- [Splash Screen](https://developer.android.com/develop/ui/views/launch/splash-screen) 
- Testing
  - [Mockito](https://site.mockito.org/) A mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API
  - [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver) A scriptable web server for testing HTTP clients
  - [Truth](https://truth.dev/) A library for performing assertions in tests
  - [Turbine](https://github.com/cashapp/turbine) A small testing library for kotlinx.coroutines Flow
    
    
## Architecture

This app uses [***MVVM (Model View View-Model)***](https://developer.android.com/jetpack/docs/guide#recommended-app-arch) architecture

![mvvm](https://user-images.githubusercontent.com/57602386/216581683-3f330617-6e80-485d-a442-c582a6542ec2.jpg)

#### Modules Design:
- Data
  - Api (Api Service)
  - DTO
  - Mapper
  - Reprository (RepositoryImpl)
  - Source (RemoteDataSource, RemoteDataSourceImpl)
- Di
- Domain
  - Model (WeaponUiData)
  - Repository (Repository)
  - UseCase (GetWeaponByIdUseCase, GetWeaponsUseCase)
- Ui
  - Base (BaseRecyclerViewAdapter, BaseViewHolder)
  - Component (ValorantUiComponent)
  - Contract (AbstractTextWatcher)
  - Detail
  - Home
- Utility (Extensions)

## Open API
Valorant Agents uses the [Valorant-api](https://dash.valorant-api.com/) for required data.
Valorant-api provides an extensive API containing data of most in-game items, assets and more!

# License
```xml
Designed and developed by 2022 Hilalkrnz

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
