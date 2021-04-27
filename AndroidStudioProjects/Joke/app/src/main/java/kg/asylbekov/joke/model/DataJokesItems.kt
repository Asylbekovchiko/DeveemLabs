package kg.asylbekov.joke.model

import com.google.gson.annotations.SerializedName

data class DataJokesItems(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("punchline")
    val punchline: String? = null,
    @SerializedName("setup")
    val setup: String? = null,
    @SerializedName("type")
    val type: String? = null
)