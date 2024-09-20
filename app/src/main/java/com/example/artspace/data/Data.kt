package com.example.artspace.data
import com.example.artspace.R
import com.example.artspace.artworks.Artwork

class Data {
    fun loadArtworks(): List<Artwork>{
        return listOf<Artwork>(
            Artwork(
                artistNameResourceId = R.string.artist_fallen_angel,
                artTitleResourceId = R.string.title_fallen_angel,
                imageResourceId = R.drawable.fallen_angel
            ),
            Artwork(
                artistNameResourceId = R.string.artist_woman_with_parasol,
                artTitleResourceId = R.string.title_woman_with_parasol,
                imageResourceId = R.drawable.woman_with_parasol
            ),

            Artwork(
                artistNameResourceId = R.string.artist_spring_time,
                artTitleResourceId = R.string.title_spring_time,
                imageResourceId = R.drawable.spring_time
            ),
        )
    }
}
