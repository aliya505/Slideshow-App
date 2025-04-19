
package com.example.slideshowapp.data

import com.example.slideshowapp.R
import com.example.slideshowapp.model.Team


object Datasource {
    fun loadTeams(): List<Team> {
        return listOf(
            Team(R.drawable.team1, R.string.team1),
            Team(R.drawable.team2, R.string.team2),
            Team(R.drawable.team3, R.string.team3),
            Team(R.drawable.team4, R.string.team4),
            Team(R.drawable.team5, R.string.team5),
            Team(R.drawable.team6, R.string.team6),
            Team(R.drawable.team7, R.string.team7),
            Team(R.drawable.team8, R.string.team8),
            Team(R.drawable.team9, R.string.team9),
            Team(R.drawable.team10, R.string.team10)
        )
    }
}
