package lu.andlim.tugasrecording

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import lu.andlim.tugasrecording.Adapter.AdapterUser
import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.Network.ApiClientt
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDataUser()

        fab_add.setOnClickListener {
            val pindah = Intent(this, AddUserActivity::class.java)
            startActivity(pindah)
        }
    }

    fun getDataUser(){
        ApiClientt.instance.getAllUser()
            .enqueue(object : retrofit2.Callback<List<GetAllUserResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllUserResponseItem>>,
                    response: Response<List<GetAllUserResponseItem>>
                ) {
                    if (response.isSuccessful){
                        val datauser = response.body()
                        val adapterUser = AdapterUser(datauser!!){
                            val pindah = Intent(this@MainActivity, DetailUserActivity::class.java)
                            pindah.putExtra("DetailUser",it)
                            startActivity(pindah)
                        }
                        val tampil = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
                        rv_user.layoutManager = tampil
                        rv_user.adapter = adapterUser
                    }else{
                        Toast.makeText(this@MainActivity, response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllUserResponseItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun onResume() {
        super.onResume()
        getDataUser()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}