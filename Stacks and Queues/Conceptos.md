Las pilas y colas son dos tipos de estructuras de datos lineales que se utilizan para almacenar y gestionar colecciones de elementos. La principal diferencia entre ellas radica en el orden en que se insertan y eliminan los elementos. Aquí te dejo una explicación más detallada junto con ejemplos en Java.

### Pila (Stack)

#### Características:
- **LIFO (Last In, First Out)**: El último elemento en entrar es el primero en salir.
- Las operaciones principales son `push` (para insertar) y `pop` (para eliminar).
- Uso típico: situaciones donde necesitas deshacer acciones (como en un editor de texto), evaluación de expresiones, o backtracking.

#### Ejemplo en Java:
```java
import java.util.Stack;

public class PilaEjemplo {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        
        // Insertar elementos en la pila
        pila.push(1);
        pila.push(2);
        pila.push(3);
        
        // Eliminar el elemento superior de la pila
        int elemento = pila.pop();
        System.out.println("Elemento eliminado: " + elemento); // Output: 3
        
        // Ver el elemento superior sin eliminarlo
        int superior = pila.peek();
        System.out.println("Elemento superior: " + superior); // Output: 2
    }
}
```

### Cola (Queue)

#### Características:
- **FIFO (First In, First Out)**: El primer elemento en entrar es el primero en salir.
- Las operaciones principales son `offer` (para insertar) y `poll` (para eliminar).
- Uso típico: gestión de tareas en sistemas operativos, encolado de trabajos en impresoras, o sistemas de gestión de clientes.

#### Ejemplo en Java:
```java
import java.util.LinkedList;
import java.util.Queue;

public class ColaEjemplo {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        
        // Insertar elementos en la cola
        cola.offer(1);
        cola.offer(2);
        cola.offer(3);
        
        // Eliminar el elemento frontal de la cola
        int elemento = cola.poll();
        System.out.println("Elemento eliminado: " + elemento); // Output: 1
        
        // Ver el elemento frontal sin eliminarlo
        int frontal = cola.peek();
        System.out.println("Elemento frontal: " + frontal); // Output: 2
    }
}
```

### Cuándo usar cada una:
- **Pila**: Úsala cuando necesites un orden LIFO. Por ejemplo, si estás implementando una función de deshacer/rehacer en una aplicación o si estás evaluando expresiones aritméticas.
- **Cola**: Úsala cuando necesites un orden FIFO. Por ejemplo, en sistemas de gestión de tareas donde las tareas deben ser procesadas en el orden en que llegaron o en sistemas de gestión de colas de clientes.

Ambas estructuras de datos son fundamentales y se utilizan según las necesidades específicas del problema que estás tratando de resolver.

### Documentación de Métodos en Pila y Cola

Esta documentación proporciona una visión clara de los métodos comunes y específicos utilizados en las estructuras de datos de pila (Stack) y cola (Queue) en Java.

---

## Métodos Comunes: Pila y Cola

### `isEmpty()`
**Descripción**: Verifica si la estructura está vacía.
- **Retorno**: `boolean` - `true` si la estructura está vacía, `false` en caso contrario.

### `size()`
**Descripción**: Devuelve el número de elementos en la estructura.
- **Retorno**: `int` - El número de elementos presentes en la estructura.

### `clear()`
**Descripción**: Elimina todos los elementos de la estructura.
- **Retorno**: `void`

---

## Métodos Específicos de la Pila (Stack)

### `push(E item)`
**Descripción**: Inserta un elemento en la parte superior de la pila.
- **Parámetros**: `E item` - El elemento a insertar.
- **Retorno**: `E` - El elemento insertado.

### `pop()`
**Descripción**: Elimina y devuelve el elemento en la parte superior de la pila.
- **Retorno**: `E` - El elemento eliminado.

### `peek()`
**Descripción**: Devuelve el elemento en la parte superior de la pila sin eliminarlo.
- **Retorno**: `E` - El elemento en la parte superior de la pila.

#### Ejemplo en Java:
```java
import java.util.Stack;

public class PilaEjemplo {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        pila.push(1);  // Agrega 1 a la pila
        pila.push(2);  // Agrega 2 a la pila
        pila.push(3);  // Agrega 3 a la pila

        System.out.println(pila.pop());  // Elimina y devuelve 3
        System.out.println(pila.peek());  // Devuelve 2 sin eliminarlo
        System.out.println(pila.isEmpty());  // Verifica si la pila está vacía (false)
        System.out.println(pila.size());  // Devuelve el tamaño de la pila (2)
        
        pila.clear();  // Elimina todos los elementos de la pila
        System.out.println(pila.isEmpty());  // Verifica si la pila está vacía (true)
    }
}
```

---

## Métodos Específicos de la Cola (Queue)

### `offer(E item)`
**Descripción**: Inserta un elemento al final de la cola.
- **Parámetros**: `E item` - El elemento a insertar.
- **Retorno**: `boolean` - `true` si el elemento fue agregado con éxito, `false` en caso contrario.

### `poll()`
**Descripción**: Elimina y devuelve el primer elemento de la cola.
- **Retorno**: `E` - El elemento eliminado.

### `peek()`
**Descripción**: Devuelve el primer elemento de la cola sin eliminarlo.
- **Retorno**: `E` - El primer elemento de la cola.

#### Ejemplo en Java:
```java
import java.util.LinkedList;
import java.util.Queue;

public class ColaEjemplo {
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        cola.offer(1);  // Agrega 1 a la cola
        cola.offer(2);  // Agrega 2 a la cola
        cola.offer(3);  // Agrega 3 a la cola

        System.out.println(cola.poll());  // Elimina y devuelve 1
        System.out.println(cola.peek());  // Devuelve 2 sin eliminarlo
        System.out.println(cola.isEmpty());  // Verifica si la cola está vacía (false)
        System.out.println(cola.size());  // Devuelve el tamaño de la cola (2)
        
        cola.clear();  // Elimina todos los elementos de la cola
        System.out.println(cola.isEmpty());  // Verifica si la cola está vacía (true)
    }
}
```

---

## Resumen

- **Métodos Comunes**:
  - `isEmpty()`: Verifica si la estructura está vacía.
  - `size()`: Devuelve el número de elementos en la estructura.
  - `clear()`: Elimina todos los elementos de la estructura.

- **Pila (Stack)**:
  - `push(E item)`: Inserta un elemento en la parte superior de la pila.
  - `pop()`: Elimina y devuelve el elemento en la parte superior de la pila.
  - `peek()`: Devuelve el elemento en la parte superior de la pila sin eliminarlo.

- **Cola (Queue)**:
  - `offer(E item)`: Inserta un elemento al final de la cola.
  - `poll()`: Elimina y devuelve el primer elemento de la cola.
  - `peek()`: Devuelve el primer elemento de la cola sin eliminarlo.

Estas estructuras de datos se utilizan según el comportamiento deseado de acceso a los datos: LIFO para pila y FIFO para cola.