# Image Grid App

The Image Grid App is an Android application that allows users to view images in a scrollable grid fetched from an API. It efficiently loads and displays images in a 3-column square grid format.

## Features
- Display images in a 3-column square grid format.
- Asynchronously load images from an API endpoint.
- Implement caching mechanism for efficient retrieval of images.
- Gracefully handle network errors and image loading failures.
- Dynamically change the limit of images fetched from the API.
- Load more images as the user scrolls through the grid.
- Listen for real-time changes in internet connectivity.

## Technologies Used
- Kotlin
- Android Architecture Components (ViewModel, LiveData)
- RecyclerView
- Retrofit for network requests
- ConnectivityManager for monitoring network connectivity changes
- No third-party library allowed for image loading

## Installation
To run the Image Grid App on your local machine, follow these steps:

1. Clone the repository:
git clone https://github.com/akashydv04/Asignment_Acharya_Prashant.git
2. Open the project in Android Studio.
3. Build and run the project on an emulator or a physical device.
## Usage
Upon launching the app, you will see a grid of images. Scroll through the grid to view more images. The app dynamically loads more images as you scroll. You are supposed to keep your phone connected with Internet.
