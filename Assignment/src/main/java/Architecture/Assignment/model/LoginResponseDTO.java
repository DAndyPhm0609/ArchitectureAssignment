package Architecture.Assignment.model;

public class LoginResponseDTO {
    private User user;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

}
