package lu.andlim.tugasrecording

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_user.*
import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.Network.ApiClientt
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        val detailUser = intent.getParcelableExtra<GetAllUserResponseItem>("DetailUser")
        detail_user.text = detailUser?.namauser
        detail_alamat.text = detailUser?.alamat
        detail_umur.text = detailUser?.umur

        Glide.with(applicationContext)
            .load(detailUser?.image)
            .into(detail_img)

        tombol_hapus.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("HAPUS DATA")
                .setMessage("Yakin hapus data ?")
                .setPositiveButton("Ya"){ dialogInterface: DialogInterface, i: Int ->
                    deleteDataUser(detailUser?.id!!.toInt())
                    finish()
                }
                .setNegativeButton("Tidak"){ dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.dismiss()
                }
                .show()
        }

        tombol_update.setOnClickListener {
            val edit = Intent(this, UpdateUserActivity::class.java)
            edit.putExtra("UpdateUser", detailUser)
            startActivity(edit)
        }
    }

    fun deleteDataUser(id : Int){
        ApiClientt.instance.deleteDataUser(id)
            .enqueue(object : Callback<Int>{
                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    if (response.isSuccessful){
                        Toast.makeText(this@DetailUserActivity, "SUCCESS", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@DetailUserActivity, "Failed", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<Int>, t: Throwable) {
                    Toast.makeText(this@DetailUserActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}