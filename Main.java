import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class AccessControl {
    private Map<String, User> users;

    public AccessControl() {
        users = new HashMap<>();
    }

    public void addUser(String username, String password) {
        users.put(username, new User(username, password));
    }

    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();
        accessControl.addUser("William", "123456");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome de usuário: ");
        String username = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String password = scanner.nextLine();

        if (accessControl.authenticate(username, password)) {
            System.out.println("Login bem-sucedido para o usuário: " + username);
            // Realize a autorização para permitir o acesso a recursos específicos
        } else {
            System.out.println("Credenciais inválidas.");
        }
        
        scanner.close();
    }
}
