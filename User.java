public class User {
    private String userId;
    private String name;
    private String password;
    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }
    public String getUserId() {
        return userId;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return userId + "," + name + "," + password;
    }
    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) return null;
        return new User(parts[0], parts[1], parts[2]);
    }
}
