package command.ceiba.com.co.dojocommandpattern

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity() {

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var textViewRecordId: TextView
    private var recordId : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        getExtras()
        setupViews()
    }

    private fun getExtras() {
        recordId = intent.getStringExtra("recordId")
    }

    private fun setupViews() {
        floatingActionButton = findViewById(R.id.fab)
        textViewRecordId = findViewById(R.id.record_id)

        textViewRecordId.text = recordId
        floatingActionButton.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}