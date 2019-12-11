public class User {
    public String name;
    public String email;
    public String login;
    public String password;

    public User(String name, String email, String login, String password) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public static User createValidUser() {
        return new User("test", "test", "test", "test");
    }
}
