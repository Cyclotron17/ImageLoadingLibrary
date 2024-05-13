package com.example.nexusreality;

import ImageAdapter
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nexusreality.R
import com.example.nexusreality.models.Thumbnail
import com.example.nexusreality.viewmodel.MediaCoverageViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter
    private lateinit var viewModel: MediaCoverageViewModel
//    private lateinit var imageScrollListener: ImageScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        adapter = ImageAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(MediaCoverageViewModel::class.java)
        viewModel.mediaCoverages.observe(this, Observer { mediaCoverages ->
            val imageUrls = mediaCoverages.map { constructImageUrl(it.thumbnail) }
            adapter.setImageUrls(imageUrls)
        })

        viewModel.fetchMediaCoverages()

//        imageScrollListener = ImageScrollListener(adapter)
//        recyclerView.addOnScrollListener(imageScrollListener)
    }

    private fun constructImageUrl(thumbnail: Thumbnail): String {

        return "${thumbnail.domain}/${thumbnail.basePath}/0/${thumbnail.key}"

 }
}
