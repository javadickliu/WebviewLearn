package com.example.webviewlearn

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.webkit.*
import kotlinx.android.synthetic.main.activity_main.*
import android.view.KeyEvent.KEYCODE_BACK



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //    mainactivity_webview.loadUrl("http://api.xiaobeibike.com/File/Html/promotion.html")//加载url
        //    mainactivity_webview.loadUrl("file:///android_asset/test.html")//加载本地html资源


        mainactivity_webview.isVerticalScrollBarEnabled=false   //WebView常用方法
        mainactivity_webview.isHorizontalScrollBarEnabled=false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
//        mainactivity_webview.onResume()
//       //判断WebView是否可以向前一个页面
//        mainactivity_webview.canGoBack()//判断WebView是否可以返回上一页
//        mainactivity_webview.goBack()//后退

//        var webSettings = mainactivity_webview.settings//
//        webSettings.cacheMode = WebSettings.LOAD_DEFAULT
//        Log.d("test", getFilesDir().getAbsolutePath() + "/webcache")
//        mainactivity_webview.settings.setAppCachePath(getFilesDir().getAbsolutePath() + "/webcache")
//        mainactivity_webview.settings.setAppCacheEnabled(true)
//        mainactivity_webview.settings.useWideViewPort=true//将图片调整到适合webview的大小
//        mainactivity_webview.settings.loadWithOverviewMode=true

//        webSettings.setSupportZoom(true)//设置缩放相关
//        webSettings.builtInZoomControls=true
//        webSettings.displayZoomControls=false

     //   mainactivity_webview.settings.domStorageEnabled=true
        mainactivity_webview.settings.javaScriptEnabled=true


        mainactivity_webview.webViewClient = object : WebViewClient() {
            //不设置客户端有些地址会自动跳转到系统游览器
//            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
//                return super.shouldInterceptRequest(view, request)
//            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                Log.d("test", "shouldOverrideUrlLoading")

                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d("test", "onPageStarted")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("test", "onPageFinished url="+url)
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                Log.d("test", "onLoadResource url="+url)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                super.onReceivedError(view, request, error)
                Log.d("test", "onReceivedError error="+error.toString())
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
               super.onReceivedSslError(view, handler, error)
                Log.d("test", "onReceivedSslError error="+error.toString())
            }
        }


        mainactivity_webview.webChromeClient=object : WebChromeClient(){
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                Log.d("test1", "onProgressChanged Int="+newProgress)
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                Log.d("test1", "onReceivedTitle title="+title)
            }

            override fun onCloseWindow(window: WebView?) {
                super.onCloseWindow(window)
            }
        }
//        mainactivity_testBtn.setOnClickListener {
//            if (mainactivity_webview.canGoForward()) {
//                Log.d("test", "向前")
//                mainactivity_webview.goForward()//向前 这个向前和向后是什么意思,
//            } else {
//                Log.d("test", "无法向前")
//            }
//        }

    //    mainactivity_webview.loadUrl("http://www.ifeng.com/")//加载url

   //     mainactivity_webview.loadUrl("http://www.ifeng.com")//加载url
    //     mainactivity_webview.loadUrl("http://api.xiaobeibike.com/File/Html/joinIn.html")//加载url
        mainactivity_webview.loadUrl("https://y.gtimg.cn/c/=/music/portal/js/common/map.js,/music/portal/js/common/music/mod.js?r=2602287")//加载url

        object :Handler(){
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
//               mainactivity_webview.destroy()//销毁WebView加载的界面
////                Thread.sleep(4000)
//               mainactivity_webview.onResume()
//                mainactivity_webview.onPause()
            }
        }.sendEmptyMessageDelayed(0,5000)
    }


   override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KEYCODE_BACK && mainactivity_webview.canGoBack()) {
            mainactivity_webview.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}
