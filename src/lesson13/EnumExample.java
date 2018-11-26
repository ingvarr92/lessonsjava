package lesson13;

import java.util.Arrays;

public class EnumExample {
    public static void main(String[] args) {
        Role guest = Role.GUEST;
        User user = new User(1, "Alex", guest);
        User user2 = new User(2, "Mike", Role.ADMIN);

        System.out.println(Arrays.toString(Role.values()));
        for (Role role : Role.values()){
            System.out.println(role.ordinal());
            System.out.println(role);
        }

        String str = "USER";
        Role userRole = Role.valueOf(str);
        User user3 = new User (3,"Peter",Role.ADMIN);

        System.out.println(user3);

    }


    public static class User {
        private int id;
        private String name;
        private Role role;

        public User(int id, String name, Role role) {
            this.id = id;
            this.name = name;
            this.role = role;
        }
        public Role getRole(){
            return role;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", role=" + role +
                    '}';
        }
    }


    enum Role { // для каждого значения можно создать метод и для самого энума можно создать метод
        ADMIN, USER, GUEST;

//        public Role sameRole(){
//            return USER;
//        }
    }
}
