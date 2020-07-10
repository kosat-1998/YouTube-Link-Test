package com.example.videoplayertest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.item_youtube.view.*

class YouTubeRecycler(var code: ArrayList<String>, var context: Context) :
    RecyclerView.Adapter<YouTubeRecycler.YouTubeViewHolder>() {
    inner class YouTubeViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        fun bind(code: String) {
            var youtubeplaylistener : YouTubePlayer.PlaybackEventListener = object :YouTubePlayer.PlaybackEventListener{
                override fun onSeekTo(p0: Int) {
                    Toast.makeText(context,"Good, video is playing onSeekTo", Toast.LENGTH_LONG).show();
                }

                override fun onBuffering(p0: Boolean) {
                    Toast.makeText(context,"Good, video is playing onBuffering", Toast.LENGTH_LONG).show();
                }

                override fun onPlaying() {
                    Toast.makeText(context,"Good, video is playing ok", Toast.LENGTH_LONG).show();
                }

                override fun onStopped() {
                    Toast.makeText(context,"Good, video is playing onStopped", Toast.LENGTH_LONG).show();
                }

                override fun onPaused() {
                    Toast.makeText(context,"Good, video is playing onPaused", Toast.LENGTH_LONG).show();
                }
            }
            var youtubestateChangeListener : YouTubePlayer.PlayerStateChangeListener = object : YouTubePlayer.PlayerStateChangeListener{
                override fun onAdStarted() {
                    Toast.makeText(context,"Video has onAdStarted!", Toast.LENGTH_LONG).show();
                }

                override fun onLoading() {
                    Toast.makeText(context,"Video has onLoading!", Toast.LENGTH_LONG).show();
                }

                override fun onVideoStarted() {
                    Toast.makeText(context,"Video has started!", Toast.LENGTH_LONG).show();
                }

                override fun onLoaded(p0: String?) {
                    Toast.makeText(context,"Video has onLoaded", Toast.LENGTH_LONG).show();
                }

                override fun onVideoEnded() {
                    Toast.makeText(context,"onVideoEnded!", Toast.LENGTH_LONG).show();
                }

                override fun onError(p0: YouTubePlayer.ErrorReason?) {
                    Toast.makeText(context,"Video has ErrorReason!", Toast.LENGTH_LONG).show();
                }

            }

                itemView.play.setOnClickListener {
                    itemView.item_youtube_view.initialize(R.string.developer_Key.toString(),
                        object : YouTubePlayer.OnInitializedListener {
                            override fun onInitializationSuccess(
                                p0: YouTubePlayer.Provider?,
                                p1: YouTubePlayer?,
                                p2: Boolean
                            ) {
                                Toast.makeText(context, "success", Toast.LENGTH_LONG).show()
                                p1?.setPlayerStateChangeListener(youtubestateChangeListener)
                                p1?.setPlaybackEventListener(youtubeplaylistener)

                                if (!p2) {

                                    p1?.cueVideo(code);

                                }
                            }

                            override fun onInitializationFailure(
                                p0: YouTubePlayer.Provider?,
                                p1: YouTubeInitializationResult?
                            ) {
                                Toast.makeText(context, "fail load", Toast.LENGTH_LONG).show()
                            }
                        })

                }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YouTubeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_youtube, parent, false)
        return YouTubeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return code.size
    }

    override fun onBindViewHolder(holder: YouTubeViewHolder, position: Int) {
        holder.bind(code[position])
    }
}