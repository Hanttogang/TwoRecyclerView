package teameverywhere.personal.test0403tworecyclerview.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import teameverywhere.personal.test0403tworecyclerview.MainActivity
import teameverywhere.personal.test0403tworecyclerview.databinding.FragmentABinding

class FragmentA : Fragment(), MainActivity.onBackPressedListener {
    private var _binding: FragmentABinding? = null
    private val binding get() = _binding!!

    override fun onBackPressed() {
        requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        //requireActivity().supportFragmentManager.popBackStack()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentABinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews()
    }

    private fun bindViews() = with(binding){

        // 결과 데이터를 수신하기 위해 setFragmentResultListener() 메소드를 호출합니다.
        setFragmentResultListener("requestKey") { key, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            // 번들에서 데이터를 추출합니다.
            val getDataA1 = bundle.getString("bundleKey1")
            val getDataA2 = bundle.getString("bundleKey2")
            val getDataA3 = bundle.getString("bundleKey3")

            // 추출한 데이터를 사용하여 작업을 수행합니다.
            tvData1.text = getDataA1.toString()
            tvData2.text = getDataA2.toString()
            tvData3.text = getDataA3.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        _binding = null
    }
}