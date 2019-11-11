package com.example.projetofinalcarros.activities

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.projetofinalcarros.R
import com.example.projetofinalcarros.extensions.setupToolbar

class SiteLivroActivity : BaseActivity() {

    private val URL_SOBRE = "http://www.livroandroid.com.br/sobre.htm"
    var webview : WebView? = null
    var progress: ProgressBar? = null
    var swipToRefresh: SwipeRefreshLayout?=null

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_site_livro)

        //toolbar
        val actionBar = setupToolbar(R.id.toolbar)
        actionBar.setDisplayHomeAsUpEnabled(true)

        //Views
        webview = findViewById(R.id.webview)
        progress = findViewById(R.id.progress)

        //carrega pagina
        setWebViewClient(webview)
        webview?.loadUrl(URL_SOBRE)
        //Swipe to Refresh
        swipToRefresh = findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh)
        swipToRefresh?.setOnRefreshListener {

            webview?.reload()
        }
        //cores animação
        swipToRefresh?.setColorSchemeResources(
            R.color.refresh_progress_1,
            R.color.refresh_progress_2,
            R.color.refresh_progress_3
        )
    }

    private fun setWebViewClient(webView: WebView?){
        webView?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView, url: String, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                //liga o progress
                progress?.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progress?.visibility = View.INVISIBLE
                //termina animaçao do swipe to refresh
                swipToRefresh?.isRefreshing = false
            }

            override fun shouldOverrideUrlLoading(view: WebView?,
                                                  request: WebResourceRequest?): Boolean {
               //val url = request?.url.toString()
               // if(url.endsWith("sobre.htm")){
                    //mostra dialog
                   //CRIARRRRR AboutDialog.showAbout(supportFragmentManager)
                }

                //return true
            }

        }
    }
}
