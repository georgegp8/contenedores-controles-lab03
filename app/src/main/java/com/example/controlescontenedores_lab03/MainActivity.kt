package com.example.controlescontenedores_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.*
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Popup
import com.example.controlescontenedores_lab03.ui.theme.ControlesContenedoreslab03Theme
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.FlowColumn
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ControlesContenedoreslab03Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        //LazyColumnDemo()
                        //LazyRowDemo()
                        //GridDemo()
                        //ConstraintLayoutDemo()
                        //ScaffoldDemo()
                        //SurfaceDemo()
                        //ChipDemo()
                        //BackdropScaffold es obsoleto
                        //FlowRowDemo()
                        //FlowColumnDemo()
                        //AlertDialogDemo()
                        //CardDemo()
                        //CheckboxDemo()
                        //FloatingButtonExample(onClick = { /* Acción */ })
                        //IconDemo()
                        //ImageDemo()
                        //ProgressBarDemo()
                        //RadioButtonDemo()
                        //SliderDemo()
                        //SpacerDemo()
                        //SwitchDemo()
                        //TopAppBarDemo()
                        //BottomNavigationDemo()
                        //DialogDemo()
                        //DividerDemo()
                        //DropDownMenuDemo()
                        //NavigationRailDemo()
                        //OutlinedTextFieldDemo()
                        //SnackbarDemo()
                        //TabRowDemo()
                        TooltipDemo()
                    }
                }

            }
        }
    }
}

@Composable
fun LazyColumnDemo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
    ) {
        items(10) { index ->
            Text(
                text = "Elemento $index",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun LazyRowDemo() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
    ) {
        items(3) { index ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .width(100.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFB3E5FC))
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("Item $index", modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun GridDemo() {
    val elementos = (1..10).map { "Elemento $it" }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(elementos) { item ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFC8E6C9))
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                ) {
                    Text(item)
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutDemo() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        // Referencias
        val (titulo, boton1, boton2) = createRefs()

        Text(
            text = "Hola desde ConstraintLayout",
            modifier = Modifier.constrainAs(titulo) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Button(
            onClick = { /* Acción */ },
            modifier = Modifier.constrainAs(boton1) {
                top.linkTo(titulo.bottom, margin = 16.dp)
                start.linkTo(parent.start)
            }
        ) {
            Text("Botón 1")
        }

        Button(
            onClick = { /* Acción */ },
            modifier = Modifier.constrainAs(boton2) {
                top.linkTo(titulo.bottom, margin = 16.dp)
                end.linkTo(parent.end)
            }
        ) {
            Text("Botón 2")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemo() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Scaffold Demo") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Favorite, contentDescription = "FAB")
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = Color(0xFFF0F4C3) // Fondo claro (limón suave)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Este es el contenido del cuerpo")
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {}) {
                    Text("Botón dentro del Scaffold")
                }
            }
        }
    }
}

@Composable
fun SurfaceDemo() {
    Surface(
        color = Color(0xFFD1C4E9), // Fondo lavanda suave
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Componente Surface", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Sirve como fondo con sombra y color.")
        }
    }
}

@Composable
fun ChipDemo() {
    var selected by remember { mutableStateOf(false) }

    AssistChip(
        onClick = { selected = !selected },
        label = { Text(if (selected) "Seleccionado" else "Haz clic") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "icono"
            )
        },
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun FlowRowDemo() {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        repeat(12) { index ->
            Button(
                onClick = { },
                modifier = Modifier.width(100.dp)
            ) {
                Text("Btn $index")
            }
        }
    }
}

@Composable
fun FlowColumnDemo() {
    FlowColumn(
        modifier = Modifier
            .wrapContentHeight()
            .padding(16.dp),
        mainAxisSpacing = 8.dp,
        crossAxisSpacing = 8.dp
    ) {
        repeat(4) { index ->
            OutlinedButton(
                onClick = { },
                modifier = Modifier.height(50.dp)
            ) {
                Text("Elemento $index")
            }
        }
    }
}

@Composable
fun AlertDialogDemo() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar AlertDialog")
        }

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text("Título del diálogo") },
                text = { Text("¿Deseas continuar con la acción?") },
                confirmButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Aceptar")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancelar")
                    }
                }
            )
        }
    }
}

@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD)) // Azul claro
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Título de la Card", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Esta es una tarjeta que contiene texto y se puede estilizar fácilmente.")
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {}) {
                Text("Acción")
            }
        }
    }
}

@Composable
fun CheckboxDemo() {
    var isChecked by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = if (isChecked) "Seleccionado" else "No seleccionado")
    }
}

@Composable
fun FloatingButtonExample(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.small
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Botón de acción principal"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFloatingButtonExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp),
        contentAlignment = Alignment.BottomEnd
    ) {
        FloatingButtonExample(onClick = { /* Acción simulada */ })
    }
}

@Composable
fun IconDemo() {
    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Estrella",
            tint = Color(0xFFFFC107), // color ámbar
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text("Ícono de estrella", fontSize = 18.sp)
    }
}

@Composable
fun ImageDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Imagen de ejemplo", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Imagen predeterminada",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Composable
fun ProgressBarDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Cargando (Linear)", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))

        Text("Cargando (Circular)", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        CircularProgressIndicator()
    }
}

@Composable
fun RadioButtonDemo() {
    var selectedOption by remember { mutableStateOf("Opción 1") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Seleccione una opción:", fontSize = 18.sp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "Opción 1",
                onClick = { selectedOption = "Opción 1" }
            )
            Text("Opción 1")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "Opción 2",
                onClick = { selectedOption = "Opción 2" }
            )
            Text("Opción 2")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Seleccionado: $selectedOption", fontSize = 16.sp)
    }
}

@Composable
fun SliderDemo() {
    var sliderValue by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Ajustar valor:", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = sliderValue,
            onValueChange = { sliderValue = it },
            valueRange = 0f..100f
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Valor actual: ${sliderValue.toInt()}")
    }
}

@Composable
fun SpacerDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Texto superior", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(32.dp)) // Espacio vertical

        Text("Texto inferior", fontSize = 18.sp)
    }
}

@Composable
fun SwitchDemo() {
    var isSwitchOn by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = isSwitchOn,
            onCheckedChange = { isSwitchOn = it }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(if (isSwitchOn) "Encendido" else "Apagado", fontSize = 18.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDemo() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Mi AppBar") },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menú")
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Settings, contentDescription = "Ajustes")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Contenido debajo de la AppBar")
        }
    }
}

@Composable
fun BottomNavigationDemo() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Inicio", "Buscar", "Perfil")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Blue,
                            selectedTextColor = Color.Blue
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Pantalla: ${items[selectedItem]}", fontSize = 18.sp)
        }
    }
}

@Composable
fun DialogDemo() {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Mostrar Dialog personalizado")
        }

        if (showDialog) {
            Dialog(onDismissRequest = { showDialog = false }) {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    color = Color.White,
                    tonalElevation = 8.dp,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(24.dp)
                            .width(IntrinsicSize.Min),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Este es un diálogo personalizado", fontSize = 18.sp)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { showDialog = false }) {
                            Text("Cerrar")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DividerDemo() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Elemento superior", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Divider(
            color = Color.Gray,
            thickness = 2.dp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Elemento inferior", fontSize = 18.sp)
    }
}

@Composable
fun DropDownMenuDemo() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Selecciona una opción") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = selectedOption, fontSize = 18.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { expanded = true }) {
            Text("Abrir menú")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Opción 1") },
                onClick = {
                    selectedOption = "Opción 1"
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Opción 2") },
                onClick = {
                    selectedOption = "Opción 2"
                    expanded = false
                }
            )
        }
    }
}

@Composable
fun NavigationRailDemo() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Inicio", "Buscar", "Perfil")
    val icons = listOf(Icons.Default.Home, Icons.Default.Search, Icons.Default.Person)

    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        NavigationRail {
            items.forEachIndexed { index, label ->
                NavigationRailItem(
                    selected = selectedItem == index,
                    onClick = { selectedItem = index },
                    icon = { Icon(icons[index], contentDescription = label) }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text("Sección: ${items[selectedItem]}", fontSize = 18.sp)
        }
    }
}

@Composable
fun OutlinedTextFieldDemo() {
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text("Ingresa tu nombre:", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Nombre") },
            placeholder = { Text("Escribe aquí...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Texto ingresado: $text")
    }
}

@Composable
fun SnackbarDemo() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("¡Hola! Este es un Snackbar.")
                }
            }) {
                Text("Mostrar Snackbar")
            }
        }
    }
}

@Composable
fun TabRowDemo() {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabs = listOf("Inicio", "Perfil", "Ajustes")

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Contenido: ${tabs[selectedTabIndex]}", fontSize = 18.sp)
        }
    }
}

@Composable
fun TooltipDemo() {
    var showTooltip by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = { showTooltip = !showTooltip }) {
            Icon(Icons.Default.Info, contentDescription = "Info")
        }

        if (showTooltip) {
            Popup(alignment = Alignment.TopCenter, onDismissRequest = { showTooltip = false }) {
                Surface(
                    shape = MaterialTheme.shapes.small,
                    color = Color(0xFF323232),
                    tonalElevation = 4.dp
                ) {
                    Text(
                        text = "Este es un tooltip",
                        color = Color.White,
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTooltipDemo() {
    TooltipDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewTabRowDemo() {
    TabRowDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewSnackbarDemo() {
    SnackbarDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedTextFieldDemo() {
    OutlinedTextFieldDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewNavigationRailDemo() {
    NavigationRailDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewDropDownMenuDemo() {
    DropDownMenuDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewDividerDemo() {
    DividerDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewDialogDemo() {
    DialogDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewBottomNavigationDemo() {
    BottomNavigationDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarDemo() {
    TopAppBarDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewSwitchDemo() {
    SwitchDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewSpacerDemo() {
    SpacerDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewSliderDemo() {
    SliderDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewRadioButtonDemo() {
    RadioButtonDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewProgressBarDemo() {
    ProgressBarDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewImageDemo() {
    ImageDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewIconDemo() {
    IconDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckboxDemo() {
    CheckboxDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewCardDemo() {
    CardDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewAlertDialogDemo() {
    AlertDialogDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewFlowColumnDemo() {
    FlowColumnDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewFlowRowDemo() {
    FlowRowDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewChipDemo() {
    ChipDemo()
}


@Preview(showBackground = true)
@Composable
fun PreviewSurfaceDemo() {
    SurfaceDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewScaffoldDemo() {
    ScaffoldDemo()
}



@Preview(showBackground = true)
@Composable
fun PreviewConstraintLayoutDemo() {
    ConstraintLayoutDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewGridDemo() {
    GridDemo()
}


@Preview(showBackground = true)
@Composable
fun PreviewLazyRowDemo() {
    LazyRowDemo()
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyColumnDemo() {
    LazyColumnDemo()
}

