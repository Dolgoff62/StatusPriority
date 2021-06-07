package ru.netology.statuspriority

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.statuspriority.R.color
import ru.netology.statuspriority.databinding.ActivityMainBinding
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val plan = LocalDateTime.of(2021, 6, 8, 5, 0)
        
        val result = Utils.determiningPriorityLevelOfNote(plan)

        binding.textView.text = result.toString()

        when(result) {
            StatusPriority.GREEN -> binding.indicator.setImageResource(color.light_green)
            StatusPriority.YELLOW -> binding.indicator.setImageResource(color.yellow)
            StatusPriority.RED -> binding.indicator.setImageResource(color.red)
        }
    }
}