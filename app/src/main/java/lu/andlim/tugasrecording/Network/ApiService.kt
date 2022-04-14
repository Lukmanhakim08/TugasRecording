package lu.andlim.tugasrecording.Network

import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.Model.PostDataUser
import lu.andlim.tugasrecording.Model.RequestUser
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("user")
    fun getAllUser() : Call<List<GetAllUserResponseItem>>

    @POST("user")
    fun addDataUser(@Body req : RequestUser) : Call<PostDataUser>

    @DELETE("user/{id}")
    fun deleteDataUser(@Path ("id") id : Int) : Call<Int>

    @PUT("user/{id}")
    fun updateDataUser(
        @Path("id") id: Int,
        @Body reques: RequestUser
    )
    : Call<List<GetAllUserResponseItem>>
}