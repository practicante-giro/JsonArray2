package mx.com.jsonarray2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.String.valueOf

data class FilmAdapter(var context:Context,var filmList:List<Film>) : RecyclerView.Adapter<FilmAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.film, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return filmList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Se comportan como textview
        var title: TextView = itemView.findViewById(R.id.title)
        var episode_id: TextView = itemView.findViewById(R.id.episode_id)
        var opening: TextView = itemView.findViewById(R.id.opening_crawl)
        var director: TextView = itemView.findViewById(R.id.director)
        var producer: TextView = itemView.findViewById(R.id.producer)
        var url: TextView = itemView.findViewById(R.id.url)
        var created: TextView = itemView.findViewById(R.id.created)
        var edited: TextView = itemView.findViewById(R.id.edited)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.title.text = filmList[position].title
        holder.episode_id.text = valueOf(filmList[position].episode_id)
        holder.opening.text = filmList[position].opening_crawl
        holder.director.text = filmList[position].director
        holder.producer.text = filmList[position].producer
        holder.url.text = filmList[position].url
        holder.created.text = filmList[position].created
        holder.edited.text = filmList[position].edited
    }


}