package lu.andlim.tugasrecording

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_user.*
import lu.andlim.tugasrecording.Model.PostDataUser
import lu.andlim.tugasrecording.Model.RequestUser
import lu.andlim.tugasrecording.Network.ApiClientt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        btn_save.setOnClickListener {
            val namauser = edt_namauser.text.toString()
            val alamat = edt_alamat.text.toString()
            val umur = edt_umur.text.toString()
            val image = edt_image.text.toString()
            postDataUser(namauser, alamat, umur, image)
            finish()
        }
    }

    fun postDataUser(namauser: String, alamat: String, umur: String, image: String){
        ApiClientt.instance.addDataUser(RequestUser(namauser, alamat, umur, image))
            .enqueue(object : Callback<PostDataUser>{
                override fun onResponse(
                    call: Call<PostDataUser>,
                    response: Response<PostDataUser>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@AddUserActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@AddUserActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<PostDataUser>, t: Throwable) {
                    Toast.makeText(this@AddUserActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}