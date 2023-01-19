CookMobile DOCUMENTATION

Paso a paso y razonamiento de proyecto:
1. La arquitectura del proyecto sera MODELO VISTA PRESENTADOR
2. La arquitectura va a tener view, presenter e interfaces, el view solo se encargara de mostrar y pintar los elementos en los layouts y los presentadores tendran la logica y algoritmos de procesamiento de datos.
3. Agregué dimensiones estandar para que escale correctamente en diferentes pantallas usando el archivo dimens.xml
4. Luego, creé el view para lista de recetas y utilice un adapter para pintar cada row de la lista(imagen y nombre)5. Existe un base activity del cual van a extender todas las activities del proyecto, esto con el fin de reutilizarfunciones generales como mostrar toast, mensajes o loading views.
6. Creación del modelo recipe con sus respectivos atributos dentro del paquete model
