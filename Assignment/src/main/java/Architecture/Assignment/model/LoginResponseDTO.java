package Architecture.Assignment.model;

import org.springframework.http.HttpStatus;

public class LoginResponseDTO {
    private User user;
    private Boolean ok;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(User user, Boolean ok){
        this.user = user;
        this.ok = ok;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }
}
