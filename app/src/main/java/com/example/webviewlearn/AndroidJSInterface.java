package com.example.webviewlearn;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class AndroidJSInterface {
     @JavascriptInterface
    public String getNameFromAndroid(String msg){
         Log.d("test1", "getNameFromAndroid: msg="+msg);
         return "这是来自android的字符串";
    }
}
