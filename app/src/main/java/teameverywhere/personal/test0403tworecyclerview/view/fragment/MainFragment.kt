package teameverywhere.personal.test0403tworecyclerview.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.R
import teameverywhere.personal.test0403tworecyclerview.databinding.FragmentMainBinding
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02
import teameverywhere.personal.test0403tworecyclerview.view.activity.ProfileDetailActivity
import teameverywhere.personal.test0403tworecyclerview.view.adapter.ViewAdapter01
import teameverywhere.personal.test0403tworecyclerview.view.adapter.ViewAdapter02

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewAdapter01: ViewAdapter01
    private lateinit var viewAdapter02: ViewAdapter02

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list01: ArrayList<DataClass01> =
            requireActivity().intent!!.extras!!.get("DataList01") as ArrayList<DataClass01>
        Log.e("MainFragment", "Data List01: $list01")
        // Fragment에서 전달받은 list를 넘기면서 ListAdapter 생성
        viewAdapter01 = ViewAdapter01(list01)

        var list02: ArrayList<DataClass02> =
            requireActivity().intent!!.extras!!.get("DataList02") as ArrayList<DataClass02>
        Log.e("MainFragment", "Data List02: $list02")
        viewAdapter02 = ViewAdapter02(list02)

        bindViews()

//        val intent = Intent(this.context, ProfileDetailActivity::class.java)

        viewAdapter01.setOnItemClickListener(object: ViewAdapter01.OnItemClickListener{

            override fun onClick(v: View, position: Int) {
//                intent.putExtra("Click01_1data", list01[position].getData01_1())
//                intent.putExtra("Click01_2data", list01[position].getData01_2())
//                intent.putExtra("Click01_3data", list01[position].getData01_3())
                Log.d("ViewAdapter01", "===== ===== ===== ===== click ===== ===== ===== =====")
                Log.d("ViewAdapter01", "${list01[position].getData01_1()}" + "${list01[position].getData01_2()}" + "${list01[position].getData01_3()}")

            }
        })

    }

    private fun bindViews() = with(binding){
        rvRecyclerView01.layoutManager =
            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        // RecyclerView.adapter에 지정
        rvRecyclerView01.adapter = viewAdapter01

        rvRecyclerView02.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvRecyclerView02.adapter = viewAdapter02
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}