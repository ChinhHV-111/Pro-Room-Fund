package Model;

import java.io.Serializable;

public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Room room;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        try {
            String imagePath = getClass().getResource("/Images/SignInIm.jpg").toExternalForm();
            room = new Room("name", "description", imagePath);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Lỗi truyền file ảnh mặc định của room ở class Account");
        }
    }

    public String getUsername() {
        return username;
    }

    public Room getRoom() {
        return room;
    }
    public void setRoom(Room room) {
        this.room = room;
    }
}
