package com.example.ponlineapp.dashboard


import ItineraryDay
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ponlineapp.R
import com.example.ponlineapp.login.BackgroundImage
import com.example.ponlineapp.login.Loginform
import com.example.ponlineapp.models.RouteNav
import com.example.ponlineapp.ui.theme.PonlineAppTheme

//@Preview()
@Composable
fun NavHostContainer(
    modifier: Modifier,
    navController: NavHostController,
    padding: PaddingValues
) {
//test
    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "home",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            // route : Home
            composable("home") {
            }

            // route : search
            composable("search") {
//                Page1Screen(navController)
            }

            // route : profile
            composable("profile") {
                Page2Screen(navController)
//                Page2Screen()
            }
            composable("Login"){
                Loginform(navController)
//                Loginform()
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    topAppBarColors: TopAppBarColors,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Column() {
                androidx.compose.material3.Text(
                    text = stringResource(
                        id = R.string.name
                    ),
                    fontSize = 22.sp,
                    fontFamily = FontFamily.SansSerif,
                )
                androidx.compose.material3.Text(
                    text = stringResource(
                        id = R.string.comunity
                    ),
                    fontSize = 10.sp,
                    fontFamily = FontFamily.SansSerif,
                )

            }
        },
        navigationIcon =  {
            Box {
                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Image(
                            painter = painterResource(R.drawable.ic_account),
                            contentDescription = null
                        )
                    }
                }

            }
        },
        colors = topAppBarColors,
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    containerColors: Color = colorResource(R.color.blue_80),
)
{
    NavigationBar(
        containerColor = containerColors,
        modifier = modifier,
        contentColor = Color.Black
        ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors( indicatorColor = colorResource(R.color.secondary)),

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    androidx.compose.material3.Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    androidx.compose.material3.Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview
@Composable
fun itinerary_card(
    modifier: Modifier = Modifier
){
    var comparator by remember { mutableStateOf(DayComparator) }
    val context = LocalContext.current
    val interactionSource = remember {
        MutableInteractionSource()
    }
    LazyColumn(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
            val sortedList = ItineraryList.sortedWith(comparator)
            items(sortedList, key = { it.day})
        {
            Card(
                elevation = CardDefaults.cardElevation(2.dp),
//        elevation = 2.dp,
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.secondary)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            )    {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.Transparent),
                ) {
                    Text(
                        text = "Jadwal",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = it.day +" "+ it.date +" "+ it.month,
                            style = MaterialTheme.typography.displayMedium)
                        IconButton(onClick = {
                            Toast.makeText(context,"Test Toast",Toast.LENGTH_SHORT).show()
                        },modifier = Modifier
                            .size(40.dp, 40.dp)
                            .clip(CircleShape)
                            .background(Color.Black),
                            enabled = true,
                            interactionSource = interactionSource,) {

                            Icon(imageVector = Icons.Filled.Edit,
                                contentDescription = "Edit",
                                tint = Color.White)
                        }
                    }
                }
            }
        }
    }
}

//Badge style size
fun Modifier.badgeLayout() =
    layout {
            measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val minPadding = placeable.height / 4
        val width = maxOf(placeable.width + minPadding, placeable.height)
        layout(width, placeable.height) {
            placeable.place((width - placeable.width) / 2, 0)
        }
    }

@Preview(showBackground = true)
@OptIn(ExperimentalFoundationApi::class)
//@Preview( showBackground = true,showSystemUi = true)
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .windowInsetsPadding(
                WindowInsets.systemBars.only(WindowInsetsSides.Horizontal)
            ),
        // Parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            elevation = CardDefaults.cardElevation(5.dp),
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(colorResource(id = R.color.blue_f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
        ) {
            Row(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        text = stringResource(
                            id = R.string.comunity
                        ),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Top,
                ){
                    Box(contentAlignment = Alignment.CenterStart,modifier = Modifier
                        .padding(5.dp, 0.dp, 5.dp, 5.dp)
                        .background(
                            colorResource(id = R.color.secondary),
                            shape = RoundedCornerShape(20.dp)
                        )){
                        Row(
                            modifier = Modifier
                                .padding(10.dp, 1.dp)
                                .width(75.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text( stringResource(id = R.string.anggota))
                            Text(
                                stringResource(id = R.string.Jumlah_Anggota),
                                modifier = Modifier
                                    .background(
                                        colorResource(id = R.color.orange_100),
                                        shape = CircleShape
                                    )
                                    .badgeLayout(),
                                fontSize = 10.sp,
                                fontFamily = FontFamily.SansSerif,
                            )
                        }
                    }
                    Box(contentAlignment = Alignment.CenterStart,modifier = Modifier
                        .padding(5.dp, 5.dp, 5.dp, 0.dp)
                        .background(
                            colorResource(id = R.color.secondary),
                            shape = RoundedCornerShape(20.dp)
                        )){
                        Row(
                            modifier = Modifier
                                .padding(10.dp, 1.dp)
                                .width(75.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text( stringResource(id = R.string.kolam))
                            Text(
                                stringResource(id = R.string.Jumlah_Kolam),
                                modifier = Modifier
                                    .background(
                                        colorResource(id = R.color.orange_100),
                                        shape = CircleShape
                                    )
                                    .badgeLayout(),
                                fontSize = 10.sp,
                                fontFamily = FontFamily.SansSerif,
                            )
                        }
                    }
                }
            }
        }
        itinerary_card()
    }
}
private val DayComparator = Comparator<ItineraryDay> { left, right ->
    left.date.compareTo(right.date)
}

//Fake Date
private val ItineraryList = listOf(
    ItineraryDay("Kamis", 1, 12),
    ItineraryDay("Jumat", 2, 12),
    ItineraryDay("Sabtu", 3, 12),
    ItineraryDay("Minggu", 4, 12),
    ItineraryDay("Senin", 5, 12),
    ItineraryDay("Selasa", 6, 12),
    ItineraryDay("Rabu", 7, 12),
    ItineraryDay("Kamis", 8, 12),
    ItineraryDay("Jumat", 9, 12),
    ItineraryDay("Sabtu", 10, 12),
    ItineraryDay("Minggu", 11, 12),
    ItineraryDay("Senin", 12, 12),
    ItineraryDay("Selasa", 13, 12)
)

//@Preview()
@Composable
fun Page1Screen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        // Parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon Composable
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "search",
            tint = colorResource(R.color.blue_100)
        )
        // Text to Display the current Screen
        Text(text = "Search", color = Color.Black)
    }
}

@Composable
fun Page2Screen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent),
        // Parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon Composable
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Profile",
            tint = colorResource(R.color.blue_100)
        )
        // Text to Display the current Screen
        Text(text = "Profile", color = Color.Black)
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { navHostController.navigate(RouteNav.Login.route) },
            modifier = Modifier
                .height(50.dp)
                .width(150.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            elevation = ButtonDefaults.elevation(defaultElevation = 10.dp),
            ) {
            Text(text = "Keluar", fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable()
fun PageTest(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .windowInsetsPadding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Horizontal)
//                    .add(WindowInsets(top = 25.dp, bottom = 50.dp))
//                    .asPaddingValues()
            )


    ){

        val navController = rememberNavController()
        var comparator by remember { mutableStateOf(DayComparator)}
//        val appBarColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.87f)

        Box {
            BackgroundImage()
            Scaffold(
                containerColor = Color.Transparent,
                modifier = Modifier
                    .systemBarsPadding(),
                topBar = {
//                    val appBarColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.87f)
                    HomeAppBar(
                        topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = colorResource(R.color.blue_80)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                content = { padding ->
                    NavHostContainer(
                        modifier = Modifier.background(Color.Transparent),
                        navController = navController, padding = padding
                    )
                },
                // Bottom navigation
                bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                },
            )
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//class DashboardActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PonlineAppTheme {
//                var comparator by remember { mutableStateOf(DayComparator) }
//                // A surface container using the 'background' color from the theme
//                val navController = rememberNavController()
//
//                Surface(color = Color.White) {
//                    // Scaffold Component
//                    Scaffold(
//                        // Topbar
//                        topBar = {
//                            HomeAppBar(
//                                topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
//                                    containerColor = colorResource(R.color.blue_80)
//                                ),
//                                modifier = Modifier.fillMaxWidth()
//                            )
//                        },
//                        // Bottom navigation
//                        bottomBar = {
//                            BottomNavigationBar(navController = navController)
//                        }, content = { padding ->
//                            // Navhost: where screens are placed
//                            NavHostContainer(navController = navController, paddingValues = padding)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
