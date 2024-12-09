# JxBrowser in a Gradle-based Swing desktop application

This example demonstrates how to configure a Gradle project with JxBrowser to embed a `BrowserView` widget into a Swing desktop application to display web pages.

## Prerequisites

To compile and run this example please make sure you use Java 17 or higher.

## Get license

If you don't have a license key already, please download a free 30-day evaluation license key
by sending a request via the [web form](https://www.teamdev.com/jxbrowser#evaluate).

## Run the Swing application

Use the following command:

```bash
./gradlew run -Djxbrowser.license.key=<your_license_key>
```

It will build and start a Swing desktop application with the `BrowserView` component inside that displays https://html5test.teamdev.com as shown below:

![BrowserView in a Swing desktop app](https://jxbrowser-support.teamdev.com/img/articles/awt-swing-view.png)
