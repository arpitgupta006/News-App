package com.arpit.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.arpit.newsapp.responseheadline.ArticlesItem
import com.arpit.newsapp.responseheadline.HeadlineAdapter
import com.arpit.newsapp.responseheadline.TopHeadlineResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val list = arrayListOf<ArticlesItem>()
    val headlineadapter = HeadlineAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headlineRv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,false)
            adapter = headlineadapter
        }

        GlobalScope.launch (Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {Client.api.getHeadline()}
            if (response.isSuccessful){
                response.body()?.let {res ->
                    res.articles?.let { list.addAll(it)
                    }
                    runOnUiThread {
                        headlineadapter.notifyDataSetChanged()
                    }
                }
            }
        }

    }
}

//
//<ImageView
//android:id="@+id/photo"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginEnd="308dp"
//android:layout_marginRight="308dp"
//android:padding="15dp"
//android:src="@mipmap/ic_launcher"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintLeft_toLeftOf="parent"
//app:layout_constraintTop_toTopOf="parent"
//app:layout_constraintVertical_bias="0.0" />