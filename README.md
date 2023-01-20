CookMobile DOCUMENTATION

Paso a paso y razonamiento de proyecto:
1. La arquitectura del proyecto sera MODELO VISTA PRESENTADOR
2. La arquitectura va a tener view, presenter e interfaces, el view solo se encargara de mostrar y pintar los elementos en los layouts y los presentadores tendran la logica y algoritmos de procesamiento de datos.
3. Agregué dimensiones estandar para que escale correctamente en diferentes pantallas usando el archivo dimens.xml
4. Luego, creé el view para lista de recetas y utilice un adapter para pintar cada row de la lista(imagen y nombre)5. Existe un base activity del cual van a extender todas las activities del proyecto, esto con el fin de reutilizarfunciones generales como mostrar toast, mensajes o loading views.
6. Creación del modelo recipe con sus respectivos atributos dentro del paquete model
7. Añadida la libreria okinteractor para realizar la conexion y peticiones http al api de pruebas
8. Ahora creamos la funcion get recipes en el presentador que posterior enviara la lista a la vista para mostrarla en el layout usando un adapter para la lista.
9. Añadidos permisos de network en el manifest.
10. Añadimos libreria picasso para mostrar las imagenes directamente de una url externa.
11. Ahora creamos la vista de detalle de receta y creamos la logica para enviar la receta usando intent desde la lista de recetas, enviamos el json como extra y en la vista de detalle interpretamos el json y pintamos la infomarcion.
