package teameverywhere.personal.test0403tworecyclerview.model

data class DataClass02(
    private var data02_1: String? = null,
    private var data02_2: String? = null,
    private var data02_3: String? = null
){
    fun getData02_1(): String? {
        return data02_1
    }
    fun setData02_1(name: String) {
        this.data02_1 = data02_1
    }
    fun getData02_2(): String? {
        return data02_2
    }
    fun setData02_2(address: String) {
        this.data02_2 = data02_2
    }
    fun getData02_3(): String? {
        return data02_3
    }
    fun setData02_3(type: String) {
        this.data02_3 = data02_3
    }
}

