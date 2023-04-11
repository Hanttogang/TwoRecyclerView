package teameverywhere.personal.test0403tworecyclerview

import android.app.LauncherActivity.ListItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import teameverywhere.personal.test0403tworecyclerview.databinding.ActivityMainBinding
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02
import teameverywhere.personal.test0403tworecyclerview.view.fragment.FragmentA
import teameverywhere.personal.test0403tworecyclerview.view.fragment.MainFragment

//Todo: Package는 View, Model, Controller
class MainActivity : AppCompatActivity(), MainFragment.TransFragmentInterface {
    private lateinit var binding: ActivityMainBinding

    interface onBackPressedListener {
        fun onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)
//        setContentView(binding.root)


        init()
        //bindViews()

    }
    override fun onBackPressed(){
        //아래와 같은 코드를 추가하도록 한다
        //해당 엑티비티에서 띄운 프래그먼트에서 뒤로가기를 누르게 되면 프래그먼트에서 구현한 onBackPressed 함수가 실행되게 된다.
        val fragmentList = supportFragmentManager.fragments
        for (fragment in fragmentList) {
            if (fragment is onBackPressedListener) {
                (fragment as onBackPressedListener).onBackPressed()
                return
            }
        }
    }

    private fun init(){
        var manager = supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainFragment())
            commit()
            dataList()
        }

    }

    private fun bindViews() = with(binding){

    }

    private fun dataList(){

        val dataList01 = arrayListOf<DataClass01>()

        dataList01.add(DataClass01("첫 번째 데이터a1", "두 번째 데이터a1", "세 번째 데이터a1"))
        dataList01.add(DataClass01("첫 번째 데이터a2", "두 번째 데이터a2", "세 번째 데이터a2"))
        dataList01.add(DataClass01("첫 번째 데이터a3", "두 번째 데이터a3", "세 번째 데이터a3"))
        dataList01.add(DataClass01("첫 번째 데이터a4", "두 번째 데이터a4", "세 번째 데이터a4"))


        var dataList02: ArrayList<DataClass02> = arrayListOf(
            DataClass02("첫 번째 데이터1", "두 번째 데이터1", R.drawable.bird),
            DataClass02("첫 번째 데이터2", "두 번째 데이터2", R.drawable.tiger),
            DataClass02("첫 번째 데이터3", "두 번째 데이터3", R.drawable.bird),
            DataClass02("첫 번째 데이터4", "두 번째 데이터4", R.drawable.panda),
            DataClass02("첫 번째 데이터5", "두 번째 데이터5", R.drawable.bird),
            DataClass02("첫 번째 데이터6", "두 번째 데이터6", R.drawable.bird),
            DataClass02("첫 번째 데이터7", "두 번째 데이터7", R.drawable.bird),
            DataClass02("첫 번째 데이터8", "두 번째 데이터8", R.drawable.tiger),
            DataClass02("첫 번째 데이터9", "두 번째 데이터9", R.drawable.panda)
        )

        val mainFragment = supportFragmentManager.beginTransaction()
        mainFragment.replace(
            R.id.container,
            MainFragment()
        )
        mainFragment.commit()

        //데이터 전달
        intent.putExtra("DataList01", dataList01)
        intent.putExtra("DataList02", dataList02)

    }

    //클릭 이벤트 발생시 transFragmentA함수 호출. activityMain 의 container 값을 FragmentA로 바꿈
    override fun transFragmentA() {
        //TODO 백스택 쌓기위해 add로 해봄
//        val transFragmentA = supportFragmentManager.beginTransaction()
//
//        transFragmentA.add(
//        R.id.container, FragmentA()
//        )
//
////        transFragmentA.apply {
////        }
//        transFragmentA.commit()
        supportFragmentManager.commit {
            replace<FragmentA>(R.id.container)
            setReorderingAllowed(true)
            addToBackStack(null)
        }


    }
}