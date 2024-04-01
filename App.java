package herencia;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // instanciamos library
        ArrayList<Usuario> usuarios = new ArrayList<>();
       /* usuarios.add(new Usuario("Jorge", 1));
        usuarios.add(new Usuario("Juan", 2));
        usuarios.add(new Usuario("Pedro", 3));
        usuarios.add(new Usuario("Maria", 4));*/

        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        libraryItems.add(new Book(1, "El mundo que vimos arder", true, "Renato Cisneros"));
        libraryItems.add(new Book(2, "La fiesta del chivo", true, "Mario Vargas Llosa"));
        libraryItems.add(new DVD(3, "Spiderman", true, "Sam Raymi", (short) 120));
        libraryItems.add(new DVD(4, "Avengers", true, "James Gosling", (short) 120));

        Library library = new Library("Mario Vargas Llosa", libraryItems, usuarios);
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Menú:");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Préstamo");
            System.out.println("3. Devolución");
            System.out.println("-----------------------------");
            int option = sc.nextInt();
            if(option==1)
            {
                System.out.println("Ingrese el id del usuario: ");
                int id_user = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese el username del usuario a registrar: ");
                String username = sc.nextLine();


                usuarios.add(new Usuario(username, id_user));
            }
            if(option==2)
            {
                System.out.println("Ingrese el id del usuario");
                int id_user = sc.nextInt();
                System.out.println("Ingrese el id del item");
                int id_item = sc.nextInt();

                library.prestamo(id_item, id_user);
            }
            if(option==3)
            {
                System.out.println("Ingrese el id del usuario");
                int id_user = sc.nextInt();
                System.out.println("Ingrese el id del item a devolver");
                int id_item = sc.nextInt();

                library.devolver(id_item, id_user);
            }
        }
    }
}
