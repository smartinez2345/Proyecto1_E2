# Proyecto1_Entrega2
# Proyecto 1 - Entrega 2: Board Game Cafe

## Integrantes
- Santiago Martinez Chacon 202511078
- Daniel nino -202325515 
- Santiago Bobadilla - 202324703


## Estructura del proyecto

- `src/modelo/`  Clases del modelo de dominio.
- `src/logica/`  Gestores con la logica de negocio.
- `src/presentacion/`  Programas de prueba que demuestran cada funcionalidad.
- `src/persistencia/`  Clases para serializacion y exportacion de datos.
- `data/`  Carpeta que contiene archivos de persistencia y datos iniciales.
- `doc/`  Documento de diseno y diagramas.

## Requisitos

- Java JDK 8 o superior.
- Eclipse IDE (opcional, pero recomendado para ejecutar las pruebas).

## Configuracion inicial en Eclipse

1. Importar el proyecto: **File > Import > Existing Projects into Workspace**.
2. Seleccionar la carpeta `Entrega 2`.
3. Verificar que la carpeta `data` existe en la raiz del proyecto. Si no se ve, hacer clic derecho sobre el proyecto y seleccionar **Refresh**.
4. Dentro de `data` deben estar los archivos:
   - `cafe_inicial.dat` (estado binario del sistema)
   - `cafe_inicial.txt` (reporte legible con todos los datos iniciales)

## Datos de prueba incluidos

Se proporcionan datos iniciales completos para probar el sistema sin necesidad de cargar nada manualmente:

- 3 clientes, 3 empleados (1 cocinero, 2 meseros).
- Juegos en inventario: Catan, Uno, Twister, Ajedrez.
- Productos de cafeteria: Cafe Americano, Cerveza Artesanal, Brownie.
- Una mesa ocupada con un prestamo activo.
- Ventas registradas de cafeteria y juegos.
- Una solicitud de cambio de turno aprobada.

Para cargar estos datos en cualquier prueba, use el metodo `Cafe.cargarEstado("data/cafe_inicial.dat")`.

## Ejecucion de las pruebas

Cada clase dentro del paquete `presentacion` contiene un metodo `main` que demuestra una funcionalidad especifica. Para ejecutar una prueba en Eclipse:

1. Expandir `src/presentacion`.
2. Clic derecho sobre la clase deseada (ej. `PruebaMesa`).
3. Seleccionar **Run As > Java Application**.

### Orden sugerido de ejecucion

| Prueba | Descripcion |
|--------|-------------|
| `GenerarDatosIniciales` | (Opcional) Regenera los archivos de datos en `data/`. |
| `PruebaMesa` | Registro de clientes y creacion de mesas. |
| `PruebaPrestamo` | Prestamo de juegos con validaciones. |
| `PruebaVentaCafeteria` | Ventas de cafeteria con restricciones. |
| `PruebaCompraJuegos` | Venta de juegos, descuentos y puntos de fidelidad. |
| `PruebaInventario` | Gestion de inventario y turnos de empleados. |
| `PruebaPersistencia` | Guardado y carga del estado del cafe. |
| `PruebaInformes` | Informes de ventas (diario, semanal, mensual). **Carga automaticamente los datos iniciales.** |
| `PruebaPrestamoEmpleado` | Prestamo de juegos a empleados fuera de turno. |

## Notas importantes

- Todas las pruebas son autonomas y no requieren entrada del usuario.
- El archivo `cafe_inicial.txt` contiene un volcado completo del estado inicial en formato legible. Puede abrirlo con cualquier editor de texto para verificar los datos sin ejecutar el programa.
- La carpeta `data/` debe tener permisos de escritura para que las pruebas de persistencia funcionen correctamente.
- En caso de error de compilacion, limpiar el proyecto: **Project > Clean**.

## Contacto

Para cualquier consulta sobre esta entrega, comunicarse con los integrantes del grupo.
