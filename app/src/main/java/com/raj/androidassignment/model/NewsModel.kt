package com.raj.androidassignment.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Model Class for List Item
 */
data class NewsModel(
    val title: String? = null,
    val rows: List<RowsItem?>? = null
)

/**
 * Value serialize if it needed to transfer to another process
 */
data class RowsItem(
    val imageHref: String? = null,
    val description: String? = null,
    val title: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RowsItem> {
        override fun createFromParcel(parcel: Parcel): RowsItem {
            return RowsItem(parcel)
        }

        override fun newArray(size: Int): Array<RowsItem?> {
            return arrayOfNulls(size)
        }
    }
}

