/*
package com.example.navapp2.ui.auth.screens

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun signUpScreen(){




    var isOpenPopUp by remember {
        mutableStateOf(false)
    }

    val dendity = LocalContext.current.resources.displayMetrics.density

    var dropDownOffset : DpOffset by remember {
        mutableStateOf( DpOffset(x=0.dp, y=0.dp))
    }
    var dropDownOffset2 : DpOffset by remember {
        mutableStateOf( DpOffset(x=0.dp, y=0.dp))
    }

    var textFieldValue : String by remember {
        mutableStateOf("")
    }




    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(20.dp)) {
        OutlinedTextField(
            value = "Hello Bro",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
        Box(modifier = Modifier
            .padding(top = 15.dp)
            .fillMaxWidth()
            .clickable {
                isOpenPopUp = !isOpenPopUp
            }
            .pointerInput(Unit) {
                detectTapGestures {
                    Log.d("dovkfmvfk", it.x.toString() + " tapgesture x")
                    Log.d("dovkfmvfk", it.y.toString() + " tapgesture y")
                }
            }
            .onSizeChanged {

            }
            .onGloballyPositioned {

                //  Log.d("fvmkfvkf",it.positionInParent().y.toString() + " globallyPositined")
            }
            .onPlaced {
                dropDownOffset = DpOffset(it.positionInParent().x.dp, it.positionInParent().y.dp)
                Log.d("fvmkfvkf", it.positionInParent().y.toString() + " positionInParent")
                Log.d("fvmkfvkf", it.positionInWindow().y.toString() + " positionInWindow")
                Log.d("fvmkfvkf", it.positionInRoot().y.toString() + " positionInRoot")
                Log.d(
                    "fvmkfvkf",
                    it.parentCoordinates?.positionInRoot()?.y.toString() + " parentCoordinates?.positionInRoot("
                )
                Log.d(
                    "fvmkfvkf",
                    it.parentCoordinates?.positionInWindow()?.y.toString() + " parentCoordinates?.positionInWindow("
                )
                Log.d(
                    "fvmkfvkf",
                    it.parentCoordinates?.positionInParent()?.y.toString() + " parentCoordinates?.positionInParent("
                )
                Log.d(
                    "fvmkfvkf",
                    it
                        .boundsInParent()
                        .toString() + " boundsInParent"
                )
                Log.d(
                    "fvmkfvkf",
                    it.findRootCoordinates().parentCoordinates?.toString() + " findRootCoordinates().parentCoordinates?"
                )
                Log.d(
                    "fvmkfvkf",
                    it
                        .findRootCoordinates()
                        .boundsInParent()
                        .toString() + " findRootCoordinates?.boundsInParent("
                )

            }
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(listOf(Color.Red, Color.White)),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)) {
            Text(text = "Stroked Box Text", color = Color.White)
        }

        DropdownMenu(
            expanded = isOpenPopUp,
            offset = DpOffset(0.dp, dropDownOffset.y),
            onDismissRequest = { isOpenPopUp = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Blue,
                            Color.DarkGray
                        ), tileMode = TileMode.Mirror
                    )
                )
        ) {
            Text(text = "Hello bro", style = TextStyle(brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Cyan))))
            Text(text = "Hello bro", style = TextStyle(brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Cyan))))
            Text(text = "Hello bro", style = TextStyle(brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Cyan))))
            Text(text = "Hello bro", style = TextStyle(brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Cyan))))
            Text(text = "Hello bro", style = TextStyle(brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Cyan))))
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                isOpenPopUp = !isOpenPopUp
            }
            .onPlaced {
                //  dropDownOffset = DpOffset(it.positionInParent().x.dp,it.positionInParent().y.dp)
//                Log.d("fvmkfvkf",it.positionInParent().y.toString() + " Placed")
            }
            .border(
                width = 1.dp,
                brush = Brush.linearGradient(listOf(Color.Red, Color.Blue)),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(20.dp)) {
            TextField(value = "Stroke Value 2", onValueChange = {})
        }

        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .border(2.dp, Color.Blue, CircleShape)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "",
                modifier = Modifier
                    .background(shape = CircleShape, color = Color.Red)
                    .border(width = 5.dp, color = Color.White, shape = CircleShape)
                    .padding(5.dp)
                    .clip(CircleShape)
            )
        }

        OutlinedTextField(
            value = textFieldValue,
            onValueChange = { textFieldValue = it },
            shape = RoundedCornerShape(20.dp),
            leadingIcon = {Icon(imageVector = Icons.Default.Build, contentDescription = "")},
            trailingIcon = {Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")},
            placeholder = { Text(text = "Outline TextField 3")},
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.Black),
            modifier = Modifier.border(2.dp, color = Color.Green, shape = RoundedCornerShape(20.dp))
            )

        SharedTransitionLayout() {

        }
    }

}*/
