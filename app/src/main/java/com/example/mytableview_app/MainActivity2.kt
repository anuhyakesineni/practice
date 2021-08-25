package com.example.mytableview_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var listItems = arrayOf<String>("Laptop","Bag","Mobile","C","CPP","JS","Java","Python","Android","PHP")

        var adapterListItems = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems)
        listView.adapter = adapterListItems


        search.setOnQueryTextListener(object:SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (listItems.contains(query)) {
                    adapterListItems.filter.filter(query)

                } else
                    Toast.makeText(this@MainActivity2,"submitted",Toast.LENGTH_SHORT).show()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                var s:String? = newText
                if(s?.isEmpty() == true)
                    return false

                else{
                listView.visibility = View.VISIBLE
                adapterListItems.filter.filter(newText)
            }
                return false
        }
        })
    }
}
