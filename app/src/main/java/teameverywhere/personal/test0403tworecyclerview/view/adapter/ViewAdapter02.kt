package teameverywhere.personal.test0403tworecyclerview.view.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.R
import teameverywhere.personal.test0403tworecyclerview.controller.ItemTouchHelperCallback
import teameverywhere.personal.test0403tworecyclerview.databinding.FragmentABinding
import teameverywhere.personal.test0403tworecyclerview.databinding.FragmentMainBinding
import teameverywhere.personal.test0403tworecyclerview.databinding.ItemData02ListBinding
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02
import java.util.*

class ViewAdapter02 (val list02: MutableList<DataClass02>):
    RecyclerView.Adapter<ViewAdapter02.ListItemViewHolder02>(),
        ItemTouchHelperCallback.OnItemMoveListener {

    private lateinit var dragListener: OnStartDragListener

    interface OnStartDragListener {
        fun onStartDrag(viewHolder: RecyclerView.ViewHolder)
    }
    fun startDrag(listener: OnStartDragListener){
        this.dragListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter02.ListItemViewHolder02{
        val view02 = LayoutInflater.from(parent.context).inflate(R.layout.item_data02_list, parent, false)
        return ListItemViewHolder02(view02)

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewAdapter02.ListItemViewHolder02, position: Int) {
        Log.d("ViewAdapter02", "===== ===== ===== ===== onBindViewHolder02 ===== ===== ===== =====")
        holder.bindData02(list02[position])

        //드래그 앤 드롭
        list02[position].let {
            with(holder) {
                animalImg.setOnTouchListener { view, event ->
                    if(event.action == MotionEvent.ACTION_DOWN){
                        dragListener.onStartDrag(this)
                    }
                    return@setOnTouchListener false
                }
            }
        }

        //아이템 클릭
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

    override fun getItemCount(): Int {
        return list02.size
    }

    inner class ListItemViewHolder02 (itemView02: View?): RecyclerView.ViewHolder(itemView02!!)  {

        var data021Text: TextView = itemView02!!.findViewById(R.id.data02_1Text)
        var data022Text: TextView = itemView02!!.findViewById(R.id.data02_2Text)
        var animalImg: ImageView = itemView02!!.findViewById(R.id.ivImg)


//        binding?.ivMain?.setImageResource(R.drawable.sunny)
        fun bindData02(data02: DataClass02){
            Log.d("ViewAdapter02", "===== ===== ===== ===== bind ===== ===== ===== =====")
            Log.d("ViewAdapter02", data02.data02_1 + " " + data02.data02_2 + " " + data02.data02_3)

            data021Text.text = data02.data02_1
            data022Text.text = data02.data02_2
            animalImg.setImageResource(data02.data02_3)

        }
    }

    override fun onItemMoved(fromPosition: Int, toPosition: Int) {
        Collections.swap(list02, fromPosition, toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemSwiped(position: Int) {
        list02.removeAt(position)
        notifyItemRemoved(position)
    }

}