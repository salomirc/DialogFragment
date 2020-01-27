package com.example.dialogfragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogfragment.fragments.CustomDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG : String = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openDialogButton.setOnClickListener {
            Log.d(TAG, "onClick: opening dialog.")

            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "MyCustomDialog")
        }
    }
}
