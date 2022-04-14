package lu.andlim.tugasrecording

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_update_user.*
import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.Model.RequestUser
import lu.andlim.tugasrecording.Network.ApiClientt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)


        val getUser = intent.getParcelableExtra<GetAllUserResponseItem>("UpdateUser")
        edit_namauser.setText(getUser?.namauser)
        edit_alamat.setText(getUser?.alamat)
        edit_umur.setText(getUser?.umur)
        edit_image.setText(getUser?.image)
        btn_update.setOnClickListener {
            val id = getUser?.id
            val namauser = edit_namauser.text.toString()
            val alamat = edit_alamat.text.toString()
            val umur = edit_umur.text.toString()
            val image = edit_image.text.toString()
            updateDataUser(id!!.toInt(), namauser, alamat, umur, image)
            finish()
        }
    }

    fun updateDataUser(id: Int, namauser: String, alamat: String, umur: String, image: String){
        ApiClientt.instance.updateDataUser(id, RequestUser(namauser, alamat, umur, image))
            .enqueue(object : Callback<List<GetAllUserResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUserResponseItem>>,
                    response: Response<List<GetAllUserResponseItem>>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(this@UpdateUserActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@UpdateUserActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllUserResponseItem>>, t: Throwable) {
                    Toast.makeText(this@UpdateUserActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }
}