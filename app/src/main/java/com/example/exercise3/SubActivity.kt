package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // FragmentManagerの取得
        val manager = supportFragmentManager
        // FragmentTransactionの取得
        val transaction = manager.beginTransaction()
        // Fragment3に渡す値
        val bundle = Bundle()
        bundle.putString(KEY, intent.getStringExtra(MainActivity.INTENT_KEY))
        // FragmentにBundleをセット
        val fragment3 = Fragment3()
        fragment3.arguments = bundle
        // コンテナにFragment3を挿入する
        transaction.add(R.id.fragment_container, fragment3)
        transaction.commit()
    }

    companion object {
        const val KEY = "fragment_key"
    }
}