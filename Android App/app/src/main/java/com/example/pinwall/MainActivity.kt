package com.example.pinwall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import com.android.volley.toolbox.Volley
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) { //beginning of the activity

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pinList = arrayListOf(
            Post(R.drawable.men, "Daeyoung", "Hello World!"),
            Post(R.drawable.women, "Yang Kyung", "你好，世界!"),
            Post(R.drawable.men, "Ivo Maag", "Hallo Welt"),
            Post(R.drawable.men, "Eunwoo", "안녕 세계!"),
                Post(R.drawable.men, "Daeyoung", "Hello World!"),
                Post(R.drawable.women, "Yang Kyung", "你好，世界!"),
                Post(R.drawable.men, "Ivo Maag", "Hallo Welt"),
                Post(R.drawable.men, "Eunwoo", "안녕 세계!")

        )


        rv_postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_postList.setHasFixedSize(true)

        rv_postList.adapter = ListAdapater(pinList)
    }


}




        //pinList
/*        val queue = Volley.newRequestQueue(this)

        val url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=AAPL&apikey=H9E2PQEDM8Y26C7F"

        val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                { response ->
                    try {
                        val stocks = response.getJSONArray("Global Quote")
                        for (i in 0 until stocks.length()) {
                            val stockData = stocks.getJSONObject(i)
                            val symbol = stockData.getString("01. symbol")
                            val value = stockData.getString("05. price")
                            items.add(Post(symbol, value))
                        }

                        //Todo: connect adapter with view

                        //pinList.adapter = ListAdapater(items.toArray(array))

                    } catch (e: JSONException) {}
                }, null
        )
    }
}*/
