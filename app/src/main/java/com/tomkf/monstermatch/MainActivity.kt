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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shuffleMonsters()

        match_button.setOnClickListener{
            shuffleMonsters()
        }
    }

    private fun shuffleMonsters(){
        val top:Int=monsters.random().head
        monster_head_image_view.setImageResource(top)
        monster_head_image_view.setTag(top)

        val mid:Int=monsters.random().body
        monster_body_image_view.setImageResource(mid)
        monster_body_image_view.setTag(mid)

        val bottom:Int=monsters.random().feet
        monster_feet_image_view.setImageResource(bottom)
        monster_feet_image_view.setTag(bottom)

        if(monster_head_image_view.getTag().toString() == R.drawable.monster1_head.toString() &&
            monster_body_image_view.getTag().toString() == R.drawable.monster1_body.toString() &&
            monster_feet_image_view.getTag().toString() == R.drawable.monster1_feet.toString())
        {name_text.setText(monsters[0].name)} else
            if(monster_head_image_view.getTag().toString() == R.drawable.monster2_head.toString() &&
                monster_body_image_view.getTag().toString() == R.drawable.monster2_body.toString() &&
                monster_feet_image_view.getTag().toString() == R.drawable.monster2_feet.toString())
            {name_text.setText(monsters[1].name)} else
                if(monster_head_image_view.getTag().toString() == R.drawable.monster3_head.toString() &&
                    monster_body_image_view.getTag().toString() == R.drawable.monster3_body.toString() &&
                    monster_feet_image_view.getTag().toString() == R.drawable.monster3_feet.toString())
                {name_text.setText(monsters[2].name)} else {name_text.setText("")}
    }
}
data class Monster(val name: String, val head: Int, val body: Int, val feet:Int)