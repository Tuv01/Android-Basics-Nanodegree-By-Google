 News App

*Created as part of Udacity's Android Basics by Google Nanodegree Program*
____________

Android Basics:  Networking
Discover the power of Web APIs and how to use them in your apps, and learn the basics of networking in Android, including HTTP networking, JSON parsing, and threads.
____________

# PROJECT SPECIFICATION
News App

##Layout


Preference Summary

Settings Activity allows users to see the value of all the preferences right below the preference name, and when the value is changed, the summary updates immediate.

Main Screen

App contains a main screen which displays multiple news stories

List Item Contents

The title of the article and the name of the section that it belongs to are required field.

If available, author name and date published should be included. Please note not all responses will contain these pieces of data, but it is required to include them if they are present.

Images are not required.

Layout Best Practices

The code adheres to all of the following best practices:

Text sizes are defined in sp
Lengths are defined in dp
Padding and margin is used appropriately, such that the views are not crammed up against each other.
Functionality

Settings Activity

Settings Activity is accessed from the Main Activity via a Navigation Drawer or from the toolbar menu.

In accordance with Material Design Guidelines, it should be reached via the "Settings" label. Do not use synonyms such as "Options" or "Preferences."

Errors

The code runs without errors.

API Query

App queries the content.guardianapis.com API to fetch news stories related to the topic chosen by the user, using either the ‘test’ api key or the student’s key.

The query is narrowed down by the preferences selected by the user in the Settings.

Use of Loaders

Networking operations are done using a Loader rather than an AsyncTask.

External Libraries and Packages

The intent of this project is to give you practice writing raw Java code using the necessary classes provided by the Android framework; therefore, the use of external libraries for the core functionality will not be permitted to complete this project.

Code Readability

Readability

Code is easily readable such that a fellow programmer can understand the purpose of the app.

Naming Conventions

All variables, methods, and resource IDs are descriptively named such that another developer reading the code can easily understand their function.

Formatting

The code is properly formatted i.e. there are no unnecessary blank lines; there are no unused variables or methods; there is no commented out code.
The code also has proper indentation when defining variables and methods.

Strings

All Strings are stored in the strings.xml resource file.
____________
<img src="https://github.com/Tuv01/Android-Basics-Nanodegree-By-Google/blob/master/NewsSearch/src/master/Screenshot_1529860906.png" width="256" height="256"> <img src="https://github.com/Tuv01/Android-Basics-Nanodegree-By-Google/blob/master/NewsSearch/src/master/Screenshot_1529860909.png" width="256" height="256">
<img src="https://github.com/Tuv01/Android-Basics-Nanodegree-By-Google/blob/master/NewsSearch/src/master/Screenshot_1529860913.png" width="256" height="256"> <img src="https://github.com/Tuv01/Android-Basics-Nanodegree-By-Google/blob/master/NewsSearch/src/master/Screenshot_1529860920.png" width="256" height="256">
<img src="https://github.com/Tuv01/Android-Basics-Nanodegree-By-Google/blob/master/NewsSearch/src/master/Screenshot_1529860927.png" width="256" height="256">
