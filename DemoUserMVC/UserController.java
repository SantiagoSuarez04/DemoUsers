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

            
        }
    }
    }

