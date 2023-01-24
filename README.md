CookMobile DOCUMENTATION

Paso a paso y razonamiento de proyecto:
1. La arquitectura del proyecto sera MODELO VISTA PRESENTADOR
2. La arquitectura va a tener view, presenter e interfaces, el view solo se encargara de mostrar y pintar los elementos en los layouts y los presentadores tendran la logica y algoritmos de procesamiento de datos. Principio SOLID.
3. Agregué dimensiones estandar para que escale correctamente en diferentes pantallas usando el archivo dimens.xml
4. Luego, creé el view para lista de recetas y utilice un adapter para pintar cada row de la lista(imagen y nombre)5. Existe un base activity del cual van a extender todas las activities del proyecto, esto con el fin de reutilizarfunciones generales como mostrar toast, mensajes o loading views.
6. Creación del modelo recipe con sus respectivos atributos dentro del paquete model
7. Añadida la libreria okinteractor para realizar la conexion y peticiones http al api de pruebas
8. Ahora creamos la funcion get recipes en el presentador que posterior enviara la lista a la vista para mostrarla en el layout usando un adapter para la lista.
9. Añadidos permisos de network en el manifest.
10. Añadimos libreria picasso para mostrar las imagenes directamente de una url externa.
11. Ahora creamos la vista de detalle de receta y creamos la logica para enviar la receta usando intent desde la lista de recetas, enviamos el json como extra y en la vista de detalle interpretamos el json y pintamos la infomarcion. Tambien se agrega el boton de ubicación.
12. Se añade el sdk de google maps y con esto añadimos el activity de mapa que recibe la longitud y la latitud desde el detail de la receta, luego se interpreta y se crea el marker en el mapa.
13. Añadido buscador de recetas en la vista de lista de recetas, busca coincidencias por el nombre de receta y vuelve y pinta el recycler view.
14. Añadido librerias test con expresso, añadidas pruebas para intents en lista de recetas y detalle de receta.
15. Añadidas pruebas para textfield y button en lista de recetas y detalle de recetas, valindando coninicidencia de labels y click en el boton ubicación.
16. Añadido test para adapter de lista de recetas, validacion de que la lista tenga item, click de una posicion exacta y si es reciclable el adapter.
17. Añadida libreria de automator para crear prueba de marcador clickeable del mapa de recetas.
18. Añadidos colores para version nocturna, mejoras de visualizacion la lista de recetas, añadidos nuevos shapes para configurar backgrounds con border.
19. Añadidos estilos para vista de detalle de receta y tambien nuevo fondo con bordes redondos para boton de ubicacion.
20. Añadido json con recetas en el directorio del proyecto.

NOTAS:
En el directorio de la aplicación se encuentra un archivo recipes.json donde esta la informacion de las recetas. Actualmente se encuentra funcionando con una url remota en mockable.io
