package vcmsa.ci.fooddiaries

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val txtResults = findViewById<TextView>(R.id.txtResults)

        btnSubmit.setOnClickListener {
            val mealTime = timeInput.text.toString().trim().lowercase()
            var suggestion = "Error : Enter a valid meal time"

            if (mealTime =="morning"){
                suggestion = "pancakes or omelet"
            }else if (mealTime == "mid-morning snack"){
                suggestion = "yogurt or nuts"
            }else if (mealTime =="lunch"){
                suggestion = "sandwich or salad"
            }else if(mealTime =="afternoonSnack"){
                suggestion = "smoothie or crackers"
            }else if (mealTime =="Dinner"){
                suggestion =="pasta or grilled chicken"
            }else if (mealTime == "dessert"){
                suggestion = "Herbal tea or dark chocolate"
            }
            txtResults.text = suggestion


        }
        btnClear.setOnClickListener {
            timeInput.text.clear()
            txtResults.text = ""
        }










        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}