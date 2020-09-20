package app.takemoto.ayumin.originalmini

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.backButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class DetailActivity : AppCompatActivity() {


    val realm: Realm=Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        //  val title:String = reTitleTextView.text.toString()
        //  val content:String = reNumberTextView.text.toString()
        //  save(title,content)


        var editTitle=intent.getStringExtra("titleDetail")
        val editNumber=intent.getStringExtra("numberDetail")

        reTitleTextView.setText(editTitle)
        reNumberTextView.setText(editNumber)

        backButton.setOnClickListener {
            val toSecondActivity=Intent(this, SecondActivity::class.java)
            startActivity(toSecondActivity)
            finish()
        }
    }
}


     /*   val memo:Memo? =read()
        if(memo !=null){
           //  reTitleTextView.setText(memo.title)
           //  reNumberTextView.setText(memo.content)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun read():Memo?{
        return  realm.where(Memo::class.java).findFirst()
    }

    fun save(title: String,content:String) {
        val memo: Memo?=read()

        realm.executeTransaction {
            if (memo != null) {
                memo.title=title
                memo.content=content
            } else {
                val newMemo: Memo=it.createObject(Memo::class.java)
                newMemo.title=title
                newMemo.content=content
            }
        }
    }


    }

      */