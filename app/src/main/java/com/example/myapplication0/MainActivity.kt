package com.example.myapplication0

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication0.ui.theme.MyApplication0Theme
import net.objecthunter.exp4j.ExpressionBuilder
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication0Theme {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                }
                DefaultPreview()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplication0Theme {
        Column {
            var input by remember { mutableStateOf("") }
            var out by remember { mutableStateOf("") }
            //колонка для вывода и ввода
            Column {
                Row {
                    Text(text = input)
                }
                Row {
                    Text(text = "Итог:")
                    Text(text = out)
                }
            }
//тут перчисляем все кнопки
            Row(horizontalArrangement = Arrangement.Center) {

                Text(
                    text = "1", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "1" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "2", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "2" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "3", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "3" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "+", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "+" }), textAlign = TextAlign.Center
                )
            }
            Row(horizontalArrangement = Arrangement.Center) {

                Text(
                    text = "4", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "4" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "5", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "5" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "6", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "6" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "-", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "-" }), textAlign = TextAlign.Center
                )
            }
            Row(horizontalArrangement = Arrangement.Center) {

                Text(
                    text = "7", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "7" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "8", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "8" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "9", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "9" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "/", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "/" }), textAlign = TextAlign.Center
                )
            }
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "AC", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = {
                            out = ""
                            input = ""
                        }), textAlign = TextAlign.Center
                )
                Text(
                    text = "0", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = { input += "0" }), textAlign = TextAlign.Center
                )
                Text(
                    text = "=", modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = {
                            //если результат будет равен результату с типом данных даббл
                            //то на выходе вывод переменную out с данными из longres с типом данных строка
                            //иначе выводим просто результат без форматирования
                            try {
                                //тут библиотека будет разбивать строку и считать все
                                val ex = ExpressionBuilder(input).build()
                                var res = ex.evaluate()
                                //укарачиваем если требуется выходной результат
                                var longres = res.toLong()
                                if (res == longres.toDouble()) {
                                    out = longres.toString()
                                } else {
                                    out = res.toString()
                                }
                            } catch (e: Exception) {
                                Log.d("Ошибка", "что-то введено неправильно")
                            }
                        }), textAlign = TextAlign.Center
                )
                Text(text = "*", modifier = Modifier
                    .weight(1f)
                    .clickable(onClick = { input += "*" }), textAlign = TextAlign.Center
                )
            }
        }
    }
}