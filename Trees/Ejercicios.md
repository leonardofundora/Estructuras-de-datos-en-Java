### Ejercicio 1: **Sistema de Gestión de Archivos**

**Objetivo**: Implementar un sistema de gestión de archivos utilizando un árbol, donde cada nodo representa un archivo o directorio.

**Instrucciones**:
1. Define la clase `FileNode` con atributos `name`, `type` (archivo o directorio), y `children`.
2. Implementa métodos para agregar archivos y directorios.
3. Implementa métodos para buscar, eliminar y contar archivos y directorios.

```java
import java.util.*;

class FileNode {
    String name;
    String type;
    List<FileNode> children;

    public FileNode(String name, String type) {
        this.name = name;
        this.type = type;
        this.children = new ArrayList<>();
    }

    public void addChild(FileNode child) {
        children.add(child);
    }
}

class FileSystem {
    FileNode root;

    public FileSystem(String rootName) {
        root = new FileNode(rootName, "directory");
    }

    public void addFile(FileNode parent, String name) {
        parent.addChild(new FileNode(name, "file"));
    }

    public void addDirectory(FileNode parent, String name) {
        parent.addChild(new FileNode(name, "directory"));
    }

    public FileNode findNode(FileNode node, String name) {
        if (node == null) return null;
        if (node.name.equals(name)) return node;
        for (FileNode child : node.children) {
            FileNode found = findNode(child, name);
            if (found != null) return found;
        }
        return null;
    }

    public boolean removeNode(FileNode parent, String name) {
        if (parent == null) return false;
        Iterator<FileNode> iterator = parent.children.iterator();
        while (iterator.hasNext()) {
            FileNode child = iterator.next();
            if (child.name.equals(name)) {
                iterator.remove();
                return true;
            }
            if (removeNode(child, name)) {
                return true;
            }
        }
        return false;
    }

    public void display(FileNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.name + " (" + node.type + ")");
            for (FileNode child : node.children) {
                display(child, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem("root");

        FileNode documents = new FileNode("documents", "directory");
        fs.root.addChild(documents);
        fs.addFile(documents, "resume.pdf");
        fs.addFile(documents, "cover_letter.docx");

        FileNode photos = new FileNode("photos", "directory");
        fs.root.addChild(photos);
        fs.addFile(photos, "vacation.jpg");
        fs.addFile(photos, "birthday.png");

        System.out.println("File system structure:");
        fs.display(fs.root, "");

        FileNode found = fs.findNode(fs.root, "resume.pdf");
        System.out.println("\nFile found: " + (found != null ? found.name : "Not found"));

        fs.removeNode(fs.root, "birthday.png");
        System.out.println("\nFile system after removing 'birthday.png':");
        fs.display(fs.root, "");
    }
}
```

### Ejercicio 2: **Sistema de Gestión de Empleados**

**Objetivo**: Implementar un sistema de gestión de empleados utilizando un árbol, donde cada nodo representa un empleado y sus subordinados.

**Instrucciones**:
1. Define la clase `EmployeeNode` con atributos `name` y `position`.
2. Implementa métodos para agregar, buscar y eliminar empleados.
3. Implementa métodos para contar el número de empleados y contar los empleados sin subordinados (hojas).

```java
import java.util.*;

class EmployeeNode {
    String name;
    String position;
    List<EmployeeNode> subordinates;

    public EmployeeNode(String name, String position) {
        this.name = name;
        this.position = position;
        this.subordinates = new ArrayList<>();
    }

    public void addSubordinate(EmployeeNode subordinate) {
        subordinates.add(subordinate);
    }
}

class EmployeeManagementSystem {
    EmployeeNode ceo;

    public EmployeeManagementSystem(String ceoName, String ceoPosition) {
        ceo = new EmployeeNode(ceoName, ceoPosition);
    }

    public void addEmployee(EmployeeNode manager, String name, String position) {
        manager.addSubordinate(new EmployeeNode(name, position));
    }

    public EmployeeNode findEmployee(EmployeeNode node, String name) {
        if (node == null) return null;
        if (node.name.equals(name)) return node;
        for (EmployeeNode subordinate : node.subordinates) {
            EmployeeNode found = findEmployee(subordinate, name);
            if (found != null) return found;
        }
        return null;
    }

    public boolean removeEmployee(EmployeeNode manager, String name) {
        if (manager == null) return false;
        Iterator<EmployeeNode> iterator = manager.subordinates.iterator();
        while (iterator.hasNext()) {
            EmployeeNode subordinate = iterator.next();
            if (subordinate.name.equals(name)) {
                iterator.remove();
                return true;
            }
            if (removeEmployee(subordinate, name)) {
                return true;
            }
        }
        return false;
    }

    public int countEmployees(EmployeeNode node) {
        if (node == null) return 0;
        int count = 1;
        for (EmployeeNode subordinate : node.subordinates) {
            count += countEmployees(subordinate);
        }
        return count;
    }

    public int countLeafEmployees(EmployeeNode node) {
        if (node == null) return 0;
        if (node.subordinates.isEmpty()) return 1;
        int count = 0;
        for (EmployeeNode subordinate : node.subordinates) {
            count += countLeafEmployees(subordinate);
        }
        return count;
    }

    public void display(EmployeeNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.name + " (" + node.position + ")");
            for (EmployeeNode subordinate : node.subordinates) {
                display(subordinate, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem("John Doe", "CEO");

        EmployeeNode manager1 = new EmployeeNode("Jane Smith", "Manager");
        ems.ceo.addSubordinate(manager1);
        ems.addEmployee(manager1, "Alice Johnson", "Developer");
        ems.addEmployee(manager1, "Bob Brown", "Developer");

        EmployeeNode manager2 = new EmployeeNode("Robert White", "Manager");
        ems.ceo.addSubordinate(manager2);
        ems.addEmployee(manager2, "Charlie Green", "Designer");

        System.out.println("Employee hierarchy:");
        ems.display(ems.ceo, "");

        EmployeeNode found = ems.findEmployee(ems.ceo, "Alice Johnson");
        System.out.println("\nEmployee found: " + (found != null ? found.name : "Not found"));

        ems.removeEmployee(ems.ceo, "Bob Brown");
        System.out.println("\nEmployee hierarchy after removing 'Bob Brown':");
        ems.display(ems.ceo, "");

        int totalEmployees = ems.countEmployees(ems.ceo);
        System.out.println("\nTotal number of employees: " + totalEmployees);

        int leafEmployees = ems.countLeafEmployees(ems.ceo);
        System.out.println("Number of employees without subordinates: " + leafEmployees);
    }
}
```

### Ejercicio 3: **Sistema de Gestión de Cursos**

**Objetivo**: Implementar un sistema de gestión de cursos utilizando un árbol, donde cada nodo representa un curso y sus módulos o lecciones.

**Instrucciones**:
1. Define la clase `CourseNode` con atributos `title` y `type` (curso o lección).
2. Implementa métodos para agregar cursos y lecciones.
3. Implementa métodos para buscar, eliminar y contar cursos y lecciones.

```java
import java.util.*;

class CourseNode {
    String title;
    String type;
    List<CourseNode> modules;

    public CourseNode(String title, String type) {
        this.title = title;
        this.type = type;
        this.modules = new ArrayList<>();
    }

    public void addModule(CourseNode module) {
        modules.add(module);
    }
}

class CourseManagementSystem {
    CourseNode root;

    public CourseManagementSystem(String rootTitle) {
        root = new CourseNode(rootTitle, "course");
    }

    public void addCourse(CourseNode parent, String title) {
        parent.addModule(new CourseNode(title, "course"));
    }

    public void addLesson(CourseNode parent, String title) {
        parent.addModule(new CourseNode(title, "lesson"));
    }

    public CourseNode findCourse(CourseNode node, String title) {
        if (node == null) return null;
        if (node.title.equals(title)) return node;
        for (CourseNode module : node.modules) {
            CourseNode found = findCourse(module, title);
            if (found != null) return found;
        }
        return null;
    }

    public boolean removeCourse(CourseNode parent, String title) {
        if (parent == null) return false;
        Iterator<CourseNode> iterator = parent.modules.iterator();
        while (iterator.hasNext()) {
            CourseNode module = iterator.next();
            if (module

.title.equals(title)) {
                iterator.remove();
                return true;
            }
            if (removeCourse(module, title)) {
                return true;
            }
        }
        return false;
    }

    public void display(CourseNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.title + " (" + node.type + ")");
            for (CourseNode module : node.modules) {
                display(module, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem("Root Course");

        CourseNode course1 = new CourseNode("Course 1", "course");
        cms.root.addModule(course1);
        cms.addLesson(course1, "Lesson 1.1");
        cms.addLesson(course1, "Lesson 1.2");

        CourseNode course2 = new CourseNode("Course 2", "course");
        cms.root.addModule(course2);
        cms.addLesson(course2, "Lesson 2.1");

        System.out.println("Course structure:");
        cms.display(cms.root, "");

        CourseNode found = cms.findCourse(cms.root, "Lesson 1.1");
        System.out.println("\nCourse found: " + (found != null ? found.title : "Not found"));

        cms.removeCourse(cms.root, "Lesson 1.2");
        System.out.println("\nCourse structure after removing 'Lesson 1.2':");
        cms.display(cms.root, "");
    }
}
```

### Ejercicio 4: **Sistema de Organización de Proyectos**

**Objetivo**: Implementar un sistema de organización de proyectos utilizando un árbol, donde cada nodo representa un proyecto y sus tareas o subproyectos.

**Instrucciones**:
1. Define la clase `ProjectNode` con atributos `name` y `type` (proyecto o tarea).
2. Implementa métodos para agregar proyectos y tareas.
3. Implementa métodos para buscar, eliminar y contar proyectos y tareas.

```java
import java.util.*;

class ProjectNode {
    String name;
    String type;
    List<ProjectNode> tasks;

    public ProjectNode(String name, String type) {
        this.name = name;
        this.type = type;
        this.tasks = new ArrayList<>();
    }

    public void addTask(ProjectNode task) {
        tasks.add(task);
    }
}

class ProjectManagementSystem {
    ProjectNode root;

    public ProjectManagementSystem(String rootName) {
        root = new ProjectNode(rootName, "project");
    }

    public void addProject(ProjectNode parent, String name) {
        parent.addTask(new ProjectNode(name, "project"));
    }

    public void addTask(ProjectNode parent, String name) {
        parent.addTask(new ProjectNode(name, "task"));
    }

    public ProjectNode findProject(ProjectNode node, String name) {
        if (node == null) return null;
        if (node.name.equals(name)) return node;
        for (ProjectNode task : node.tasks) {
            ProjectNode found = findProject(task, name);
            if (found != null) return found;
        }
        return null;
    }

    public boolean removeProject(ProjectNode parent, String name) {
        if (parent == null) return false;
        Iterator<ProjectNode> iterator = parent.tasks.iterator();
        while (iterator.hasNext()) {
            ProjectNode task = iterator.next();
            if (task.name.equals(name)) {
                iterator.remove();
                return true;
            }
            if (removeProject(task, name)) {
                return true;
            }
        }
        return false;
    }

    public void display(ProjectNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.name + " (" + node.type + ")");
            for (ProjectNode task : node.tasks) {
                display(task, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        ProjectManagementSystem pms = new ProjectManagementSystem("Root Project");

        ProjectNode project1 = new ProjectNode("Project 1", "project");
        pms.root.addTask(project1);
        pms.addTask(project1, "Task 1.1");
        pms.addTask(project1, "Task 1.2");

        ProjectNode project2 = new ProjectNode("Project 2", "project");
        pms.root.addTask(project2);
        pms.addTask(project2, "Task 2.1");

        System.out.println("Project structure:");
        pms.display(pms.root, "");

        ProjectNode found = pms.findProject(pms.root, "Task 1.1");
        System.out.println("\nProject found: " + (found != null ? found.name : "Not found"));

        pms.removeProject(pms.root, "Task 1.2");
        System.out.println("\nProject structure after removing 'Task 1.2':");
        pms.display(pms.root, "");
    }
}
```

### Ejercicio 5: **Sistema de Organización de Categorías de Productos**

**Objetivo**: Implementar un sistema de organización de categorías de productos utilizando un árbol, donde cada nodo representa una categoría y sus subcategorías o productos.

**Instrucciones**:
1. Define la clase `CategoryNode` con atributos `name` y `type` (categoría o producto).
2. Implementa métodos para agregar categorías y productos.
3. Implementa métodos para buscar, eliminar y contar categorías y productos.

```java
import java.util.*;

class CategoryNode {
    String name;
    String type;
    List<CategoryNode> subcategories;

    public CategoryNode(String name, String type) {
        this.name = name;
        this.type = type;
        this.subcategories = new ArrayList<>();
    }

    public void addSubcategory(CategoryNode subcategory) {
        subcategories.add(subcategory);
    }
}

class CategoryManagementSystem {
    CategoryNode root;

    public CategoryManagementSystem(String rootName) {
        root = new CategoryNode(rootName, "category");
    }

    public void addCategory(CategoryNode parent, String name) {
        parent.addSubcategory(new CategoryNode(name, "category"));
    }

    public void addProduct(CategoryNode parent, String name) {
        parent.addSubcategory(new CategoryNode(name, "product"));
    }

    public CategoryNode findCategory(CategoryNode node, String name) {
        if (node == null) return null;
        if (node.name.equals(name)) return node;
        for (CategoryNode subcategory : node.subcategories) {
            CategoryNode found = findCategory(subcategory, name);
            if (found != null) return found;
        }
        return null;
    }

    public boolean removeCategory(CategoryNode parent, String name) {
        if (parent == null) return false;
        Iterator<CategoryNode> iterator = parent.subcategories.iterator();
        while (iterator.hasNext()) {
            CategoryNode subcategory = iterator.next();
            if (subcategory.name.equals(name)) {
                iterator.remove();
                return true;
            }
            if (removeCategory(subcategory, name)) {
                return true;
            }
        }
        return false;
    }

    public void display(CategoryNode node, String indent) {
        if (node != null) {
            System.out.println(indent + node.name + " (" + node.type + ")");
            for (CategoryNode subcategory : node.subcategories) {
                display(subcategory, indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        CategoryManagementSystem cms = new CategoryManagementSystem("Root Category");

        CategoryNode category1 = new CategoryNode("Category 1", "category");
        cms.root.addSubcategory(category1);
        cms.addProduct(category1, "Product 1.1");
        cms.addProduct(category1, "Product 1.2");

        CategoryNode category2 = new CategoryNode("Category 2", "category");
        cms.root.addSubcategory(category2);
        cms.addProduct(category2, "Product 2.1");

        System.out.println("Category structure:");
        cms.display(cms.root, "");

        CategoryNode found = cms.findCategory(cms.root, "Product 1.1");
        System.out.println("\nCategory found: " + (found != null ? found.name : "Not found"));

        cms.removeCategory(cms.root, "Product 1.2");
        System.out.println("\nCategory structure after removing 'Product 1.2':");
        cms.display(cms.root, "");
    }
}
```
