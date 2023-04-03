package teameverywhere.personal.test0403tworecyclerview.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import teameverywhere.personal.test0403tworecyclerview.databinding.FragmentMainBinding
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02
import teameverywhere.personal.test0403tworecyclerview.view.adapter.ViewAdapter01
import teameverywhere.personal.test0403tworecyclerview.view.adapter.ViewAdapter02

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var ViewAdapter01: ViewAdapter01
    private lateinit var ViewAdapter02: ViewAdapter02

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
        ViewAdapter01 = ViewAdapter01(list01)

        var list02: ArrayList<DataClass02> =
            requireActivity().intent!!.extras!!.get("DataList02") as ArrayList<DataClass02>
        Log.e("MainFragment", "Data List02: $list02")
        ViewAdapter02 = ViewAdapter02(list02)

        bindViews()
    }

    private fun bindViews() = with(binding){
        rvRecyclerView01.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        // RecyclerView.adapter에 지정
        rvRecyclerView01.adapter = ViewAdapter01

        rvRecyclerView02.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rvRecyclerView02.adapter = ViewAdapter02
    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}