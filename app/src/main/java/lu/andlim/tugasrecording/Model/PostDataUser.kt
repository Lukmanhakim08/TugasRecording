package lu.andlim.tugasrecording.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostDataUser(

    @SerializedName("id")
    val id: String,
    @SerializedName("namauser")
    val namauser: String,
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("umur")
    val umur: String,
    @SerializedName("image")
    val image: String

): Parcelable