package com.example.dialogfragment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dialogfragment.fragments.CustomDialogFragment
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG : String = "MainActivity"
private const val MESSAGE_KEY : String = "messageTextView"

class MainActivity : AppCompatActivity(), CustomDialogFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            messageTextView.text = savedInstanceState.getString(MESSAGE_KEY)
        }

        openDialogButton.setOnClickListener {
            Log.d(TAG, "onClick: opening dialog.")

            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "MyCustomDialog")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(MESSAGE_KEY, messageTextView.text.toString())
    }

    override fun onFragmentInteraction(txt: String) {
        messageTextView.text = txt
    }
}
