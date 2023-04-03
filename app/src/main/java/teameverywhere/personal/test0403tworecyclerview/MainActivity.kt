package teameverywhere.personal.test0403tworecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import teameverywhere.personal.test0403tworecyclerview.databinding.ActivityMainBinding
import teameverywhere.personal.test0403tworecyclerview.model.DataClass01
import teameverywhere.personal.test0403tworecyclerview.model.DataClass02
import teameverywhere.personal.test0403tworecyclerview.view.fragment.MainFragment

//Todo: Package는 View, Model, Controller
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        //bindViews()

        dataList()
    }

    private fun init(){
        var manager = supportFragmentManager.beginTransaction().apply {
            add(R.id.container, MainFragment())
            commit()
        }
    }

    private fun bindViews() = with(binding){

    }

    private fun dataList(){
        var dataList01: ArrayList<DataClass01> = arrayListOf(
            DataClass01("첫 번째 데이터1", "두 번째 데이터1", "세 번째 데이터1"),
            DataClass01("첫 번째 데이터2", "두 번째 데이터2", "세 번째 데이터2"),
            DataClass01("첫 번째 데이터3", "두 번째 데이터3", "세 번째 데이터3"),
            DataClass01("첫 번째 데이터4", "두 번째 데이터4", "세 번째 데이터4"),
            DataClass01("첫 번째 데이터5", "두 번째 데이터5", "세 번째 데이터5"),
            DataClass01("첫 번째 데이터6", "두 번째 데이터6", "세 번째 데이터6"),
            DataClass01("첫 번째 데이터7", "두 번째 데이터7", "세 번째 데이터7"),
            DataClass01("첫 번째 데이터8", "두 번째 데이터8", "세 번째 데이터8"),
            DataClass01("첫 번째 데이터9", "두 번째 데이터9", "세 번째 데이터9"),
            DataClass01("첫 번째 데이터10", "두 번째 데이터10", "세 번째 데이터10"),
            DataClass01("첫 번째 데이터11", "두 번째 데이터11", "세 번째 데이터11"),
            DataClass01("첫 번째 데이터12", "두 번째 데이터12", "세 번째 데이터12"),
            DataClass01("첫 번째 데이터13", "두 번째 데이터13", "세 번째 데이터13"),
            DataClass01("첫 번째 데이터14", "두 번째 데이터14", "세 번째 데이터14"),
            DataClass01("첫 번째 데이터15", "두 번째 데이터15", "세 번째 데이터15")
        )

        var dataList02: ArrayList<DataClass02> = arrayListOf(
            DataClass02("첫 번째 데이터1", "두 번째 데이터1", "세 번째 데이터1"),
            DataClass02("첫 번째 데이터2", "두 번째 데이터2", "세 번째 데이터2"),
            DataClass02("첫 번째 데이터3", "두 번째 데이터3", "세 번째 데이터3"),
            DataClass02("첫 번째 데이터4", "두 번째 데이터4", "세 번째 데이터4"),
            DataClass02("첫 번째 데이터5", "두 번째 데이터5", "세 번째 데이터5"),
            DataClass02("첫 번째 데이터6", "두 번째 데이터6", "세 번째 데이터6"),
            DataClass02("첫 번째 데이터7", "두 번째 데이터7", "세 번째 데이터7"),
            DataClass02("첫 번째 데이터8", "두 번째 데이터8", "세 번째 데이터8"),
            DataClass02("첫 번째 데이터9", "두 번째 데이터9", "세 번째 데이터9"),
            DataClass02("첫 번째 데이터10", "두 번째 데이터10", "세 번째 데이터10"),
            DataClass02("첫 번째 데이터11", "두 번째 데이터11", "세 번째 데이터11"),
            DataClass02("첫 번째 데이터12", "두 번째 데이터12", "세 번째 데이터12"),
            DataClass02("첫 번째 데이터13", "두 번째 데이터13", "세 번째 데이터13"),
            DataClass02("첫 번째 데이터14", "두 번째 데이터14", "세 번째 데이터14"),
            DataClass02("첫 번째 데이터15", "두 번째 데이터15", "세 번째 데이터15")
        )

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(
            R.id.container,
            MainFragment()
        )
        transaction.commit()
        intent.putExtra("DataList01", dataList01)
        intent.putExtra("DataList02", dataList02)
    }
}