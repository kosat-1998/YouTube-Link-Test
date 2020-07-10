package com.example.videoplayertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_webview.view.*

class WebViewAdapter(var codeList: ArrayList<String>) : RecyclerView.Adapter<WebViewAdapter.WebViewHolder>(){
    inner  class  WebViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        fun bind(code: String){
            itemView.youtube_web.settings.javaScriptEnabled = true
            itemView.youtube_web.loadUrl("https://www.youtube.com/embed/$code")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_webview,parent,false)
        return WebViewHolder(view)
    }

    override fun getItemCount(): Int {
        return codeList.size
    }

    override fun onBindViewHolder(holder: WebViewHolder, position: Int) {
        holder.bind(codeList[position])
    }
}