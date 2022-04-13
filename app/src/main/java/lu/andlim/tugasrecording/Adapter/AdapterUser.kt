package lu.andlim.tugasrecording.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_user.view.*
import lu.andlim.tugasrecording.Model.GetAllUserResponseItem
import lu.andlim.tugasrecording.R

data class AdapterUser(private var datauser : List<GetAllUserResponseItem>, private var onclik : (GetAllUserResponseItem)->Unit) : RecyclerView.Adapter<AdapterUser.ViewHolder>(){

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val tampilkan = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(tampilkan)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.text_namauser.text = datauser[position].namauser
        holder.itemView.text_alamat.text = datauser[position].alamat
        holder.itemView.text_umur.text = datauser[position].umur

        Glide.with(holder.itemView.context)
            .load(datauser[position].image)
            .into(holder.itemView.img_view)

        holder.itemView.onclick_user.setOnClickListener {
            onclik(datauser[position])
        }
    }

    override fun getItemCount(): Int {
        return datauser.size
    }

}
