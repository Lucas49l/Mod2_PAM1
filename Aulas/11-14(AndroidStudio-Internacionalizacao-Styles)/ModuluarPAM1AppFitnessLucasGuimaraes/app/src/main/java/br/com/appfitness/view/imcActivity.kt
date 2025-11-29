package br.com.appfitness.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.appfitness.R

class imcActivity : AppCompatActivity() {
    private lateinit var edt_weight: EditText
    private lateinit var edt_height: EditText
    private lateinit var btn_calcular: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc)

        initComponents()

        btn_calcular.setOnClickListener {
            if (!validate()){
                Toast.makeText(this, "Os campos devem ser preenchidos e com valores diferente de 0", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun validate(): Boolean{
        return (edt_weight.text.toString().isNotEmpty()
                && edt_height.text.toString().isNotEmpty()
                && !edt_weight.text.toString().startsWith("0")
                && !edt_height.text.toString().startsWith("0"))
    }

    private fun initComponents() {
        edt_height   = findViewById(R.id.edt_height)
        edt_weight   = findViewById(R.id.edt_weight)
        btn_calcular = findViewById(R.id.btn_calcular)
    }
}