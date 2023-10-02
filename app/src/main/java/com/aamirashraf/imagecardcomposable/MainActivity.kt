package com.aamirashraf.imagecardcomposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aamirashraf.imagecardcomposable.ui.theme.ImageCardComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //also we are going to learn about the box
            //how to align with the box
            val painter= painterResource(id = R.drawable.konate)
            val title="konate is playing football"
            val contentDescription="konate is playing football"
            Box(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)){
                ImageCard(painter = painter, contentDescription = contentDescription, title = title)

            }

        }
    }
}
//naming for the composable function is StartFromCapital
@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier=Modifier   //default empty modifier
){
    Card(
        modifier=modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(5.dp)   //elevation use to gives the shadow
    ){

        //now we are going to use the concept of the box here
        //box comes stack manner ,since we want to display image first then little bit of gradient
        //and also some text so for this we need to use the box
        //using the box we gave some alignment property to the box
        Box(modifier=modifier.height(200.dp)) {
            Image(painter = painter, contentDescription = contentDescription,
            contentScale = ContentScale.Crop)  //same as center crop
            //use a box to display the gradient top to bottom light to dark
            Box(modifier = modifier.fillMaxSize()
                .background(brush = Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Black),
                    startY = 300f
                )))
            //now we want to display the text above the image for this we need a another box
            Box(modifier = modifier
                .fillMaxSize()
                .padding(12.dp),
                //box doesn't have main axis and cross axis box has content alignment
            contentAlignment = Alignment.BottomStart){
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 15.sp))
            }
        }
    }
}
