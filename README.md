# Proyecto1_Entrega2
# Proyecto 1 - Entrega 2: Board Game Cafe

## Integrantes
- Santiago Martinez Chacon 202511078
- Daniel nino -202325515 
- Santiago Bobadilla - 202324703


## Estructura del proyecto

- `src/modelo/`  Clases del modelo.
- `src/logica/`  Logica de negocio (gestores).
- `src/presentacion/`  Programas de prueba ejecutables.
- `src/persistencia/`  Serializacion de datos.
- `data/`  Almacenamiento de archivos de persistencia (se crea automaticamente).
- `doc/`  Documento de diseno y diagramas.

## Como ejecutar las pruebas en Eclipse

1. Importar el proyecto en Eclipse: **File  Import  Existing Projects into Workspace**.
2. Seleccionar la carpeta `Entrega 2`.
3. Asegurarse de que la carpeta `data` existe en la raiz del proyecto. Si no, crearla: clic derecho sobre el proyecto  **New  Folder**  nombre `data`.
4. Abrir el paquete `presentacion`.
5. Para cada clase de prueba, hacer clic derecho  **Run As  Java Application**.

## Orden sugerido para ejecutar las pruebas

Se recomienda ejecutarlas en este orden para ver la progresion de funcionalidades:

1. `PruebaMesa`  Registro de clientes y asignacion de mesas.
2. `PruebaPrestamo`  Prestamo de juegos con validaciones.
3. `PruebaVentaCafeteria`  Ventas de cafeteria con restricciones.
4. `PruebaCompraJuegos`  Venta de juegos, descuentos y puntos.
5. `PruebaInventario`  Gestion de inventario de juegos y turnos.
6. `PruebaPersistencia`  Guardado y carga del estado del cafe.
7. `PruebaInformes`  Informes de ventas diarios, semanales y mensuales.
8. `PruebaPrestamoEmpleado`  Prestamo de juegos a empleados fuera de turno.

## Notas importantes

- Las pruebas son autonomas y no requieren entrada del usuario.
- La persistencia genera un archivo `cafe.dat` dentro de la carpeta `data`. Asegurese de que el programa tenga permisos de escritura en esa carpeta.
- Para probar la carga de datos, ejecute `PruebaPersistencia` primero (guarda datos) y luego vuelva a ejecutarla (carga los datos guardados).
- Todos los usuarios de prueba tienen login/password definidos en el codigo (ej. `admin/admin123`).