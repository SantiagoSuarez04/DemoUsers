import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserRegistration {
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private List<String> emails = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void Displaymenu(){
        boolean KeepRunning = true;

        while(KeepRunning){
            System.out.println("MENU:");
            System.out.println("1. Crear Usuario");
            System.out.println("2. Consultar usuario");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. salir");
            System.out.print("Elige una opcion");

            String option = scanner.nextLine();
            switch(option){
                case "1":
                    createUser();
                    break;
                case "2":
                    consultUser();
                    break;
                case "3":
                    modifyUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "5":
                    KeepRunning=false;
                    break;
                default:
                    System.out.println("opcion no valida");

            }
        }
    }
    private void createUser(){
        System.out.print("Introduce el nombre de usuario: ");
        usernames.add(scanner.nextLine());
        System.out.print("Introduce la contraseña: ");
        passwords.add(scanner.nextLine());
        System.out.print("Introduce un email: ");
        emails.add(scanner.nextLine());
        System.out.println("Usuario creado.");
    }
    private int getUserIndexByUsername(String username){
        return usernames.indexOf(username);
    }
    private int getPasswordIndex(String password){
        return passwords.indexOf(password);
    }
    private void consultUser(){
        System.out.print("Introduce el nombre del usuario a consultar: ");
        int index =getUserIndexByUsername(scanner.nextLine());
        if(index!= -1){
            System.out.println("Usuario: "+usernames.get(index)+", email: "+emails.get(index));
        } else{
            System.out.println("Usuario no encontrado.");
        }
    }
    private void modifyUser(){
        System.out.print("Introduce el usuario a modificar: ");
        int index = getUserIndexByUsername(scanner.nextLine());
        System.out.print("Introduce la contraseña");
        int indes = getPasswordIndex(scanner.nextLine());
        if(index!= -1 && indes!= -1){
            System.out.print("introduce el nuevo email (actual: "+emails.get(index)+" ): ");
            emails.set(index, scanner.nextLine());
            System.out.println("usuario modificado exitosamente.");
        }else if(indes==-1){
            System.out.println("Contraseña incorrecta");
        }
         else{
            System.out.println("Usuario no encontrado");
        }
    }
    private void deleteUser(){
        System.out.print("Introduce el nombre de usuario a eliminar: ");
        int index =getUserIndexByUsername(scanner.nextLine());
        if(index != -1){
            usernames.remove(index);
            passwords.remove(index);
            emails.remove(index);
            System.out.println("usuario eliminado exitosamente.");
        }else {
            System.out.println("usuario no encontrado.");
        }
    }
    public static void main(String[] args) {
        new UserRegistration().Displaymenu();
    }
}
