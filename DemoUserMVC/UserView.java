package DemoUserMVC;
import java.util.Scanner;
public class UserView {
    public void printUserDetails(User user){
        System.out.println("\nDetalles del usuario:");
        System.out.println("nombre del usuario: "+user.getUsername());
        System.out.println("contraseña:  "+user.getPassword() );
        System.out.println("correo: "+user.getEmail());
    }
    public String getInput(String message){
        System.out.print(message);
        Scanner scanner =new Scanner(System.in);
        return scanner.nextLine();
    }
    public void showMessage(String message){
        System.out.println(message);
    }
    public void displayMenu(){
        System.out.println("\nMenu:");
        System.out.println("1. crear usuario:");
        System.out.println("2. consultar usuario");
        System.out.println("3. modificar usuario");
        System.out.println("4. eliminar usuario");
        System.out.println("5. salir");
        System.out.println("Elige una opcion");
        
    }
}
