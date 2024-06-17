package biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        List<Libro> listaDeLibros = new ArrayList<>();
        
        while(true) {
            System.out.println("Escriba el titulo del libro");
            String titulo = in.nextLine();
            
            //Si el titulo es 0 parar de consumir
            if("0".equals(titulo)){
                break;
            }
            
            System.out.println("Escriba el anno de publicacion");
            int anno = in.nextInt();
            
            // Consumir el carácter de nueva línea pendiente
            in.nextLine();
            
            System.out.println("Indique el autor");
            String autor = in.nextLine();
            
            Libro libro = new Libro(titulo, anno, autor);
            
            listaDeLibros.add(libro);
            
            // Evitar este antipatron
            //listaDeLibros.add(new Libro(titulo, anno, autor););
            
            System.out.println("Ha insertado el libro "+libro.toString());
        }
        
        System.out.println("Inserte el anno de busqueda en la biblioteca");
        int annoDeBusqueda = in.nextInt();
        
        List<Libro> busqueda = buscarPorAnno(annoDeBusqueda, listaDeLibros);
        
        System.out.println(busqueda.toString());
        
    }
    
    public static List<Libro> buscarPorAnno (int anno, List<Libro> lista) {
        List<Libro> listaADevolver = new LinkedList<>();
        for (Libro i : lista) {
            if (i.getAnno() == anno)
                listaADevolver.add(i);
        }
        
        return listaADevolver;
    }
}
