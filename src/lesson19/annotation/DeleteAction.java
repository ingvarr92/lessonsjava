package lesson19.annotation;

//
@PermissionRequired(User.Permission.ADMIN)
public class DeleteAction {
    public void delete (User user){
        System.out.println("del user");
    }



}
