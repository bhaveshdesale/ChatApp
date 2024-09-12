package com.example.chatapp.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.chatapp.Components.*
import com.example.chatapp.R
import com.example.chatapp.data.Person
import com.example.chatapp.data.personList
import com.example.chatapp.navigation.Chat1
import com.example.chatapp.navigation.Chat1
import com.example.chatapp.ui.theme.DarkGrey
import com.example.chatapp.ui.theme.Line
import com.example.chatapp.ui.theme.Yellow

@Composable
fun HomeScreen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp)
        ) {
            HeaderAndStory()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
            ) {
                BottomSheetSwipe(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 15.dp)
                )
                LazyColumn(modifier = Modifier.padding(top = 30.dp, bottom = 15.dp)) {
                    items(personList, key = { person -> person.id }) {  // Use `person` to avoid variable name collision
                        UserEachRow(person = it) {
                            // Handle navigation safely with try-catch
                            try {
                                // Store the person object in savedStateHandle before navigating
                                navHostController.currentBackStackEntry?.savedStateHandle?.set("data" ,it)
                                navHostController.navigate(Chat1) // Correctly navigate to Chat screen
                            } catch (e: Exception) {
                                // Handle the crash if navigation fails
                                e.printStackTrace()
                            }
                        }
                    }
                }

            }
        }
    }
}

@Composable
fun UserEachRow(person: Person, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // The UserStoryComponent is the drawable item
        UserStoryComponent(person)

        // Adjust the layout to position the name and message next to the drawable
        Column(
            modifier = Modifier
                .padding(start = 10.dp) // Add padding to separate text from drawable
        ) {
            Text(
                text = person.name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            SpacerHeight(height = 4.dp)  // Adjusted spacing
            Text(
                text = "Okay",
                style = TextStyle(
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f)) // Pushes the timestamp to the right

        Text(
            text = "12:23 PM",
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp
            )
        )
    }
    SpacerHeight(height = 12.dp)  // Increased space between row and divider
    HorizontalDivider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = Line
    )
}


@Composable
fun UserStoryComponent(person: Person) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Yellow, CircleShape)
                .size(60.dp),  // Story size adjusted
            contentAlignment = Alignment.Center
        ) {
            IconComponentsDrawable(icon = person.icon, size = 45.dp) // Set story icon size to 45.dp
        }
        SpacerHeight(height = 6.dp)
        Text(
            text = person.name,
            style = TextStyle(
                fontSize = 13.sp,
                color = Color.Black // Text color adjusted for better visibility
            )
        )
    }
}

@Composable
fun BottomSheetSwipe(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(90.dp)
            .height(5.dp)
            .clip(RoundedCornerShape(90.dp))
            .background(DarkGrey)
            // Center the BottomSheetSwipe horizontally
    )
}

@Composable
fun HeaderAndStory(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp)) {
        Header()
        ViewStoryLayout()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    val text = buildAnnotatedString {
        withStyle(
            style = androidx.compose.ui.text.SpanStyle(
                color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.W300
            )
        ) {
            append(stringResource(R.string.welcome_back))
        }
        append(" ")
        withStyle(
            style = androidx.compose.ui.text.SpanStyle(
                color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold
            )
        ) {
            append(stringResource(R.string.bhavesh))
        }
    }
    Text(text = text)
}

@Composable
fun ViewStoryLayout(modifier: Modifier = Modifier) {
    LazyRow(modifier = Modifier.padding(vertical = 20.dp)) {
        item {
            AddStoryLayout()
            SpacerWidth(width = 16.dp)
        }
        items(personList, key = { it.id }) { person ->
            UserStoryLayout(person = person)
            SpacerWidth(width = 16.dp)
        }
    }
}

@Composable
fun UserStoryLayout(person: Person) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(end = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Yellow, CircleShape)
                .size(60.dp),  // Story size adjusted
            contentAlignment = Alignment.Center
        ) {
            IconComponentsDrawable(icon = person.icon, size = 45.dp) // Set story icon size to 45.dp
        }
        SpacerHeight(height = 6.dp)
        Text(
            text = person.name, style = TextStyle(
                fontSize = 13.sp, color = Color.White
            )
        )
    }
}

@Composable
fun AddStoryLayout(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .border(2.dp, DarkGrey, shape = CircleShape)
                .background(Yellow, shape = CircleShape)
                .size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(45.dp),  // Set add story size to 45.dp
                contentAlignment = Alignment.Center
            ) {
                IconComponentImageVector(
                    icon = Icons.Default.Add,
                    size = 24.dp,
                    tint = Yellow
                )
            }
        }
        SpacerHeight(height = 8.dp)
        Text(
            text = stringResource(R.string.add_story), style = TextStyle(
                fontSize = 13.sp, color = Color.White
            )
        )
    }
}
