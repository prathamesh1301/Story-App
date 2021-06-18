package com.example.storyapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(val titles: Array<String>,val desc: Array<String>,val images:Array<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardTitle:TextView=itemView.findViewById(R.id.cardViewTitle)
        val cardDesc:TextView=itemView.findViewById(R.id.cardViewDesc)
        val cardImg:ImageView=itemView.findViewById(R.id.cardViewImage)
        val view = itemView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cardDesc.setText(desc[position])
        holder.cardTitle.setText(titles[position])
        Picasso.get().load(images[position]).into(holder.cardImg)
        holder.view.setOnClickListener{
//            Toast.makeText(holder.view.context,"Item Number -> " + position,Toast.LENGTH_SHORT).show()
            val intent = Intent(it.context,DetailsActivity::class.java)
            intent.putExtra("storyTitle",titles[position])
            intent.putExtra("storyContent",desc[position])
            intent.putExtra("storyImage",images[position])
            holder.view.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return titles.size

    }
}




