package com.elviraminnullina.nike_test_app.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elviraminnullina.nike_test_app.BaseFragment
import com.elviraminnullina.nike_test_app.MyApplication
import com.elviraminnullina.nike_test_app.R
import javax.inject.Inject

class DictionaryFragment : BaseFragment() {

    @Inject
    lateinit var mViewModel: DictionaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var adapter: DictionaryAdapter

    override val layoutResourceId = R.layout.fragment_dictionary
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyApplication.getApp(activity).getAppComponent().createMainComponent()
            .injectDictionaryFragment(this)
        recyclerView = view.findViewById(R.id.definition_recycler)
        //progressBar = findViewById(R.id.progress_bar)
        mLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = mLayoutManager
        adapter = DictionaryAdapter()
        recyclerView.adapter = adapter
        // todo viewLifecycleOwner
        mViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.run { adapter.addList(it.list) }
        })
        mViewModel.getDefinition("wet")
    }
}