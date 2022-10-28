package com.example.exercise3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment2 : Fragment() {
    private lateinit var listener: OnSubActivityClickListener // ボタンのクリックリスナー

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Activityにリスナーが含まれているかチェック
        if (context is OnSubActivityClickListener) {
            listener = context
        } else {
            throw IllegalArgumentException("Must Implement OnSubActivityClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Viewの取得
        val view = inflater.inflate(R.layout.fragment_2, container, false)
        // ボタンのクリック処理
        view.findViewById<Button>(R.id.button_sub).setOnClickListener {
            listener.onSubActivityClicked()
        }
        // ViewをFragmentに反映
        return view
    }

    /**
     * SubButtonのクリックリスナー
     *
     */
    interface OnSubActivityClickListener {
        fun onSubActivityClicked()
    }
}