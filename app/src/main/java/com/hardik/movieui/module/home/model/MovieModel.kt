package com.hardik.movieui.module.home.model

import com.hardik.movieui.R

data class MovieModel(
    val id: String,
    val title: String,
    val assetImage: Int,
    val type: String,
    val duration: String,
    val rating: String,
    val synopsis: String,
    val isPlaying: String,
)

val nowPlayingMovie = listOf(
    MovieModel(
        id = "1",
        title = "Avengers: Endgame",
        assetImage = R.drawable.avengers_endgame,
        type = "Action",
        duration = "181 min",
        rating = "8.4",
        synopsis = "Avengers: Endgame is a 2019 superhero film produced by Marvel Studios.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "2",
        title = "The Dark Knight",
        assetImage = R.drawable.the_dark_knight,
        type = "Action",
        duration = "152 min",
        rating = "9.0",
        synopsis = "The Dark Knight is a 2008 superhero film directed by Christopher Nolan.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "3",
        title = "Inception",
        assetImage = R.drawable.inception,
        type = "Science Fiction",
        duration = "148 min",
        rating = "8.8",
        synopsis = "Inception is a 2010 science fiction action film written and directed by Christopher Nolan.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "4",
        title = "Interstellar",
        assetImage = R.drawable.interstellar,
        type = "Science Fiction",
        duration = "169 min",
        rating = "8.6",
        synopsis = "Interstellar is a 2014 science fiction film directed by Christopher Nolan.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "5",
        title = "The Shawshank Redemption",
        assetImage = R.drawable.shawshank_redemption,
        type = "Drama",
        duration = "142 min",
        rating = "9.3",
        synopsis = "The Shawshank Redemption is a 1994 drama film directed by Frank Darabont.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "6",
        title = "The Godfather",
        assetImage = R.drawable.the_godfather,
        type = "Crime",
        duration = "175 min",
        rating = "9.2",
        synopsis = "The Godfather is a 1972 crime film directed by Francis Ford Coppola.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "7",
        title = "Pulp Fiction",
        assetImage = R.drawable.pulp_fiction,
        type = "Crime",
        duration = "154 min",
        rating = "8.9",
        synopsis = "Pulp Fiction is a 1994 black comedy crime film directed by Quentin Tarantino.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "8",
        title = "Forrest Gump",
        assetImage = R.drawable.forrest_gump,
        type = "Drama",
        duration = "142 min",
        rating = "8.8",
        synopsis = "Forrest Gump is a 1994 comedy-drama film directed by Robert Zemeckis.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "9",
        title = "The Matrix",
        assetImage = R.drawable.the_matrix,
        type = "Action",
        duration = "136 min",
        rating = "8.7",
        synopsis = "The Matrix is a 1999 science fiction action film directed by the Wachowskis.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "10",
        title = "The Lord of the Rings: The Return of the King",
        assetImage = R.drawable.lord_of_the_rings,
        type = "Fantasy",
        duration = "201 min",
        rating = "8.9",
        synopsis = "The Lord of the Rings: The Return of the King is a 2003 epic fantasy film directed by Peter Jackson.",
        isPlaying = "true"
    ),
)
val upcomingMovie = listOf(
    MovieModel(
        id = "11",
        title = "Schindler's List",
        assetImage = R.drawable.schindlers_list,
        type = "Drama",
        duration = "195 min",
        rating = "8.9",
        synopsis = "Schindler's List is a 1993 historical drama film directed by Steven Spielberg.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "12",
        title = "Fight Club",
        assetImage = R.drawable.fight_club,
        type = "Thriller",
        duration = "139 min",
        rating = "8.8",
        synopsis = "Fight Club is a 1999 psychological thriller film directed by David Fincher.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "13",
        title = "Goodfellas",
        assetImage = R.drawable.goodfellas,
        type = "Crime",
        duration = "146 min",
        rating = "8.7",
        synopsis = "Goodfellas is a 1990 crime film directed by Martin Scorsese.",
        isPlaying = "false"
    ),
    MovieModel(
        id = "14",
        title = "Inglourious Basterds",
        assetImage = R.drawable.inglourious_basterds,
        type = "War",
        duration = "153 min",
        rating = "8.3",
        synopsis = "Inglourious Basterds is a 2009 war film directed by Quentin Tarantino.",
        isPlaying = "true"
    ),
    MovieModel(
        id = "15",
        title = "The Godfather: Part II",
        assetImage = R.drawable.the_godfather_part_ii,
        type = "Crime",
        duration = "202 min",
        rating = "9.0",
        synopsis = "The Godfather: Part II is a 1974 crime film directed by Francis Ford Coppola.",
        isPlaying = "true"
    ),
)