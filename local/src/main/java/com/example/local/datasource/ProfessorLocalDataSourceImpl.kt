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
            ),
            Professor(
                id = 1,
                name = "Quirinus Quirrell",
                course = "Defence Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972759-d782c200-bfc7-11eb-8466-2ae3f48badc3.jpg",
            ),
            Professor(
                id = 2,
                name = "Gilderoy Lockhart",
                course = "Defence Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972752-d5b8fe80-bfc7-11eb-8df4-cfce2392f815.jpg",
            ),
            Professor(
                id = 3,
                name = "Horace Slughorn",
                course = "Potions",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972753-d5b8fe80-bfc7-11eb-8d9e-c6af4de59005.jpg",
            ),
            Professor(
                id = 4,
                name = "Pomona Sprout",
                course = "Herbology",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972755-d6519500-bfc7-11eb-81a8-09ea0de98a85.jpg",
            ),
            Professor(
                id = 5,
                name = "Rubeus Hagrid",
                course = "Care of Magical Creatures",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972769-d9e51c00-bfc7-11eb-81b3-1677282f3241.jpg",
            ),
            Professor(
                id = 6,
                name = "Alastor Moody",
                course = "Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972739-d2257780-bfc7-11eb-982d-a4dc64383abb.jpg",
            ),
            Professor(
                id = 7,
                name = "Severus Snape",
                course = "Potions, Defense Against the Dark Arts",
                imageUrl = "https://user-images.githubusercontent.com/47349044/119972771-da7db280-bfc7-11eb-9bc8-77ef76375675.jpg",
            )
        )
    }
}