package com.example.exercise3

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class Fragment1 : Fragment() {
    private lateinit var listener: OnToastClickListener // ボタンのクリックリスナー

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Activityにリスナーが含まれているかチェック
        if (context is OnToastClickListener) {
            listener = context
        } else {
            throw IllegalArgumentException("Must Implement OnToastClickListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 表示するLayoutのViewを取得
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        // ボタンクリック処理
        view.findViewById<Button>(R.id.button_toast).setOnClickListener {
            listener.onToastClicked()
        }

        // Fragmentへのレイアウトの反映
        return view
    }

    interface OnToastClickListener {
        fun onToastClicked()
    }
}