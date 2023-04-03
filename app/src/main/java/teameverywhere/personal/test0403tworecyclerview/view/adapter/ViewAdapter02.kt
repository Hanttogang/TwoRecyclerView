package teameverywhere.personal.test0403tworecyclerview.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.R
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02

class ViewAdapter02 (private var list02: MutableList<DataClass02>):
    RecyclerView.Adapter<ViewAdapter02.ListItemViewHolder02> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter02.ListItemViewHolder02{
        val view02 = LayoutInflater.from(parent.context).inflate(R.layout.item_data02_list, parent, false)
        return ListItemViewHolder02(view02)
    }

    override fun onBindViewHolder(holder: ViewAdapter02.ListItemViewHolder02, position: Int) {
        Log.d("ViewAdapter02", "===== ===== ===== ===== onBindViewHolder02 ===== ===== ===== =====")
        holder.bindData02(list02[position], position)
    }

    override fun getItemCount(): Int {
        return list02.count()
    }


    inner class ListItemViewHolder02 (itemView02: View?): RecyclerView.ViewHolder(itemView02!!) {
        var data021Text: TextView = itemView02!!.findViewById(R.id.data02_1Text)
        var data022Text: TextView = itemView02!!.findViewById(R.id.data02_2Text)
        var data023Text: TextView = itemView02!!.findViewById(R.id.data02_3Text)

        fun bindData02(data02: DataClass02, position: Int){
            Log.d("ViewAdapter02", "===== ===== ===== ===== bind ===== ===== ===== =====")
            Log.d("ViewAdapter02", data02.getData02_1() + " " + data02.getData02_2() + " " + data02.getData02_3())

            data021Text.text = data02.getData02_1()
            data022Text.text = data02.getData02_2()
            data023Text.text = data02.getData02_3()

        }
    }

}