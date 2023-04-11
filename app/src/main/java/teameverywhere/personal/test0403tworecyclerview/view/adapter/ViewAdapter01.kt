package teameverywhere.personal.test0403tworecyclerview.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.R
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01

class ViewAdapter01 (val list01: MutableList<DataClass01>):
    RecyclerView.Adapter<ViewAdapter01.Holder01> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter01.Holder01 {
        val view01 = LayoutInflater.from(parent.context).inflate(R.layout.item_data01_list, parent, false)
        return Holder01(view01)
    }

    override fun getItemCount(): Int {
        return list01.size
        //count() -> size로 변경
    }

    override fun onBindViewHolder(holder: ViewAdapter01.Holder01, position: Int) {
        Log.d("ViewAdapter01", "===== ===== ===== ===== onBindViewHolder01 ===== ===== ===== =====")
        holder.bindData01(list01[position])

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener: OnItemClickListener

    @Suppress("DEPRECATION")
    inner class Holder01(itemView: View): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val pos = adapterPosition
                if (pos != RecyclerView.NO_POSITION && itemClickListener != null) {
                    itemClickListener.onClick(itemView, pos)
                }
            }
        }

        val data011Text: TextView = itemView.findViewById(R.id.data01_1Text)
        val data012Text: TextView = itemView.findViewById(R.id.data01_2Text)
        val data013Text: TextView = itemView.findViewById(R.id.data01_3Text)
        fun bindData01(data01: DataClass01) {
            Log.d("ViewAdapter01", "===== ===== ===== ===== bind ===== ===== ===== =====")
            Log.d(
                "ViewAdapter01",
                data01.getData01_1() + " " + data01.getData01_2() + " " + data01.getData01_3()
            )
            data011Text.text = data01.getData01_1()
            data012Text.text = data01.getData01_2()
            data013Text.text = data01.getData01_3()
        }
    }
}
