package com.example.exercise3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class Fragment3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_3, container, false)

        // Bundleの取り出し
        val fromSubActivity = arguments?.getString(SubActivity.KEY).orEmpty()
        view.findViewById<TextView>(R.id.text_content).text = fromSubActivity

        // ボタンのクリック処理
        view.findViewById<Button>(R.id.button_fragment4).setOnClickListener {
            // FragmentManagerの取得
            val manager = activity?.supportFragmentManager
            manager?.let {
                val transaction = it.beginTransaction()
                transaction.replace(R.id.fragment_container, Fragment4())
                // バックスタック制御
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }

        // Inflate the layout for this fragment
        return view
    }
}