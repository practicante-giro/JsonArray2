package mx.com.jsonarray2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter: FilmAdapter?
        var filmList: List<Film>
        var request:Request?=null

       val client = OkHttpClient()




        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val recyclerView:RecyclerView = recyclerview

        recyclerView.setLayoutManager(linearLayoutManager)


        request = request?.newBuilder()
            ?.url("https://swapi.co/api/films/?format=json")
            ?.build()

        client.newCall(request!!).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Toast.makeText(
                    applicationContext, "No se pudo,",
                    Toast.LENGTH_SHORT
                ).show()
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val json = response.body?.string()
                val jsonArray: JsonArray
                //JsonArray jsonArray2;
                val jsonObject = Gson().fromJson<JsonObject>(
                    json, JsonObject::class.java as Type
                )
                jsonArray = jsonObject.getAsJsonArray("results")
                //jsonArray2 = jsonObject.getAsJsonArray("characters");
                val gson = GsonBuilder().create()
                val list = object : TypeToken<List<Film?>?>() {}.type
                filmList = gson.fromJson(jsonArray.toString(), list)
                runOnUiThread {
                    adapter = FilmAdapter(applicationContext,filmList)
                    recyclerView.adapter = adapter
                }
            }
        })



    }
}
