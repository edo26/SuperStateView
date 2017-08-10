# SuperStateView
###### by Sebastian Cipolat

SuperStateView is an Android Library created to make easy the implementation of stateviews like empty states views, error messages,other.


## Usage

Their use is so easy like other view just add in your layout and set some basic values.

Is composed by 3 elements:

| IMAGE         
| ------------- 
| TITLE         
| SUBTITLE

![Imagen ejemplo](https://raw.githubusercontent.com/sebacipolat/SuperStateView/master/images/image1.png)

```xml
<com.cipolat.superstateview.SuperStateView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    app:imageResource="@drawable/cloud_sad"
    app:setTitleText="Woops!"
    app:setSubTitleText="Verify your Internet Connection"
    app:titleStyle="@style/erro_title"
    app:subTitleStyle="@style/erro_sub_title"/>
  ```
   **Image:**
   The image should be a clasic image file, not support Vector Drawable yet.
   use `imageState`
   
  **Text:**
   Set the title and subtitle text content using `setTitleText` and `setTitleText`

  **Modify Appeareance:**

  You could change the aspect of the labels text using custom styles using `titleStyle` and `subTitleStyle`
  Just define in your values/styles.xml your own styles.
  Use the same properties like TexView

  Example:

  ```xml

    <style name="erro_title">
        <item name="android:textColor">@color/violet</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textSize">30sp</item>
    </style>
  ```



  **Custom Fonts:**

  Use your favorites fonts are easy, just create in your `assets` folder a new one called **fonts**
  into Layout use `setTitleFont` and `setSubTitleFont` to assign the font.
   

 ```xml
  <com.cipolat.superstateview.SuperStateView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        app:imageState="@drawable/cloud_sad"
        app:setTitleText="@string/error_message_title"
        app:setSubTitleText="@string/error_message_subtitle"
        app:titleStyle="@style/erro_title"
        app:setTitleFont="ExternalFont.ttf"
        app:setSubTitleFont="ExternalFont.ttf"
        />
  ```

  ## Instalation

  This library is only available at this time only on jCenter
  
  Add to your dependecies

`compile 'com.cipolat.android:superstateview:1.0.3'`

  
**FeedBack**
  Please feel free to report bugs, suggestion,etc. I'll be pending.

[@seba_cipolat](http://twitter.com/seba_cipolat)
## License
    Copyright 2017 sebastian cipolat

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
