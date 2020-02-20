package com.elviraminnullina.nike_test_app.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.elviraminnullina.nike_test_app.BaseFragment
import com.elviraminnullina.nike_test_app.R
import javax.inject.Inject

class DictionaryFragment : BaseFragment() {

    @Inject
    lateinit var mViewModel: DictionaryViewModel

    override val layoutResourceId = R.layout.fragment_dictionary
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // todo viewLifecycleOwner
        mViewModel.response.observe(viewLifecycleOwner, Observer {
            Log.e("YEAH", resources.toString())
        })
        mViewModel.getDefinition("wet")
    }
}