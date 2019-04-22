package com.example.narim.novaa;

public class SignInResponse {
    private String msg;
    private String token;
    SignInResult UserObject;


    // Getter Methods

    public String getMsg() {
        return msg;
    }

    public String getToken() {
        return token;
    }

    public SignInResult getUser() {
        return UserObject;
    }

    // Setter Methods

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(SignInResult userObject) {
        this.UserObject = userObject;
    }
}

/*public class SignInResponse {

    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("result")
    @Expose
    private SignInResult result = null;


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

    public SignInResult getResult() {
        return result;
    }

    public void setResult(SignInResult result) {
        this.result = result;
    }

}*/


