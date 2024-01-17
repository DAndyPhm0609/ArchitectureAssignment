package Architecture.Assignment.model;

public class LoginObject {
    private User user;
    private String jwt;

    public LoginObject(){
        super();
    }

    public LoginObject(User user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}