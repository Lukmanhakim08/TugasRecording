package lu.andlim.tugasrecording.Model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetAllUserResponseItem(
    @SerializedName("alamat")
    val alamat: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("namauser")
    val namauser: String,
    @SerializedName("umur")
    val umur: String
): Parcelable