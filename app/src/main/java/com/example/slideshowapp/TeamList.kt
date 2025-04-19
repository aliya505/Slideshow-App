package com.example.slideshowapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.slideshowapp.data.Datasource
import com.example.slideshowapp.model.Team

@Composable
fun TeamCard(team: Team, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp)) {
        Column {
            Image(
                painter = painterResource(id = team.imageResource),
                contentDescription = stringResource(id = team.teamName),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = team.teamName),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
fun TeamList(teams: List<Team>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(teams) { team ->
            TeamCard(team = team)
        }
    }
}

@Composable
fun TeamsApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TeamList(teams = Datasource.loadTeams())
    }
}
