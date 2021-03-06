package com.example.dialogfragment.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import androidx.fragment.app.DialogFragment
import com.example.dialogfragment.R
import kotlinx.android.synthetic.main.fragment_custom_dialog.*

private const val TAG : String = "CustomDialogFragment"

class CustomDialogFragment : DialogFragment() {
    private lateinit var fgmView: View
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fgmView = inflater.inflate(R.layout.fragment_custom_dialog, container, false)
        return fgmView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            dialog?.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
        else {
            dialog?.window?.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        }

        cancelButton.setOnClickListener {
            Log.d(TAG, "onClick: closing dialog")
            dialog!!.dismiss()
        }

        okButton.setOnClickListener {
            val inputTxt = inputEditText.text.toString()
            if (inputTxt != "")
            {
                listener?.onFragmentInteraction(inputTxt)
            }

            dialog!!.dismiss()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(txt: String)
    }

}
