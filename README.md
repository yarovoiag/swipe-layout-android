# Swipe Layout

Flexible Android Widget

![sample](https://github.com/rambler-digital-solutions/swipe-layout-android/blob/master/rambler.mail.gif?raw=true)

## Download

Download via Gradle:
```groovy
compile 'ru.rambler.android:swipe-layout:1.0.9'
```
or Maven:
```xml
<dependency>
  <groupId>ru.rambler.android</groupId>
  <artifactId>swipe-layout</artifactId>
  <version>1.0.9</version>
  <type>pom</type>
</dependency>
```

## Usage

**Swipe Layout** may contain up to 3 children with **left**, **right** and **center** gravity attributes:

```xml
<ru.rambler.libs.swipe_layout.SwipeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="@dimen/item_height">

    <!--CENTER. app:gravity="center" - is default value -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        ...
    </LinearLayout>

    <!--RIGHT-->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:gravity="right"
        app:bring_to_clamp="150dp"
        app:clamp="self"        
        app:sticky="100dp">

        ...
    </LinearLayout>

    <!--LEFT-->
    <FrameLayout
        android:layout_width="200dp"
        android:layout_height="match_parent"
        app:gravity="left"
        app:bring_to_clamp="100dp"
        app:clamp="self"        
        app:sticky="none">

        ...
    </FrameLayout>
</ru.rambler.libs.swipe_layout.SwipeLayout>
```

[Full list of widget attributes](https://github.com/rambler-digital-solutions/swipe-layout-android/blob/develop/swipe-layout/src/main/res/values/attrs.xml)

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    
        http://www.apache.org/licenses/LICENSE-2.0
