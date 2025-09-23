package com.app.splashscreen


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.app.splashscreen.ui.theme.SplashscreenTheme

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import com.app.splashscreen.ui.login.LoginScreen
import com.app.splashscreen.ui.newpassword.NewPasswordScreen
import com.app.splashscreen.ui.forgetpassword.ForgetPasswordScreen
import com.app.splashscreen.ui.password_otp.PasswordOtpScreen
import com.app.splashscreen.ui.dashboard.DashboardScreen
import com.app.splashscreen.ui.doctodoc_screen.DocToDocScreen
import com.app.splashscreen.ui.doctocp.DocToCpScreen
import com.app.splashscreen.ui.olc_office.OlcOfficeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("start") {
            com.app.splashscreen.ui.start.StartScreen {
                navController.navigate("login") {
                    popUpTo("start") { inclusive = true }
                }
            }
        }
        composable("login") { LoginScreen(navController) }
        composable("new_password") { NewPasswordScreen(navController) }
        composable("home") { HomeScreen() }
        composable("forget_password_email") { ForgetPasswordScreen(navController) }
        composable("password_otp") { PasswordOtpScreen(navController) }
    composable("dashboard") { DashboardScreen(navController) }
    composable("onlinecarepatients") { com.app.splashscreen.ui.onlinecarepatients.OnlineCarePatientsScreen(navController) }
    composable("refill_request") { com.app.splashscreen.ui.refill_request.RefillRequestScreen(navController) }
    composable("prescription") { com.app.splashscreen.ui.prescription.PrescriptionScreen(navController) }
    composable("doctodoc") { DocToDocScreen(navController) }
    composable("doctocp") { DocToCpScreen(navController) }
    composable("selectsymptoms") { com.app.splashscreen.ui.selectsymptoms.SelectSymptomsScreen(navController) }
        composable("patientcare") { com.app.splashscreen.ui.PatientCare.PatientCare(navController) }
        composable("callhistory") { com.app.splashscreen.ui.callhistory.CallHistoryScreen() }
    composable("olcOfficeVisit") { com.app.splashscreen.ui.olc_office.OlcOfficeVisitScreen(navController) }
    composable("olcOffice") { OlcOfficeScreen(navController) }
    composable("encounternotes") { com.app.splashscreen.ui.encounternotes.EncounterNotesScreen(navController) }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)
        navController.navigate("start") {
            popUpTo("splash") { inclusive = false }
        }
    }


    Surface(
        color = Color(0xFFC2185B), // dark pink
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.splash_pattern),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.splash_logo),
                contentDescription = "Splash Logo",
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(200.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreen() {
    Surface(modifier = androidx.compose.ui.Modifier.fillMaxSize()) {
        Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
            Text("Welcome Home", style = MaterialTheme.typography.headlineLarge)
        }
    }
}