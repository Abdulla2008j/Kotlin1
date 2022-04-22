package kg.geektech.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kg.geektech.kotlin1.Constant.ABU
import kg.geektech.kotlin1.Constant.XR
import kg.geektech.kotlin1.databinding.ActivityMainTwoBinding

class MainActivityTwo : AppCompatActivity() {
    private lateinit var binding: ActivityMainTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            etEditText2.setText(intent.getStringExtra(ABU))

            btn2.setOnClickListener{
                setResult(
                    RESULT_OK, Intent().putExtra(
                        XR, etEditText2.text.toString()
                    )
                )
                finish()
            }
        }
    }
}