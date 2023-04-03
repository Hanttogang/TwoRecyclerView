package teameverywhere.personal.test0403tworecyclerview.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.R
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01

class ViewAdapter01 (private var list01: MutableList<DataClass01>):
    RecyclerView.Adapter<ViewAdapter01.ListItemViewHolder01> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter01.ListItemViewHolder01 {
        val view01 = LayoutInflater.from(parent.context).inflate(R.layout.item_data01_list, parent, false)
        return ListItemViewHolder01(view01)
    }

    override fun onBindViewHolder(holder: ViewAdapter01.ListItemViewHolder01, position: Int) {
        Log.d("ViewAdapter01", "===== ===== ===== ===== onBindViewHolder01 ===== ===== ===== =====")
        holder.bindData01(list01[position], position)
    }

    override fun getItemCount(): Int {
        return list01.count()
    }


    inner class ListItemViewHolder01 (itemView01: View?): RecyclerView.ViewHolder(itemView01!!) {
        var data011Text: TextView = itemView01!!.findViewById(R.id.data01_1Text)
        var data012Text: TextView = itemView01!!.findViewById(R.id.data01_2Text)
        var data013Text: TextView = itemView01!!.findViewById(R.id.data01_3Text)

        fun bindData01(data01: DataClass01, position: Int){
            Log.d("ViewAdapter01", "===== ===== ===== ===== bind ===== ===== ===== =====")
            Log.d("ViewAdapter01", data01.getData01_1() + " " + data01.getData01_2() + " " + data01.getData01_3())

            data011Text.text = data01.getData01_1()
            data012Text.text = data01.getData01_2()
            data013Text.text = data01.getData01_3()
        }
    }
}