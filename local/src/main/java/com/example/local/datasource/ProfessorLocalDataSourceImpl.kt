package com.example.local.datasource

import com.example.common.entity.Professor
import com.example.data.datasource.ProfessorLocalDataSource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProfessorLocalDataSourceImpl @Inject constructor() : ProfessorLocalDataSource {

    override suspend fun getProfessors(): List<Professor> {
        delay(1000)
        return listOf(
            Professor(
                id = 0,
                name = "Minerva McGonagall",
                course = "Transfiguration, Deputy Headmistress",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972758-d6ea2b80-bfc7-11eb-81d1-d9dd8c939aa3.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            ),
            Professor(
                id = 1,
                name = "Quirinus Quirrell",
                course = "Defence Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972759-d782c200-bfc7-11eb-8466-2ae3f48badc3.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Professor"
            ),
            Professor(
                id = 2,
                name = "Gilderoy Lockhart",
                course = "Defence Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972752-d5b8fe80-bfc7-11eb-8df4-cfce2392f815.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Professor"
                ),
            Professor(
                id = 3,
                name = "Horace Slughorn",
                course = "Potions",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972753-d5b8fe80-bfc7-11eb-8d9e-c6af4de59005.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"


            ),
            Professor(
                id = 4,
                name = "Pomona Sprout",
                course = "Herbology",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972755-d6519500-bfc7-11eb-81a8-09ea0de98a85.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Professor"


            ),
            Professor(
                id = 5,
                name = "Rubeus Hagrid",
                course = "Care of Magical Creatures",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972769-d9e51c00-bfc7-11eb-81b3-1677282f3241.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Professor"
            ),
            Professor(
                id = 6,
                name = "Alastor Moody",
                course = "Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972739-d2257780-bfc7-11eb-982d-a4dc64383abb.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            ),
            Professor(
                id = 7,
                name = "Severus Snape",
                course = "Potions, Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972771-da7db280-bfc7-11eb-9bc8-77ef76375675.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            ),
            Professor(
                id = 8,
                name = "Sybill Trelawney",
                course = "Muggles' Guide",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972771-da7db280-bfc7-11eb-9bc8-77ef76375675.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            ),
            Professor(
                id = 9,
                name = "Dolores Umbridge",
                course = "Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/120105493-6598ad00-c16e-11eb-9be3-1c25d1f1cfe1.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Professor"
            ),
            Professor(
                id = 10,
                name = "Remus Lupin",
                course = "Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/120105576-be684580-c16e-11eb-8f86-8649fa5d929d.jpg",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            ),
            Professor(
                id = 11,
                name = "Albus Dumbledore",
                course = "Transfiguration",
                imageUrl = "https://user-images.githubusercontent.com/47349044/120105711-6251f100-c16f-11eb-9a31-4e6d5d98631d.png",
                "Hogwarts School of Witchcraft and Wizardry",
                "Head Professor"
            )
        )
    }
}