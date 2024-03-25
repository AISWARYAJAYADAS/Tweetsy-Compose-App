package com.example.tweetsy.repository

import com.example.tweetsy.api.TweetsyAPI
import com.example.tweetsy.models.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> get() = _categories

    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>> get() = _tweets

    suspend fun getCategories() {
        val result = tweetsyAPI.getCategory()
        if (result.isSuccessful && result.body() != null) {
            _categories.emit(result.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val result = tweetsyAPI.getTweets("tweets[?(@.category==\"${category}\")]")
        if (result.isSuccessful && result.body() != null) {
            _tweets.emit(result.body()!!)
        }
    }
}