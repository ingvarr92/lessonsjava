package lesson19.annotation;

public class ParseAnnotation {
    public static void main(String[] args) {
        User user = new User(User.Permission.ADMIN);


        Class<?> actionClass =DeleteAction.class;
                PermissionRequired permissionRequired = actionClass.getAnnotation(PermissionRequired.class);


                if (permissionRequired != null){
                    if (user.getPermission().equals(permissionRequired.value())){
                        System.out.println("Пользователю доступно удаление");
                    }
                }
    }
}


// написать рефлексивный toString


//  написать небольшой Dependency Injection Framework
// всю логику можно собрать в одном классе DIContext,
// благодаря которому можно создавать экземпляр любого класса с автоматически установленными зависимостями
