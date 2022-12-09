package com.example.ponlineapp.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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

//@Preview()
@Composable
fun NavHostContainer(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
//test
    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "home",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = paddingValues),

        builder = {

            // route : Home
            composable("home") {
                HomeScreen()
            }

            // route : search
            composable("search") {
                Page1Screen()
            }

            // route : profile
            composable("profile") {
                Page2Screen(navController)
            }
            composable("Login"){
                Loginform(navController)
            }
        })

}

@Composable
fun HomeAppBar(
    backgroundColor: Color,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = {
            Column() {
            Text(
                text = stringResource(
                    id = R.string.name),
                    fontSize = 22.sp,
                    fontFamily = FontFamily.SansSerif,
            )
            Text(
                text = stringResource(
                    id = R.string.comunity),
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
        backgroundColor = backgroundColor,
        modifier = modifier
    )
        
}
    


@Composable
fun BottomNavigationBar(navController: NavHostController) {

    BottomNavigation(
        backgroundColor = colorResource(R.color.blue_100)
    ) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            BottomNavigationItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false
            )
        }
    }
}

//@Preview(showBackground = true)
@Preview( showBackground = true,showSystemUi = true)
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
        verticalArrangement = Arrangement.Center
    ) {
        // Icon Composable
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
            tint = colorResource(R.color.blue_100)
        )
        // Text to Display the current Screen
        Text(text = "Home", color = Color.Black)
    }
}

//@Preview(showSystemUi = true, showBackground = true)
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

@Composable()
fun PageTest(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .windowInsetsPadding(
                WindowInsets.systemBars
                    .only(WindowInsetsSides.Horizontal)
//                    .add(WindowInsets(top = 25.dp, bottom = 50.dp))
//                    .asPaddingValues()
            )

    ) {

        val navController = rememberNavController()
        Box {
            BackgroundImage()
            Scaffold(
                backgroundColor = Color.Transparent,
                topBar = {
                    HomeAppBar(
                        backgroundColor = colorResource(R.color.blue_100),
                        modifier = Modifier.fillMaxWidth()
                    )
                },
                content = { padding -> //
                    // Navhost: where screens are placed
                    NavHostContainer(navController = navController, paddingValues = padding)
                },
                // Bottom navigation
                bottomBar = { BottomNavigationBar(navController = navController) },


                )
        }
    }

}




//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PonlineAppTheme {
//
//                // remember navController so it does not
//                // get recreated on recomposition
//                val navController = rememberNavController()
//
//                Surface(color = Color.White) {
//                    // Scaffold Component
//                    Scaffold(
//                        // Bottom navigation
//                        bottomBar = {
//                            BottomNavigationBar(navController = navController)
//                        }, content = { padding ->
//                            // Navhost: where screens are placed
//                            NavHostContainer(navController = navController, padding = padding)
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
