
package com.app.emcura


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import com.app.emcura.ui.login.LoginScreen
import com.app.emcura.ui.newpassword.NewPasswordScreen
import com.app.emcura.ui.forgetpassword.ForgetPasswordScreen
import com.app.emcura.ui.password_otp.PasswordOtpScreen
import com.app.emcura.ui.dashboard.DashboardScreen
import com.app.emcura.ui.doctodoc_screen.DocToDocScreen
import com.app.emcura.ui.doctocp.DocToCpScreen
import com.app.emcura.ui.olc_office.OlcOfficeScreen

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
            com.app.emcura.ui.start.StartScreen {
                navController.navigate("permission_request") {
                    popUpTo("start") { inclusive = true }
                }
            }
        }
        composable("login") { LoginScreen(navController) }
        composable("permission_request") { com.app.emcura.ui.permission_request.PermissionRequestScreen(navController) }
        composable("new_password") { NewPasswordScreen(navController) }
        composable("home") { HomeScreen() }
        composable("forget_password_email") { ForgetPasswordScreen(navController) }
        composable("password_otp") { PasswordOtpScreen(navController) }
        composable("dashboard") { DashboardScreen(navController) }
        composable("onlinecarepatients") { com.app.emcura.ui.onlinecarepatients.OnlineCarePatientsScreen(navController) }
        composable("instantconnect") { com.app.emcura.ui.instantconnect.InstantConnectScreen(navController) }
        composable("refill_request") { com.app.emcura.ui.refill_request.RefillRequestScreen(navController) }
        composable("prescription") { com.app.emcura.ui.prescription.PrescriptionScreen(navController) }
        composable("doctodoc") { DocToDocScreen(navController) }
        composable("doctocp") { DocToCpScreen(navController) }
        composable("selectsymptoms") { com.app.emcura.ui.selectsymptoms.SelectSymptomsScreen(navController) }
        composable("patientcare") { com.app.emcura.ui.PatientCare.PatientCare(navController) }
        composable("patientdetails") { com.app.emcura.ui.patientdetails.PatientDetailsScreen(navController) }
        composable("callhistory") { com.app.emcura.ui.callhistory.CallHistoryScreen(navController) }
        composable("callhistoryoption") { com.app.emcura.ui.callhistoryoption.CallHistoryOptionScreen(navController) }
        composable("aisuggesteddiagnosis") { com.app.emcura.ui.aisuggesteddiagnosis.AISuggestedDiagnosisScreen(navController) }
        composable("olcOfficeVisit") { com.app.emcura.ui.olc_office.OlcOfficeVisitScreen(navController) }
        composable("incomingcall") { com.app.emcura.ui.incomingcall.IncomingCallScreen() }
        composable("messages") { com.app.emcura.ui.messages.MessagesScreen(navController, onBackClick = { navController.popBackStack() }) }
        composable("messagechat") { com.app.emcura.ui.messages.MessageChatScreen(navController = navController, onBackClick = { navController.popBackStack() }) }
        composable("olcOffice") { OlcOfficeScreen(navController) }
        composable("encounternotes") { com.app.emcura.ui.encounternotes.EncounterNotesScreen(navController) }
        composable("waitingroom") { com.app.emcura.ui.waitingroom.WaitingRoomScreen(navController) }
        composable("connecttodoctor") { com.app.emcura.ui.connecttodoctor.ConnectToDoctorScreen(navController) }
        composable("videocall") { com.app.emcura.ui.videocall.VideoCallScreen(navController) }
        composable("servicesbillingcodes") { com.app.emcura.ui.servicesbilling.ServicesBillingCodesScreen(navController) }
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
        color = Color(0xFFC2185B),
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