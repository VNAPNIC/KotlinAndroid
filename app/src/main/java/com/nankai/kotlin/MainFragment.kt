package com.nankai.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

/**
 * Created by vnapn on 12/13/2017.
 */
class MainFragment : Fragment() {

    @Inject
    lateinit var dataBean: DataBean

    fun newInstance(): MainFragment{
        val fragment = MainFragment()
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View = LayoutInflater.from(context).inflate(R.layout.fragment_main, null)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppController.graph.inject(this)

    }

    override fun onStart() {
        super.onStart()
        Log.e("Fragment", "Fragment --> " + dataBean.address)
    }
}