package herencia;

import java.util.ArrayList;

public class Library {
    String name;
    ArrayList<LibraryItem> libraryItems;
    ArrayList<Usuario> users;

    public Library(String name, ArrayList<LibraryItem> libraryItems, ArrayList<Usuario> users) {
        this.name = name;
        this.libraryItems = libraryItems;
        this.users = users;
    }

    // metodos
    // prestar
    // devolver
    // registrar usuario
    // eliminar usuario
    // buscar item

    public boolean prestamo(int item_id, int user_id)
    {
        // buscar usuario
        Usuario userFound = new Usuario();
        boolean isUserPresent = false;
        for(Usuario user: users){
            if(user.getId() == user_id)
            {
                isUserPresent = true;
                userFound = user;
                break;
            }
        }


        // buscar item
        LibraryItem libraryItem =  new LibraryItem();
        boolean itemFound =  false;

        for(LibraryItem item: libraryItems)
        {
            if(item.getId()==item_id)
            {
                itemFound = true;
                libraryItem = item;
                break;
            }
        }

        /*if(itemFound == false)
        {
            System.out.println("El item no existe");
            return false;
        }*/

        if(!(itemFound))
        {
            System.out.println("Item no existente");
            return false;
        }
        if(!(isUserPresent))
        {
            System.out.println("Usuario no registrado");
            return false;
        }

        if(libraryItem.isDisponible())
        {
            System.out.println("Prestamo realizado con exito");
            userFound.addItem(libraryItem);
            libraryItem.setDisponible(false);
            return true;
        }
        else{
            System.out.println("Item no disponible");
            return false;
        }
    }
    public boolean devolver(int item_id, int user_id){

        Usuario userFound = new Usuario();
        boolean isUserPresent = false;
        for(Usuario user: users){
            if(user.getId() == user_id)
            {
                isUserPresent = true;
                userFound = user;
                break;
            }
        }



        LibraryItem libraryItem =  new LibraryItem();
        boolean itemFound =  false;

        for(LibraryItem item: libraryItems)
        {
            if(item.getId()==item_id)
            {
                itemFound = true;
                libraryItem = item;
                break;
            }
        }


        if(!(itemFound))
        {
            System.out.println("Item no existente");
            return false;
        }
        if(!(isUserPresent))
        {
            System.out.println("Usuario no registrado");
            return false;
        }

        if(!libraryItem.isDisponible())
        {
            System.out.println("Devolución realizada con exito");
            userFound.addItem(libraryItem);
            libraryItem.setDisponible(false);
            return true;
        }
        else{
            System.out.println("Item no prestado");
            return false;
        }
    }

}
