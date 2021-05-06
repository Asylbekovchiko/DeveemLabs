package kg.asylbekov.tesat.view.main.mainviewmodel

data class MainViewModel(
        var name : String? = null,
        var isChecked : Boolean? = null
)

data class TypeModel(
    var title: String? = null,
    var imageUrl: String? = null
)
data class MainModel(
    var imageUrl: String? = null,
    var openStores: String? = null,
    var title: String? = null,
    var status: String? = null,
    var stars : String? = null,
    var comments: String? = null,
    var type: String? = null,
    var food: String? = null,
    var category: String? = null,
    var price: String? = null,
    var distance: String? =null,
    var time: String? = null,
var delivery: String? = null
)