BFS (Breadth-First Search) es un algoritmo de búsqueda en grafos que explora los nodos de un grafo por niveles. Es decir, primero visita todos los nodos vecinos al nodo de partida, luego los vecinos de esos vecinos, y así sucesivamente. Es útil para encontrar la ruta más corta en grafos no ponderados y para explorar todos los nodos en un grafo.

### Características de BFS:
- Explora el grafo por niveles.
- Usa una cola (FIFO) para llevar el control de los nodos a visitar.
- Marca los nodos visitados para evitar ciclos e iteraciones innecesarias.
- Es adecuado para grafos no ponderados para encontrar la ruta más corta desde un nodo fuente a cualquier otro nodo.

### Pasos para implementar BFS:
1. **Inicialización**: 
   - Se coloca el nodo de partida en la cola.
   - Se marca el nodo de partida como visitado.
2. **Exploración**:
   - Mientras la cola no esté vacía:
     - Se extrae un nodo de la cola.
     - Para cada nodo adyacente no visitado:
       - Se marca como visitado.
       - Se añade a la cola.

### Implementación en Java usando Lista de Adyacencia:

```java
import java.util.*;

public class BFS {
    private int vertices; // Número de vértices en el grafo
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    // Constructor
    BFS(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Función para agregar un borde al grafo
    void addEdge(int v, int w) {
        adj[v].add(w); // Agrega w a la lista de v
    }

    // Función para realizar BFS desde un vértice fuente
    void BFS(int s) {
        // Marca todos los vértices como no visitados
        boolean visited[] = new boolean[vertices];

        // Crea una cola para BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Marca el nodo actual como visitado y lo agrega a la cola
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Saca un vértice de la cola y lo procesa
            s = queue.poll();
            System.out.print(s + " ");

            // Obtiene todos los vértices adyacentes del vértice s
            // Si un adyacente no ha sido visitado, se marca como visitado y se pone en la cola
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        BFS g = new BFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS comenzando desde el vértice 2:");

        g.BFS(2);
    }
}
```

### Explicación del Código:
1. **Estructura del Grafo**: 
   - `vertices` define el número de vértices en el grafo.
   - `adj` es un array de listas enlazadas que representa la lista de adyacencia.
   
2. **Inicialización**: 
   - En el constructor, se inicializan las listas de adyacencia para cada vértice.
   
3. **Agregar Bordes**: 
   - `addEdge` agrega un borde entre dos nodos en el grafo.
   
4. **BFS**:
   - Se marca el nodo fuente como visitado.
   - Se usa una cola para gestionar el proceso de BFS.
   - Se procesan todos los nodos adyacentes de cada nodo extraído de la cola, marcando los no visitados y agregándolos a la cola.

5. **Método Principal**:
   - Se crea un grafo con 4 vértices y se agregan algunos bordes.
   - Se llama al método `BFS` con el vértice 2 como el nodo de partida.

DFS (Depth-First Search) es un algoritmo de búsqueda en grafos que explora lo más profundo posible a lo largo de cada rama antes de retroceder. Es útil para tareas como la detección de ciclos, la verificación de conectividad, y para problemas de recorridos exhaustivos como el backtracking.

### Características de DFS:
- Explora el grafo profundizando lo más que pueda antes de retroceder.
- Usa una pila (puede ser implícita en el caso de recursión) para llevar el control de los nodos a visitar.
- Marca los nodos visitados para evitar ciclos e iteraciones innecesarias.
- Puede ser implementado de forma recursiva o iterativa.

### Pasos para implementar DFS:
1. **Inicialización**:
   - Se marca el nodo de partida como visitado.
   - Se llama recursivamente a la función DFS para cada nodo adyacente no visitado.
   
### Implementación en Java usando Lista de Adyacencia (Recursiva):

```java
import java.util.*;

public class DFS {
    private int vertices; // Número de vértices en el grafo
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    // Constructor
    DFS(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Función para agregar un borde al grafo
    void addEdge(int v, int w) {
        adj[v].add(w); // Agrega w a la lista de v
    }

    // Función para realizar DFS desde un vértice fuente
    void DFSUtil(int v, boolean visited[]) {
        // Marca el nodo actual como visitado y lo imprime
        visited[v] = true;
        System.out.print(v + " ");

        // Recurre para todos los vértices adyacentes a este vértice
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Función DFS principal que utiliza DFSUtil()
    void DFS(int v) {
        // Marca todos los vértices como no visitados (inicialmente)
        boolean visited[] = new boolean[vertices];

        // Llama a la función recursiva de utilidad DFSUtil() para recorrer el grafo
        DFSUtil(v, visited);
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS comenzando desde el vértice 2:");

        g.DFS(2);
    }
}
```

### Explicación del Código:
1. **Estructura del Grafo**:
   - `vertices` define el número de vértices en el grafo.
   - `adj` es un array de listas enlazadas que representa la lista de adyacencia.
   
2. **Inicialización**:
   - En el constructor, se inicializan las listas de adyacencia para cada vértice.
   
3. **Agregar Bordes**:
   - `addEdge` agrega un borde entre dos nodos en el grafo.
   
4. **DFS**:
   - `DFSUtil` es la función recursiva que realiza el recorrido DFS:
     - Marca el nodo actual como visitado.
     - Llama recursivamente a sí misma para cada nodo adyacente no visitado.
   - `DFS` es la función principal que inicializa el arreglo de nodos visitados y llama a `DFSUtil`.
   
5. **Método Principal**:
   - Se crea un grafo con 4 vértices y se agregan algunos bordes.
   - Se llama al método `DFS` con el vértice 2 como el nodo de partida.

Esta implementación de DFS recursiva es simple y eficiente para grafos de tamaño moderado. En situaciones donde el grafo es muy profundo y podría causar un desbordamiento de pila, una implementación iterativa de DFS usando una pila explícita sería más adecuada.

### Implementación de DFS Iterativa en Java usando Lista de Adyacencia y una Pila

Para implementar DFS de forma iterativa, se utiliza una pila explícita en lugar de la recursión. Este enfoque es útil para evitar problemas de desbordamiento de pila en grafos muy profundos.

### Implementación en Java:

```java
import java.util.*;

public class DFSIterative {
    private int vertices; // Número de vértices en el grafo
    private LinkedList<Integer> adj[]; // Lista de adyacencia

    // Constructor
    DFSIterative(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    // Función para agregar un borde al grafo
    void addEdge(int v, int w) {
        adj[v].add(w); // Agrega w a la lista de v
    }

    // Función para realizar DFS iterativa desde un vértice fuente
    void DFS(int s) {
        // Marca todos los vértices como no visitados (inicialmente)
        boolean visited[] = new boolean[vertices];

        // Crea una pila para DFS
        Stack<Integer> stack = new Stack<>();

        // Empuja el nodo fuente a la pila
        stack.push(s);

        while (!stack.empty()) {
            // Saca un vértice de la pila
            s = stack.pop();

            // Si el vértice no ha sido visitado, márquelo y procese
            if (!visited[s]) {
                System.out.print(s + " ");
                visited[s] = true;
            }

            // Obtiene todos los vértices adyacentes al vértice s
            // Si un adyacente no ha sido visitado, se pone en la pila
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        DFSIterative g = new DFSIterative(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("DFS iterativa comenzando desde el vértice 2:");

        g.DFS(2);
    }
}
```

### Explicación del Código:
1. **Estructura del Grafo**:
   - `vertices` define el número de vértices en el grafo.
   - `adj` es un array de listas enlazadas que representa la lista de adyacencia.
   
2. **Inicialización**:
   - En el constructor, se inicializan las listas de adyacencia para cada vértice.
   
3. **Agregar Bordes**:
   - `addEdge` agrega un borde entre dos nodos en el grafo.
   
4. **DFS Iterativa**:
   - `DFS` es la función que realiza el recorrido DFS de forma iterativa:
     - Crea una pila y marca todos los nodos como no visitados.
     - Empuja el nodo de partida en la pila.
     - Mientras la pila no esté vacía:
       - Extrae el nodo superior de la pila.
       - Si no ha sido visitado, lo marca como visitado y lo procesa (imprime).
       - Empuja todos los nodos adyacentes no visitados en la pila.
   
5. **Método Principal**:
   - Se crea un grafo con 4 vértices y se agregan algunos bordes.
   - Se llama al método `DFS` con el vértice 2 como el nodo de partida.

Esta implementación evita problemas de desbordamiento de pila que pueden ocurrir con la implementación recursiva en grafos muy profundos.

### Usos de BFS (Breadth-First Search):

1. **Cálculo de la ruta más corta en grafos no ponderados**:
   - **Ejemplo**: Encontrar el camino más corto entre dos estaciones de metro en una red de metro donde todas las rutas tienen el mismo costo.

2. **Exploración de todos los nodos en un grafo de manera nivel por nivel**:
   - **Ejemplo**: Implementar un algoritmo de búsqueda para encontrar todas las conexiones de una red social, explorando primero todos los amigos directos antes de pasar a los amigos de segundo grado.

3. **Detección de ciclos en grafos dirigidos y no dirigidos**:
   - **Ejemplo**: Verificar si una red de computadoras tiene ciclos (dependencias circulares) que podrían indicar un problema de configuración.

4. **Problemas de programación como la resolución de laberintos**:
   - **Ejemplo**: Usar BFS para encontrar la solución a un laberinto, ya que explora todos los caminos a la misma distancia antes de ir más profundo.

### Usos de DFS (Depth-First Search):

1. **Exploración de todos los caminos posibles en un grafo**:
   - **Ejemplo**: Resolver problemas de backtracking, como encontrar todas las combinaciones posibles en un rompecabezas o problema de sudoku.

2. **Detección de ciclos en grafos**:
   - **Ejemplo**: Implementar la detección de ciclos en un gráfico de tareas donde las dependencias podrían formar ciclos, utilizando DFS para recorrer el grafo.

3. **Recorrido de árboles y grafos para encontrar todas las posibles rutas**:
   - **Ejemplo**: Usar DFS para explorar todos los posibles caminos en un árbol de decisiones, donde se necesita considerar todas las alternativas antes de tomar una decisión final.

4. **Problemas de ordenamiento topológico**:
   - **Ejemplo**: Utilizar DFS para encontrar un ordenamiento topológico en un grafo dirigido, útil en la planificación de tareas y compilación de programas.

### Resumen con Ejemplos Específicos:

- **BFS** es ideal para:
  - Redes y grafos donde se necesita la ruta más corta.
  - Exploración de niveles y conexiones de manera uniforme.
  - Algoritmos de navegación y juegos, donde la solución debe ser la más corta posible.

- **DFS** es ideal para:
  - Problemas de backtracking y exploración profunda.
  - Algoritmos donde se necesita encontrar todas las posibles soluciones.
  - Algoritmos de análisis de grafos, donde se exploran todas las ramificaciones posibles antes de retroceder.

Cada algoritmo tiene sus fortalezas y es importante elegir el adecuado según el problema específico que se desea resolver.

Dijkstra es un algoritmo para encontrar la ruta más corta desde un nodo fuente a todos los demás nodos en un grafo ponderado con pesos no negativos. A continuación, se describen sus usos y una implementación en Java utilizando una lista de adyacencia.

### Características del Algoritmo de Dijkstra:
- Encuentra la ruta más corta desde un nodo fuente a todos los demás nodos en un grafo ponderado.
- Utiliza una cola de prioridad (o un min-heap) para seleccionar el nodo con la distancia mínima en cada paso.
- Funciona con grafos con pesos no negativos.

### Implementación en Java usando Lista de Adyacencia:

```java
import java.util.*;

class Dijkstra {
    private int vertices; // Número de vértices en el grafo
    private LinkedList<Node> adj[]; // Lista de adyacencia

    // Clase para representar un nodo en el grafo
    class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int v, int w) {
            vertex = v;
            weight = w;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    // Constructor
    Dijkstra(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Función para agregar un borde al grafo
    void addEdge(int v, int w, int weight) {
        adj[v].add(new Node(w, weight)); // Agrega w a la lista de v con un peso
        adj[w].add(new Node(v, weight)); // Agrega v a la lista de w con un peso (para grafos no dirigidos)
    }

    // Función para encontrar la ruta más corta desde un vértice fuente usando el algoritmo de Dijkstra
    void dijkstra(int src) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[vertices]; // Array para almacenar las distancias mínimas

        // Inicializa todas las distancias como infinito y la distancia del nodo fuente como 0
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            // Recorre todos los vecinos del nodo u
            for (Node neighbor : adj[u]) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                // Si hay un camino más corto a v a través de u
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Imprime las distancias más cortas desde el nodo fuente
        System.out.println("Distancias desde el nodo fuente " + src);
        for (int i = 0; i < vertices; i++)
            System.out.println("Hasta el nodo " + i + ": " + dist[i]);
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        Dijkstra g = new Dijkstra(5);

        g.addEdge(0, 1, 9);
        g.addEdge(0, 2, 6);
        g.addEdge(0, 3, 5);
        g.addEdge(0, 4, 3);
        g.addEdge(2, 1, 2);
        g.addEdge(2, 3, 4);

        System.out.println("Distancias más cortas desde el nodo 0:");
        g.dijkstra(0);
    }
}
```

### Explicación del Código:
1. **Estructura del Grafo**:
   - `vertices` define el número de vértices en el grafo.
   - `adj` es un array de listas enlazadas que representa la lista de adyacencia.
   - La clase `Node` representa un nodo con su vértice y el peso de la arista.

2. **Inicialización**:
   - En el constructor, se inicializan las listas de adyacencia para cada vértice.
   - `addEdge` agrega una arista entre dos nodos en el grafo con un peso.

3. **Algoritmo de Dijkstra**:
   - Se utiliza una cola de prioridad para seleccionar el nodo con la menor distancia acumulada.
   - Las distancias iniciales se establecen en infinito excepto la distancia del nodo fuente, que se establece en 0.
   - Se actualizan las distancias de los vecinos del nodo procesado si se encuentra un camino más corto.

4. **Método Principal**:
   - Se crea un grafo con 5 vértices y se agregan algunas aristas con sus pesos.
   - Se llama al método `dijkstra` con el vértice 0 como el nodo de partida.

### Usos del Algoritmo de Dijkstra:

1. **Sistemas de navegación GPS**:
   - **Ejemplo**: Calcular la ruta más corta desde una ubicación actual a un destino en un mapa de carreteras.

2. **Redes de telecomunicaciones**:
   - **Ejemplo**: Encontrar la ruta más corta y eficiente para la transmisión de datos entre servidores.

3. **Sistemas de transporte público**:
   - **Ejemplo**: Determinar el camino más corto para los autobuses y trenes en una ciudad, optimizando el tiempo de viaje para los pasajeros.

4. **Planificación de redes eléctricas y distribución de recursos**:
   - **Ejemplo**: Optimizar la distribución de energía en una red eléctrica minimizando las pérdidas y costos de transmisión.

Cada uno de estos sistemas se beneficia del algoritmo de Dijkstra por su capacidad de encontrar rutas óptimas en grafos ponderados, proporcionando soluciones eficientes y prácticas en tiempo real.

El algoritmo de Floyd-Warshall es un método para encontrar las rutas más cortas entre todos los pares de nodos en un grafo. A diferencia de Dijkstra, que encuentra las rutas más cortas desde un nodo fuente a todos los demás nodos, Floyd-Warshall considera todas las posibles rutas entre todos los pares de nodos. Este algoritmo es particularmente útil en grafos con pesos negativos, siempre y cuando no haya ciclos negativos.

### Características del Algoritmo de Floyd-Warshall:
- **Encuentra la ruta más corta entre todos los pares de nodos** en un grafo.
- **Funciona con grafos ponderados**, incluidos aquellos con pesos negativos, pero no con ciclos negativos.
- **Tiene una complejidad de tiempo O(V^3)**, donde V es el número de vértices, lo que lo hace menos eficiente que otros algoritmos como Dijkstra para grafos grandes.

### Implementación en Java usando Matriz de Adyacencia:

```java
import java.util.*;

public class FloydWarshall {
    private int vertices; // Número de vértices en el grafo
    private int[][] graph; // Matriz de adyacencia

    // Constructor
    FloydWarshall(int v) {
        vertices = v;
        graph = new int[v][v];
        for (int i = 0; i < v; ++i)
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2); // Inicializa la matriz con infinito
    }

    // Función para agregar un borde al grafo
    void addEdge(int src, int dest, int weight) {
        graph[src][dest] = weight;
    }

    // Función para imprimir la matriz de distancias
    void printSolution(int dist[][]) {
        System.out.println("Matriz de distancias más cortas:");
        for (int i = 0; i < vertices; ++i) {
            for (int j = 0; j < vertices; ++j) {
                if (dist[i][j] == Integer.MAX_VALUE / 2)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Función para ejecutar el algoritmo de Floyd-Warshall
    void floydWarshall() {
        int dist[][] = new int[vertices][vertices];

        // Inicializa la matriz de distancias con los pesos de los bordes
        for (int i = 0; i < vertices; ++i) {
            for (int j = 0; j < vertices; ++j) {
                if (i == j)
                    dist[i][j] = 0;
                else if (graph[i][j] != 0)
                    dist[i][j] = graph[i][j];
                else
                    dist[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        // Implementa el algoritmo de Floyd-Warshall
        for (int k = 0; k < vertices; ++k) {
            for (int i = 0; i < vertices; ++i) {
                for (int j = 0; j < vertices; ++j) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printSolution(dist);
    }

    // Método principal para probar el código
    public static void main(String args[]) {
        FloydWarshall graph = new FloydWarshall(4);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 4);

        graph.floydWarshall();
    }
}
```

### Explicación del Código:
1. **Estructura del Grafo**:
   - `vertices` define el número de vértices en el grafo.
   - `graph` es una matriz de adyacencia que almacena los pesos de las aristas.

2. **Inicialización**:
   - En el constructor, se inicializa la matriz con valores muy grandes (`Integer.MAX_VALUE / 2`), excepto la diagonal que se establece en 0, ya que la distancia de un nodo a sí mismo es cero.

3. **Agregar Bordes**:
   - `addEdge` establece el peso de la arista en la matriz de adyacencia.

4. **Algoritmo de Floyd-Warshall**:
   - Se inicializa la matriz `dist` con los valores de `graph`.
   - Se actualiza la matriz `dist` utilizando tres bucles anidados, donde se verifica si el camino a través de un nodo intermedio `k` es más corto que el camino directo de `i` a `j`.

5. **Impresión de la Solución**:
   - `printSolution` imprime la matriz de distancias más cortas, mostrando los costos mínimos entre todos los pares de nodos.

### Usos del Algoritmo de Floyd-Warshall:

1. **Redes de Transporte y Logística**:
   - **Ejemplo**: Calcular las rutas más cortas entre todos los almacenes en una red de distribución, considerando todos los posibles caminos.

2. **Sistemas de Navegación**:
   - **Ejemplo**: Determinar las rutas más cortas entre todos los puntos de interés en un mapa, útil para aplicaciones de planificación de rutas en vehículos autónomos.

3. **Optimización de Redes de Telecomunicaciones**:
   - **Ejemplo**: Encontrar las rutas más cortas y eficientes en una red de comunicaciones para minimizar la latencia y el ancho de banda.

4. **Análisis de Grafos en Ciencias Sociales**:
   - **Ejemplo**: Estudiar la influencia y conexiones entre nodos en redes sociales, redes de citas, y otras redes de interacción.

El algoritmo de Floyd-Warshall es muy poderoso para encontrar las rutas más cortas en grafos completos y es ideal para aplicaciones donde se requiere la información de todas las rutas más cortas entre todos los nodos. Sin embargo, su complejidad de O(V^3) puede ser impráctica para grafos con un gran número de vértices.