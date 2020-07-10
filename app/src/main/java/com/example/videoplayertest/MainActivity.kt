package com.example.videoplayertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {
    private lateinit var webViewAdapter: WebViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var codeList : ArrayList<String> = ArrayList()
        codeList.add("mDjz9n-rRAY")
        codeList.add("r0m1g-JZIfw")
        codeList.add("LsNK35io4b4")
        codeList.add("J43zOCT0Wy0")
        codeList.add("7yHWd2oEenk")
        codeList.add("iF6jzPLHLMM")
        codeList.add("JU_tQXdAdzE")

     //   youTubeRecycler = YouTubeRecycler(codeList,this)
        webViewAdapter = WebViewAdapter(codeList)
        recycler_youtube.adapter = webViewAdapter

       // var youtubePlayer : YouTubePlayerView = findViewById(R.id.yt_pv)
     //   youtubePlayer.initialize(R.string.developer_Key.toString(), this)
//        youtubePlayer.initialize(R.string.developer_Key.toString(),object : YouTubePlayer.OnInitializedListener{
//            override fun onInitializationSuccess(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubePlayer?,
//                p2: Boolean
//            ) {
//                showShortToast("Youtube Api Initialization Success")
//                if (!p2) {
//                    p1?.loadVideo("mDjz9n-rRAY");
//                }
//            }
//
//            override fun onInitializationFailure(
//                p0: YouTubePlayer.Provider?,
//                p1: YouTubeInitializationResult?
//            ) {
//                showShortToast("Youtube Api Initialization Failure")
//            }
//
//        })

    }

//    override fun onInitializationSuccess(
//        p0: YouTubePlayer.Provider?,
//        p1: YouTubePlayer?,
//        p2: Boolean
//    ) {
//        showShortToast("Youtube Api Initialization Success")
//        if (!p2) {
//            p1?.cueVideo("mDjz9n-rRAY");
//        }
//    }
//
//    override fun onInitializationFailure(
//        p0: YouTubePlayer.Provider?,
//        p1: YouTubeInitializationResult?
//    ) {
//        showShortToast("Youtube Api Initialization Failure")
//    }

    fun showShortToast(s: String){
        Toast.makeText(applicationContext,s,Toast.LENGTH_LONG).show()
    }
}
