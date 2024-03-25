package com.example.tweetsy.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tweetsy.R
import com.example.tweetsy.viewmodels.DetailsViewModel


@Composable
fun DetailScreen() {
    val detailsViewModel: DetailsViewModel = hiltViewModel()
    val tweets = detailsViewModel.tweets.collectAsState()
    LazyColumn {
        items(tweets.value) {
            TweetListItem(tweet = it.text)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)

    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                imageVector = Icons.Filled.AddCircle,
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.DarkGray),
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180f)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = tweet,
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily(Font(R.font.montserrat_regular))
            )
        }
    }

}