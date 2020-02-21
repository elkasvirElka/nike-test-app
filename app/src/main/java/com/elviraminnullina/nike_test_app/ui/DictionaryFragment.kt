package com.elviraminnullina.nike_test_app.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elviraminnullina.nike_test_app.BaseFragment
import com.elviraminnullina.nike_test_app.MyApplication
import com.elviraminnullina.nike_test_app.R
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.fragment_dictionary.*
import javax.inject.Inject

class DictionaryFragment : BaseFragment() {

    @Inject
    lateinit var mViewModel: DictionaryViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var mLayoutManager: LinearLayoutManager
    private lateinit var adapter: DictionaryAdapter
    private lateinit var searchButton: MaterialButton
    private lateinit var thumbUp: MaterialButton
    private lateinit var thumbDown: MaterialButton

    override val layoutResourceId = R.layout.fragment_dictionary
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyApplication.getApp(activity).getAppComponent().createMainComponent()
            .injectDictionaryFragment(this)
        recyclerView = view.findViewById(R.id.definition_recycler)
        searchButton = view.findViewById(R.id.search_button)
        thumbUp = view.findViewById(R.id.thumb_up)
        thumbDown = view.findViewById(R.id.thumb_down)
        //progressBar = findViewById(R.id.progress_bar)
        mLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = mLayoutManager
        adapter = DictionaryAdapter(mViewModel.response.value?.list ?: ArrayList())
        recyclerView.adapter = adapter
        // todo viewLifecycleOwner
        mViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.run { adapter.setList(it.list) }
        })
        mViewModel.term.observe(viewLifecycleOwner, Observer {
            it?.let {
                mViewModel.getDefinition(it)
            }
        })
        mViewModel.showSpinner.observe(viewLifecycleOwner, Observer {
            if (it == true) {
                showSpinner()
            } else {
                hideSpinner()
            }
        })

        term_editText.setText(mViewModel.term.value)
        searchButton.setOnClickListener {
            mViewModel.setTerm(term_editText.getText())
        }

        thumbUp.setOnClickListener {
            adapter.sortBy(true)
        }
        thumbDown.setOnClickListener {
            adapter.sortBy(false)
        }
    }
}