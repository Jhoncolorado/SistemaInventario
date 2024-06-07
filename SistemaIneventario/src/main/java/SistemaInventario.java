import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaInventario {

    private static final Map<String, Producto> inventario = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProductoPorNombre();
                    break;
                case 3:
                    actualizarCantidadProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    mostrarInventario();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n\n*Menú Sistema de Inventario*");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar Producto por nombre");
        System.out.println("3. Actualizar cantidad de producto");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Mostrar inventario");
        System.out.println("6. Salir");
        System.out.print("Seleccione la opción deseada: ");
    }

    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (inventario.containsKey(nombreProducto)) {
            System.out.println("El producto ya existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la cantidad inicial: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        inventario.put(nombreProducto, new Producto(nombreProducto, cantidad));
        System.out.println("Producto agregado exitosamente.");
    }

    private static void buscarProductoPorNombre() {
        System.out.print("Ingrese el nombre del producto a buscar: ");
        String nombreProducto = scanner.nextLine();

        Producto producto = inventario.get(nombreProducto);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println(" Nombre: " + producto.getNombre());
            System.out.println(" Cantidad: " + producto.getCantidad());
        } else {
            System.out.println("El producto no existe en el inventario.");
        }
    }

    private static void actualizarCantidadProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombreProducto = scanner.nextLine();

        if (!inventario.containsKey(nombreProducto)) {
            System.out.println("El producto no existe en el inventario.");
            return;
        }

        System.out.print("Ingrese la nueva cantidad: ");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea

        inventario.get(nombreProducto).setCantidad(nuevaCantidad);
        System.out.println("Cantidad del producto actualizada exitosamente.");
    }

    private static void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreProducto = scanner.nextLine();

        if (!inventario.containsKey(nombreProducto)) {
            System.out.println("El producto no existe en el inventario.");
            return;
        }

        inventario.remove(nombreProducto);
        System.out.println("Producto eliminado exitosamente.");
    };

    