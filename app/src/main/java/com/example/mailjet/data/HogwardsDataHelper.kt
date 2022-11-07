package com.example.mailjet.data

import com.example.mailjet.R

data class HogwartsDataHelper(
    val actor: String,
//    val alive: Boolean,
//    val alternate_actors: List<Any>,
//    val alternate_names: List<Any>,
//    val ancestry: String,
//    val dateOfBirth: String,
//    val eyeColour: String,
//    val gender: String,
//    val hairColour: String,
//    val hogwartsStaff: Boolean,
//    val hogwartsStudent: Boolean,
    val house: String,
//    val image: String,
    val name: String,
//    val patronus: String,
//    val species: String,
//    val wand: Wand,
//    val wizard: Boolean,
    val yearOfBirth: Int
)

fun getUsersList(): List<HogwartsDataHelper> {
    val HogwartsHelperList = ArrayList<HogwartsDataHelper>()
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Harry Potter",
            house = "Gryffindor",
            actor = "Daniel Radcliffe",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Hermione Granger",
            house = "Gryffindor",
            actor = "Emma Watson",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Ron Weasley",
            house = "Gryffindor",
            actor = "Rupert Grint",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Draco Malfoy",
            house = "Slytherin",
            actor = "Tom Felton",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Cedric Diggory",
            house = "Hufflepuff",
            actor = "Robert Pattinson",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Cho Chang",
            house = "Ravenclaw",
            actor = "Katie Leung",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Bellatrix Lestrange",
            house = "Slytherin",
            actor = "Helena Bonham Carter",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Lord Voldemort",
            house = "Slytherin",
            actor = "Ralph Fiennes",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Percy Weasley",
            house = "Gryffindor",
            actor = "Chris Rankin",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Hannah Abbott",
            house = "Hufflepuff",
            actor = "Charlotte Skeoch",
            yearOfBirth = R.drawable.pikachu
        )
    )
    HogwartsHelperList.add(
        HogwartsDataHelper(
            name = "Lisa Turpin",
            house = "Ravenclaw",
            actor = "Louis Cordice",
            yearOfBirth = R.drawable.pikachu
        )
    )
    return HogwartsHelperList
}
