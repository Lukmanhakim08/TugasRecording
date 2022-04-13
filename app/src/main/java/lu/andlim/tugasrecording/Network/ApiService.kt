package lu.andlim.tugasrecording.Network

import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.Model.PostDataUser
import lu.andlim.tugasrecording.Model.RequestUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("user")
    fun getAllUser() : Call<List<GetAllUserResponseItem>>

    @POST("user")
    fun addDataUser(@Body req : RequestUser) : Call<PostDataUser>
}