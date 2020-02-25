package com.elviraminnullina.nike_test_app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DefinitionResponse(
    val list: ArrayList<DefinitionModel>
) : Parcelable