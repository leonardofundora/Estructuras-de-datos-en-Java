### Ejercicio 1: Exploración de Sitios Históricos

**Situación**: Estás visitando un antiguo sitio histórico con muchas rutas y monumentos. Quieres explorar todos los monumentos y tomar la ruta más interesante.

**Tarea**: Utiliza DFS para recorrer todos los monumentos del sitio histórico, explorando cada ruta y visitando cada monumento una sola vez. Representa los monumentos como nodos y las rutas entre ellos como bordes en un grafo.

### Ejercicio 2: Resolución de Problemas de Sudoku

**Situación**: Estás resolviendo un Sudoku y necesitas explorar todas las posibles combinaciones de números para encontrar la solución correcta.

**Tarea**: Implementa DFS para probar todas las posibles combinaciones de números en el Sudoku, asegurándote de que cada número solo aparezca una vez en cada fila, columna y subcuadro. Utiliza el backtracking para deshacer movimientos cuando sea necesario.

### Ejercicio 3: Búsqueda de un Tesoro en una Isla

**Situación**: Te encuentras en una isla con un mapa antiguo que muestra rutas y ubicaciones de tesoros. Necesitas encontrar el tesoro siguiendo las rutas del mapa.

**Tarea**: Usa DFS para explorar todas las rutas en el mapa de la isla, buscando el tesoro. Representa la isla como un grafo donde los nodos son ubicaciones y los bordes son las rutas entre ellas.

### Ejercicio 4: Exploración de una Red de Túneles

**Situación**: Estás explorando una red de túneles en una mina y necesitas encontrar todas las salidas posibles sin repetir túneles.

**Tarea**: Implementa DFS para explorar todos los túneles de la mina, buscando todas las salidas posibles. Cada túnel se representa como un nodo y las conexiones entre túneles como bordes en un grafo.

### Ejercicio 5: Análisis de Conexiones en una Red de Computadoras

**Situación**: Necesitas identificar todos los dispositivos conectados en una red de computadoras, pero solo tienes acceso a ciertos dispositivos. Quieres descubrir todos los dispositivos que están conectados a través de otros dispositivos.

**Tarea**: Usa DFS para explorar todos los dispositivos conectados en la red, comenzando desde un dispositivo conocido. Representa la red como un grafo donde los nodos son dispositivos y los bordes son conexiones de red.




Para resolver el problema de Sudoku utilizando DFS con una pila en lugar de recursión, debemos implementar un enfoque iterativo que simule el comportamiento de la llamada recursiva de DFS. En este caso, usaremos una pila para manejar los estados de la búsqueda.

### Implementación en Java usando Pila

Aquí te muestro cómo resolver un Sudoku usando DFS con una pila:

```java
import java.util.*;

public class SudokuSolverWithStack {
    private static final int SIZE = 9; // Tamaño del Sudoku (9x9)
    private static final int SUBGRID_SIZE = 3; // Tamaño de las subcuadrículas (3x3)

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No se puede resolver el Sudoku.");
        }
    }

    // Función para resolver el Sudoku
    private static boolean solveSudoku(int[][] board) {
        Stack<Move> stack = new Stack<>();
        if (fillEmptyCells(board, stack)) {
            return true;
        }
        return false;
    }

    // Función para rellenar las celdas vacías usando DFS con pila
    private static boolean fillEmptyCells(int[][] board, Stack<Move> stack) {
        int row = 0, col = 0;
        boolean foundEmpty = false;

        // Encuentra la primera celda vacía
        for (row = 0; row < SIZE; row++) {
            for (col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    foundEmpty = true;
                    break;
                }
            }
            if (foundEmpty) break;
        }

        // Si no hay celdas vacías, el Sudoku está resuelto
        if (!foundEmpty) return true;

        // Probar todos los números del 1 al 9
        for (int num = 1; num <= SIZE; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;
                stack.push(new Move(row, col, num));
                if (fillEmptyCells(board, stack)) {
                    return true;
                }
                // Retroceder
                stack.pop();
                board[row][col] = 0;
            }
        }

        return false;
    }

    // Función para verificar si el número es válido en la celda
    private static boolean isValid(int[][] board, int row, int col, int num) {
        // Verificar fila
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) return false;
        }

        // Verificar columna
        for (int x = 0; x < SIZE; x++) {
            if (board[x][col] == num) return false;
        }

        // Verificar subcuadro 3x3
        int startRow = row - row % SUBGRID_SIZE;
        int startCol = col - col % SUBGRID_SIZE;
        for (int i = 0; i < SUBGRID_SIZE; i++) {
            for (int j = 0; j < SUBGRID_SIZE; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }

        return true;
    }

    // Función para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.print("\n");

            if ((r + 1) % SUBGRID_SIZE == 0) {
                System.out.print("");
            }
        }
    }

    // Clase para representar un movimiento en el tablero
    static class Move {
        int row, col, num;

        Move(int row, int col, int num) {
            this.row = row;
            this.col = col;
            this.num = num;
        }
    }
}
```

### Explicación del Código:

1. **Estructura del Tablero**:
   - `board` es una matriz que representa el Sudoku. Los `0` representan celdas vacías.

2. **Función `solveSudoku`**:
   - Crea una pila para almacenar los movimientos y llama a `fillEmptyCells` para comenzar el proceso de llenado.

3. **Función `fillEmptyCells`**:
   - Busca la primera celda vacía en el tablero.
   - Para cada número del 1 al 9, verifica si es válido en la celda actual usando `isValid`.
   - Si es válido, coloca el número en la celda, guarda el movimiento en la pila, y llama recursivamente a `fillEmptyCells`.
   - Si no se puede completar el Sudoku, retrocede eliminando el último movimiento y probando el siguiente número.

4. **Función `isValid`**:
   - Verifica si el número no se repite en la fila, columna y subcuadro 3x3.

5. **Función `printBoard`**:
   - Imprime el tablero en formato de Sudoku.

6. **Clase `Move`**:
   - Representa un movimiento en el tablero con la fila, columna y número.

Este código utiliza una pila para realizar la búsqueda en profundidad de manera iterativa, simulando el comportamiento recursivo de DFS y permitiendo el retroceso (backtracking) cuando se encuentran problemas.