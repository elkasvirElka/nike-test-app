package com.elviraminnullina.nike_test_app.ui.common

import android.content.Context
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.view.View
import androidx.annotation.StringRes
import com.elviraminnullina.nike_test_app.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class EditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TextInputLayout(context, attrs, defStyleAttr) {

    private val editText: TextInputEditText
    private val editTextLayout: TextInputLayout
    private val data: FieldData

    init {
        View.inflate(context, R.layout.view_edit_field, this)
        editText = findViewById(R.id.edit_text)
        editTextLayout = findViewById(R.id.edit_layout)
        context.theme.obtainStyledAttributes(attrs, R.styleable.EditField, 0, 0)
            .apply {
                data = FieldData(
                    text = getString(R.styleable.EditField_android_text),
                    hint = getString(R.styleable.EditField_android_hint),
                    isEnabled =
                    getBoolean(R.styleable.EditField_android_enabled, true),
                    inputType = getInt(
                        R.styleable.EditField_android_inputType,
                        InputType.TYPE_CLASS_TEXT
                    )
                )
            }

        data.apply {
            if (!isEnabled) {
                editTextLayout.isEnabled = false
            }

            editTextLayout.hint = hint
            editText.setText(text)
            editText.inputType = inputType

        }
    }

    fun setErrorField(@StringRes textInputId: Int) {
        editTextLayout.apply {
            error = context.resources.getString(textInputId)
            isErrorEnabled = true
        }
    }

    fun setEnabledField() {
        editTextLayout.apply {
            error = null
            isErrorEnabled = false
        }
    }

    fun setInputType(inputType: Int) {
        editText.inputType = inputType
    }

    fun setText(value: String?) {
        data.text = value
        editText.setText(value)
    }

    fun getText() = editText.text.toString()

    fun addTextChangedListener(textWatcher: TextWatcher) {
        editText.addTextChangedListener(textWatcher)
    }

    fun setMaxLength(length: Int) {
        editText.filters += InputFilter.LengthFilter(length)
        editText.keyListener = DigitsKeyListener.getInstance("0123456789/")
    }


    fun setInputHint(hintText: CharSequence?) {
        editText.hint = hintText
    }

    fun setOnFocusChangeListenerDate(focusChangeListener: OnFocusChangeListener) {
        editText.onFocusChangeListener = focusChangeListener
    }

    fun changeKeyBoardType(keyBoardInputType: Int) {
        editText.inputType = keyBoardInputType
    }


    fun setSelection(position: Int) {
        editText.setSelection(position)
    }

    data class FieldData(
        var text: String?,
        var hint: String?,
        var isEnabled: Boolean,
        var inputType: Int
    )
}
