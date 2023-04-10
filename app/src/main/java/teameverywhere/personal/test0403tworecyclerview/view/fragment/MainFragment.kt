package teameverywhere.personal.test0403tworecyclerview.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
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

    private lateinit var viewAdapter01: ViewAdapter01
    private lateinit var viewAdapter02: ViewAdapter02

    private var transFragmentInterface: TransFragmentInterface? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    interface TransFragmentInterface {
        fun transFragmentA()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is TransFragmentInterface) {
            transFragmentInterface = context
        } else {
            throw RuntimeException("$context must implement MyInterface")
        }
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

//        val intent = Intent(this.context, FragmentA::class.java)

//TODO viewAdapter01에 대한클릭 이벤트 발생
        //Adapter01에 대한 클릭
        viewAdapter01.setOnItemClickListener(object: ViewAdapter01.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
//                intent.putExtra("Click01_1data", list01[position].getData01_1())
//                intent.putExtra("Click01_2data", list01[position].getData01_2())
//                intent.putExtra("Click01_3data", list01[position].getData01_3())
                Log.d("ViewAdapter01", "===== ===== ===== ===== click ===== ===== ===== =====")
                Log.d("ViewAdapter01", "${list01[position].getData01_1()}" + "${list01[position].getData01_2()}" + "${list01[position].getData01_3()}")


                //TODO 번들 데이터 전달
                fun sendResult() {
                    val getDataA1 = "${list01[position].getData01_1()}"
                    val getDataA2 = "${list01[position].getData01_2()}"
                    val getDataA3 = "${list01[position].getData01_3()}"
//                     setFragmentResult() 메소드를 호출하여 결과 데이터를 전달합니다.
                    setFragmentResult("requestKey",
//                      결과 데이터를 번들에 담습니다.
                        bundleOf(
                        "bundleKey1" to getDataA1,
                        "bundleKey2" to getDataA2,
                        "bundleKey3" to getDataA3))
                }

                sendResult()
                transFragmentInterface?.transFragmentA()
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