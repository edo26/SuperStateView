# SuperStateView
###### by Sebastian Cipolat

SuperStateView is an Android Library created to make easy the implementation of stateviews like empty states views, error messages,other.


##Usage

Their use is so easy like other view just add in your layout and set some basic values.

Is composed by 3 elements:

| IMAGE         
| ------------- 
| TITLE         
| SUBTITLE

Aca va la IMAGEN      

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
   use `imageResource`
   
  **Text:**
   Set the title and subtitle text content using `setTitleText` and `setTitleText`

  **Modify Appeareance:**

  You could change the aspect of the label text using custom Styles using `titleStyle` and `subTitleStyle`
  Just define in your values/styles.xml your own styles

  ie:
  
  ```xml

    <style name="erro_title">
        <item name="android:textColor">@color/violet</item>
        <item name="android:textStyle">bold</item>
        <item name="android:textSize">30sp</item>
    </style>
  ```


