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

        var headCheck: String = ""
        var bodyCheck: String = ""
        var feetCheck: String = ""

        val top:Int=monsters.random().head
        monster_head_image_view.setImageResource(top)
        monster_head_image_view.setTag(top)
        headCheck = top.toString()

        val mid:Int=monsters.random().body
        monster_body_image_view.setImageResource(mid)
        monster_body_image_view.setTag(mid)
        bodyCheck = top.toString()

        val bottom:Int=monsters.random().feet
        monster_feet_image_view.setImageResource(bottom)
        monster_feet_image_view.setTag(bottom)
        feetCheck = top.toString()

        var index: Int = 0

        monsters.forEach() {
            if (monster_head_image_view.getTag().toString() == headCheck &&
                monster_body_image_view.getTag().toString() == bodyCheck &&
                monster_feet_image_view.getTag().toString() == feetCheck
            ) { name_text.setText(headCheck) } else
                index += 1
        }

    }
}
data class Monster(val name: String, val head: Int, val body: Int, val feet:Int)