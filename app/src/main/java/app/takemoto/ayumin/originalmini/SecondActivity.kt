package app.takemoto.ayumin.originalmini

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<String>


    val realm: Realm=Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)


        adapter=ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1)


        val numberText=intent.getStringExtra("money")
        val titleText=intent.getStringExtra("title")

        editTitleText.setText(titleText)
        editNumberText.setText(numberText)


        reSaveButton.setOnClickListener {

            val text: String=editTitleText.text.toString()
            if (titleText != null) {
                Toast.makeText(this, titleText, Toast.LENGTH_SHORT).show()


            }

            val title:String = editTitleText.text.toString()
            val content:String = editNumberText.text.toString()
            save(title,content)

            adapter.add(title)


        }




        listView.adapter=adapter


        listView.onItemClickListener=
            AdapterView.OnItemClickListener { parent: AdapterView<*>?, view: View?, position: Int, id: Long ->

                val saveDetailPage=Intent(this, DetailActivity::class.java)
                saveDetailPage.putExtra("titleDetail", titleText)
                saveDetailPage.putExtra("numberDetail", numberText)

                startActivity(saveDetailPage)

            }

        listView.onItemLongClickListener=
            AdapterView.OnItemLongClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                val adapter=listView.adapter as ArrayAdapter<String>
                val item=adapter.getItem(position)
                adapter.remove(item)

                false

            }




        culucratorButton.setOnClickListener {
            val toCulucrator=Intent(this, MainActivity::class.java)
            startActivity(toCulucrator)
            finish()
        }

       val memo:Memo? =read()
        if(memo !=null){
            adapter.add(memo.title)
         //   editTitleText.setText(memo.title)
          // editNumberText.setText(memo.content)
        }



    }

      override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun read():Memo?{
        return  realm.where(Memo::class.java).findFirst()
    }

    fun save(title: String,content:String){
        val memo: Memo? =read()

        realm.executeTransaction{
            if(memo !=null){
                memo.title =title
                memo.content = content
            }else{
                val newMemo: Memo = it.createObject(Memo::class.java)
                newMemo.title = title
                newMemo.content = content
            }
        }

       }
        }