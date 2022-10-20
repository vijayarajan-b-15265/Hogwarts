package com.example.mailjet.data

import com.example.mailjet.R
import com.example.mailjet.Wand

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

fun geUsersList(): List<HogwartsDataHelper> {
    val HogwartsDataHelperList = ArrayList<HogwartsDataHelper>()
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Harry Potter",
            house = "Gryffindor",
            actor = "Daniel Radcliffe",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Hermione Granger",
            house = "Gryffindor",
            actor = "Daniel Radcliffe",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Ron Weasley",
            house = "Gryffindor",
            actor = "Rupert Grint",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Draco Malfoy",
            house = "Slytherin",
            actor = "Tom Felton",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Cedric Diggory",
            house = "Hufflepuff",
            actor = "Robert Pattinson",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Cho Chang",
            house = "Ravenclaw",
            actor = "Katie Leung",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Bellatrix Lestrange",
            house = "Slytherin",
            actor = "Helena Bonham Carter",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Lord Voldemort",
            house = "Slytherin",
            actor = "Ralph Fiennes",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Percy Weasley",
            house = "Gryffindor",
            actor = "Chris Rankin",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Hannah Abbott",
            house = "Hufflepuff",
            actor = "Charlotte Skeoch",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    HogwartsDataHelperList.add(
        HogwartsDataHelper(
            name = "Lisa Turpin",
            house = "Ravenclaw",
            actor = "Louis Cordice",
            yearOfBirth = R.drawable.hogwarts_logo
        )
    )
    return HogwartsDataHelperList
}
