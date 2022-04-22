package kg.geektech.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.kotlin1.Constant.ABU
import kg.geektech.kotlin1.Constant.XR
import kg.geektech.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var registerForActivityResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btn1.setOnClickListener {
                if (etEditText1.text.toString().isEmpty()) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.isEmpty),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    Intent(this@MainActivity, MainActivityTwo::class.java).apply {
                        putExtra(ABU, etEditText1.text.toString())
                        registerForActivityResult.launch(this)

                    }
                }
            }
            registerForActivityResult = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()
            ) { result ->
                etEditText1.setText(result.data?.getStringExtra(XR))
            }
        }
    }
}
