package mx.com.jsonarray2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_tabla.*


class Tabla : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabla)

        btnDatImss.setOnClickListener {
            includeImss.visibility = View.VISIBLE
            includeDom.visibility = View.INVISIBLE
            includeDatLab.visibility = View.INVISIBLE
            imageView.visibility = View.INVISIBLE
            btnDatImss.setBackgroundColor(getColor(R.color.colorCelest))
            btnDom.setBackgroundColor(getColor(R.color.GrayLight))
            btnDatLab.setBackgroundColor(getColor(R.color.GrayLight))
            btnDom.setTextColor(getColor(R.color.colorText))
            btnDatLab.setTextColor(getColor(R.color.colorText))
            btnDatImss.setTextColor(getColor(R.color.colorWhite))

        }



        btnDom.setOnClickListener {
            includeDom.visibility = View.VISIBLE
            includeImss.visibility = View.INVISIBLE
            includeDatLab.visibility = View.INVISIBLE
            imageView.visibility = View.INVISIBLE
            btnDom.setBackgroundColor(getColor(R.color.colorCelest))
            btnDatImss.setBackgroundColor(getColor(R.color.GrayLight))
            btnDatLab.setBackgroundColor(getColor(R.color.GrayLight))
            btnDatImss.setTextColor(getColor(R.color.colorText))
            btnDatLab.setTextColor(getColor(R.color.colorText))
            btnDom.setTextColor(getColor(R.color.colorWhite))

        }

        btnDatLab.setOnClickListener {
            includeDatLab.visibility = View.VISIBLE
            imageView.visibility = View.VISIBLE
            includeDom.visibility = View.INVISIBLE
            includeImss.visibility = View.INVISIBLE
            btnDatLab.setBackgroundColor(getColor(R.color.colorCelest))
            btnDatImss.setBackgroundColor(getColor(R.color.GrayLight))
            btnDom.setBackgroundColor(getColor(R.color.GrayLight))
            btnDom.setTextColor(getColor(R.color.colorText))
            btnDatImss.setTextColor(getColor(R.color.colorText))
            btnDatLab.setTextColor(getColor(R.color.colorWhite))


        }
    }
}
