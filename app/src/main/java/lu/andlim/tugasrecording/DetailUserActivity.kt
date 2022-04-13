package lu.andlim.tugasrecording

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_user.*
import lu.andlim.tugasrecording.Model.GetAllUserResponseItem

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
    }
}