import java.io.*;
import java.util.*;

public class UserManager {
    private final String FILE_NAME = "users.txt";

    public int generateNewUserId() {
        int maxId = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null) {
                    try {
                        int id = Integer.parseInt(user.getUserId());
                        if (id > maxId) maxId = id;
                    } catch (NumberFormatException ignored) {}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maxId + 1;
    }

    public boolean signUp(String name, String password) {
        int newId = generateNewUserId();
        String userId = String.valueOf(newId);
        if (userExists(userId)) return false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(userId + "," + name + "," + password);
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User login(String userId, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean userExists(String userId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null && user.getUserId().equals(userId)) return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteAccount(String userId, String password) {
        List<String> allUsers = new ArrayList<>();
        boolean isDeleted = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null && user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                    isDeleted = true;
                } else {
                    allUsers.add(line);
                }
            }

            if (isDeleted) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                    for (String userLine : allUsers) {
                        writer.write(userLine);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
