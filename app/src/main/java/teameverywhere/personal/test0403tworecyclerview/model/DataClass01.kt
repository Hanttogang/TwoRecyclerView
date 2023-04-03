package teameverywhere.personal.test0403tworecyclerview.model

data class DataClass01(
    private var data01_1: String? = null,
    private var data01_2: String? = null,
    private var data01_3: String? = null
){
    fun getData01_1(): String? {
        return data01_1
    }
    fun setData01_1(name: String) {
        this.data01_1 = data01_1
    }
    fun getData01_2(): String? {
        return data01_2
    }
    fun setData01_2(address: String) {
        this.data01_2 = data01_2
    }
    fun getData01_3(): String? {
        return data01_3
    }
    fun setData01_3(type: String) {
        this.data01_3 = data01_3
    }
}

