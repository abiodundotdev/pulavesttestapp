package com.abiodundotdev.pulavest.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun FilledButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    text: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier =  Modifier.fillMaxWidth().apply{modifier},
    ) {
        Text(text = text,
            modifier =  Modifier.padding(horizontal =  60.dp, vertical = 15.dp),
            color = Color.White,
            style = MaterialTheme.typography.button,
        )
    }
}

@Composable
fun GhostButton(
    onClick: () -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    shape: Shape = MaterialTheme.shapes.small,
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    text: String,
    fractionalSize : Float
) {
    Button(
        onClick = onClick,
        modifier =  Modifier.height(30.0.dp),
        shape = RoundedCornerShape(20.0.dp),
        border = BorderStroke(1.0.dp, color = MaterialTheme.colors.primary),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.primary,

        ),
        ) {
        Text(text = text,
            modifier =  Modifier.padding(horizontal =  60.dp, vertical = 15.dp),
            color = Color.Green,
            style = MaterialTheme.typography.button,
        )
    }
}