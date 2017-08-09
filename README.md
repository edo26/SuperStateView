# SuperStateView
###### by Sebastian Cipolat

SuperStateView is an Android Library created to make easy the implementation of stateviews like empty states views, error messages,other.


##Usage

Their use is so easy like other view just put you in your layout and set some basic values.
```xml
<com.cipolat.superstateview.SuperStateView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    app:imageResource="@drawable/cloud_sad"
    app:setTitleText="@string/error_message_title"
    app:setSubTitleText="@string/error_message_subtitle"
    app:titleStyle="@style/erro_title"
    app:subTitleStyle="@style/erro_sub_title"/>` 
  ```
