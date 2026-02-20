# MiniEcommerce Android App

A simple Android e-commerce application demonstrating how to build a product catalog and a shopping cart feature. The app fetches product data from a remote API and allows users to browse products, view details, and manage a shopping cart locally on the device.



##  Features

*   **Product Catalog**: Fetches and displays a list of products from a remote API.
*   **Product Details**: Shows a dedicated screen with more information about a selected product.
*   **Shopping Cart**:
    *   Add products to a local cart.
    *   View all items in the cart.
    *   The cart persists locally using a SQLite database.
*   **Image Loading**: Loads and caches product images efficiently from URLs.

##  Architecture

The application is built following the **Model-View-Presenter (MVP)** design pattern, promoting a clean separation of concerns:
*   **Model**: Represents the data layer (Product data class, API service, `DBHelper` for the database).
*   **View**: Represents the UI layer (Activities like `MainActivity`, `CartActivity`, and their layouts).
*   **Presenter**: Acts as the bridge between the View and the Model, handling the business logic.

##  Technologies & Libraries Used

This project leverages a variety of modern Android development tools and libraries:

*   **[Kotlin](https://kotlinlang.org/)**: The official programming language for Android development.
*   **[AndroidX Libraries](https://developer.android.com/jetpack/androidx)**:
    *   `AppCompat`: For backward compatibility.
    *   `ConstraintLayout`: For building flexible and responsive layouts.
    *   `RecyclerView`: For displaying large lists of data efficiently.
*   **[Material Components for Android](https://material.io/develop/android)**: For implementing Material Design UI components.
*   **[Retrofit 2](https://square.github.io/retrofit/)**: A type-safe HTTP client to fetch data from the remote API.
*   **[Gson](https://github.com/google/gson)**: A library for converting JSON data from the API into Kotlin objects.
*   **[Glide](https://github.com/bumptech/glide)**: A powerful image loading and caching library.
*   **[SQLite](https://developer.android.com/training/data-storage/sqlite)**: Used for creating a local database to store the shopping cart items.

##  How to Build

1.  **Clone the repository**:
    ```bash
    git clone https://github.com/widedbg/MiniEcommerce.git
    ```
2.  **Open in Android Studio**:
    Open the cloned project using Android Studio.
3.  **Sync Dependencies**:
    Wait for Gradle to download and sync all the project dependencies.
4.  **Run the App**:
    Build and run the application on an Android emulator or a physical device.

---

