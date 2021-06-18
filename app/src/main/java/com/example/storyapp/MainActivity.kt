package com.example.storyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var titles=arrayOf<String>()
    var desc=arrayOf<String>()
    var img=arrayOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle=ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        toggle.isDrawerIndicatorEnabled=true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)
        titles=resources.getStringArray(R.array.storyTitles)
        desc=resources.getStringArray(R.array.storyContents)
        img=resources.getStringArray(R.array.storyImages)

        val adapter=ItemAdapter(titles,desc,img)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        println("clicked")
        drawerLayout.closeDrawer(GravityCompat.START)
        if(item.itemId == R.id.randomStory){
            val randPosition = Random.nextInt(0,titles.size)
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("storyTitle",titles[randPosition])
            intent.putExtra("storyContent",desc[randPosition])
            intent.putExtra("storyImage",img[randPosition])
            startActivity(intent)

        }
        return true
    }
}