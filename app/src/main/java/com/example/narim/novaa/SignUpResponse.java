package com.example.narim.novaa;

public class SignUpResponse {
    private String token;
    SignUpResult UserObject;


    // Getter Methods

    public String getToken() {
        return token;
    }

    public SignUpResult getUser() {
        return UserObject;
    }

    // Setter Methods

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(SignUpResult userObject) {
        this.UserObject = userObject;
    }
}
/*public class SignUpResponse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private SignUpResult result = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignUpResult getResult() {
        return result;
    }

    public void setResult(SignUpResult result) {
        this.result = result;
    }

}*/
