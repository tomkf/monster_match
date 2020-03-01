package com.tomkf.monstermatch
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val monsters: List<Monster> =listOf(
        Monster("Snagle", R.drawable.monster1_head, R.drawable.monster1_body,R.drawable.monster1_feet),
        Monster("Rumple", R.drawable.monster2_head, R.drawable.monster2_body,R.drawable.monster2_feet),
        Monster("Wodwo", R.drawable.monster3_head, R.drawable.monster3_body,R.drawable.monster3_feet)
    )
    val iterator = monsters.iterator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shuffleMonsters()

        match_button.setOnClickListener{
            shuffleMonsters()
        }
    }

    private fun shuffleMonsters(){

        var index: Int = 0
        
         val topCheck = monsters.random().head
         monster_head_image_view.setImageResource(topCheck)
        
        val  midCheck = monsters.random().body
        monster_body_image_view.setImageResource(midCheck)

        val  bottomCheck = monsters.random().feet
        monster_feet_image_view.setImageResource(bottomCheck)

        monsters.forEach{
        if (topCheck==monsters[index].head && midCheck==monsters[index].body && bottomCheck==monsters[index].feet){
            name_text.setText(monster[index].name)
        } else {
            text_view_id.setText(" ")
          }
            index += 1
        }
    }
}

data class Monster(val name: String, val head: Int, val body: Int, val feet:Int)
