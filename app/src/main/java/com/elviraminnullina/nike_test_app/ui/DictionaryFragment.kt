package com.elviraminnullina.nike_test_app.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elviraminnullina.nike_test_app.BaseFragment
import com.elviraminnullina.nike_test_app.MyApplication
import com.elviraminnullina.nike_test_app.R
import com.elviraminnullina.nike_test_app.ui.common.EditText
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

    override val layoutResourceId = R.layout.fragment_dictionary
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MyApplication.getApp(activity).getAppComponent().createMainComponent()
            .injectDictionaryFragment(this)
        recyclerView = view.findViewById(R.id.definition_recycler)
        searchButton = view.findViewById(R.id.search_button)
        //progressBar = findViewById(R.id.progress_bar)
        mLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = mLayoutManager
        adapter = DictionaryAdapter()
        recyclerView.adapter = adapter
        // todo viewLifecycleOwner
        mViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.run { adapter.addList(it.list) }
        })
        mViewModel.term.observe(viewLifecycleOwner, Observer {
            it?.let {
                mViewModel.getDefinition(it)
            }
        })

        term_editText.setText(mViewModel.term.value)
        // term_editText.setTermToVMField()
        searchButton.setOnClickListener {
            mViewModel.setTerm(term_editText.getText())
        }
    }

    private fun EditText.setTermToVMField() =
        object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(editable: Editable?) {
                if (this@setTermToVMField.hasFocus()) {
                    mViewModel.setTerm(editable.toString())
                }
            }
        }
}