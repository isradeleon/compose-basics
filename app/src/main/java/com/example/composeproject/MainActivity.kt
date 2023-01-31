package com.example.composeproject

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.content, ComposableHomeFragment())
//            .commit()

        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContentV2()
                }
            }
        }
    }
}

@Composable
fun ComposeWithXML(
    modifier: Modifier
) {
    AndroidView(
        factory = {
            View.inflate(it, R.layout.custom_layout, null)
        },
        modifier = modifier,
        update = {
            val tv = it.findViewById<TextView>(R.id.textView)
            tv.setOnClickListener {
                tv.text = "Text view clicked"
            }
        }
    )
}

/*
* #3 & #4 videos
*
* How recyclerViews are replaced in composed by LazyColumn
* How to recompose views with remember function
* */
@Composable
fun MainContentScreen() {
    val users = remember {
        mutableStateListOf<User>()
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        UserList(users)
        Button(
            onClick = {
                users.addAll(
                    listOf(
                        User("Arsi Neoled"),
                        User("John Doe"),
                        User("Isra de Leon")
                    )
                )
            },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(text = "Add more...")
        }
    }
}

data class User(
    val name: String
)

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user -> UserCard(user) }
    }
//    Column(
//        modifier = Modifier.verticalScroll(rememberScrollState())
//    ) {
//        for (i in 1..10)
//            UserCard()
//    }
}

// #2 video - Manage layout behavior (Row & Column)
@Composable
fun UserCard(user: User) {
    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(13.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "User image",
                modifier = Modifier
                    .size(77.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(text = user.name, fontWeight = FontWeight.Bold)
                Text(text = "Lorem ipsum dolor sit amet.")
                Button(onClick = {
                    // Click action
                }) {
                    Text(text = "View profile")
                }
            }
        }
    }
}

// #1 video - Composable functions (Text)
@Composable
fun Title() {
    val context = LocalContext.current
    Text(
        text = "Arsi Neoled",
        fontSize = 32.sp,
        fontFamily = FontFamily.Cursive,
        color = colorResource(id = R.color.purple_700),
        modifier = Modifier.clickable {
            Toast.makeText(context, "Label clicked", Toast.LENGTH_SHORT).show()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Title()
        }
    }
}