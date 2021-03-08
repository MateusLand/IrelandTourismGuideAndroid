package com.land.software.irelandtourismguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import kotlinx.android.synthetic.main.activity_main.*

class PlaceListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create global configuration and initialize ImageLoader with this config
        val config = ImageLoaderConfiguration.Builder(this).build()
        ImageLoader.getInstance().init(config)

        // Hard coded place list
        val placeList = mutableListOf<Place>()
        placeList.add(Place(1, "Dublin Castle", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/The_Dubhlinn_Gardens_Dublin_Castle_01.JPG/480px-The_Dubhlinn_Gardens_Dublin_Castle_01.JPG", "Co. Dublin", ""));
        placeList.add(Place(2, "Trinity College Dublin", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f7/ImeldaCasey_TrinityatNight.jpg/700px-ImeldaCasey_TrinityatNight.jpg", "Co. Dublin", ""));
        placeList.add(Place(3, "Dingle Peninsula", "https://postcardstoseattle.com/wp-content/uploads/2017/09/what-to-see-on-irelands-dingle-peninsula-12-850x567.jpg", "Co. Kerry", ""));
        placeList.add(Place(4, "Cliff of Moher", "https://lh3.googleusercontent.com/proxy/Ascm-0XwN0wS1sRyE08HHamAwJloh4fGIGK3lbHUuV9fJ-9pRM2SsVTvkTtDWKtrTCn8RolTPdR30TzywwnjoG0kuzhIvnHqiUutHFJdK-k", "Co. Galway", ""));

        val adapter = PlaceAdapter(this)
        adapter.setList(placeList)

        placeListRecyclerView.layoutManager = LinearLayoutManager(this)
        placeListRecyclerView.adapter = adapter
    }
}



