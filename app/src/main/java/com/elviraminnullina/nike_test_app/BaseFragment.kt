package com.elviraminnullina.nike_test_app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.elviraminnullina.nike_test_app.ui.common.CustomSpinnerFragment

abstract class BaseFragment : Fragment() {
    /**
     * The Id of the resource file to be inflated in the fragment.
     */
    protected abstract val layoutResourceId: Int

    /**
     * Helper method that overrides onCreateView to automatically inflate the layout provided within layoutResourceId
     */
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResourceId, container, false)
    }

    private fun findSpinnerFragment(): CustomSpinnerFragment? =
        parentFragmentManager.run {
            findFragmentByTag(CustomSpinnerFragment.UNIQUE_TAG) as? CustomSpinnerFragment
        }

    private fun hideKeyboard() {
        activity?.currentFocus?.let {
            val imm =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    /**
     * Function to show spinner fragment
     */
    @Synchronized
    fun showSpinner() {
        val spinnerFragment = findSpinnerFragment()
        if (spinnerFragment != null) return

        parentFragmentManager.run {
            val spinner = CustomSpinnerFragment.newInstance()
            spinner.setTargetFragment(this@BaseFragment, REQUEST_SPINNER)
            spinner.show(this, CustomSpinnerFragment.UNIQUE_TAG)
        }
    }

    /**
     * Function to hide spinner fragment if exist
     */
    @Suppress("unused")
    fun hideSpinner() = findSpinnerFragment()?.dismiss()

    companion object {
        private const val REQUEST_SPINNER = 987
    }

}