package DemoUserMVC;

public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view){
        this.model = model;
        this.view = view;
    }
    public void run(){
        boolean keepRunning = true;
        while(keepRunning) {
            view.displayMenu();
            String option = view.getInput("");

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
                    keepRunning=false;
                    break;
                default: 
                    view.showMessage("opcion no valida");
            }
        }
        view.showMessage("hasta pronto");
    }
    private void createUser(){
        String username =view.getInput("Introdusca el nombre de usuario: ");
        String password = view.getInput("Introduce la contraseña: ");
        String email = view.getInput("Introduce el email");

        model.addUser(new User(username,password,email));
        view.showMessage("usuario creado");
    }
    private void consultUser(){
        String username = view.getInput("Introduce el nombre del usuario a consultar: ");
        User user = model.getUserByUsername(username);
        if (user != null){
            view.printUserDetails(user);
        }else{
            view.showMessage("usuario no encontrado");
        }
    }
    private void modifyUser(){
        String username = view.getInput("Introduce el nombre del usuario a modificar: ");
        User user = model.getUserByUsername(username);
        if (user != null){
            String newEmail = view.getInput("Introduce el nuevo correo (actual: "+user.getEmail()+"): ");
            user.setEmail(newEmail);
            view.showMessage("usuario modificado");
        }else{
            view.showMessage("usuario no encontrado");
        }
    }
    private void deleteUser(){
        String username = view.getInput("introduce el usuario a eliminar");
        User user = model.getUserByUsername(username);
        if(user!=null){
            model.deleteUser(user);
            view.showMessage("usurio eliminado");
        }else{
            view.showMessage("usuario no encontrado");
        }
    }
 }

