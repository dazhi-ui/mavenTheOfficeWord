package bean;

public class User {
    private int id;
    private String username;
    private String password;
    private String permissionId;
    private String job;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String username, String password, String permissionId, String job, String status) {
        this.username = username;
        this.password = password;
        this.permissionId = permissionId;
        this.job = job;
        this.status = status;
    }
    public User(int id,String username, String password, String permissionId, String job, String status) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.permissionId = permissionId;
        this.job = job;
        this.status = status;
    }
    public User(){}
    public User(String username, String password, String job, String status) {
        this.username = username;
        this.password = password;
        this.job = job;
        this.status=status;
    }
}
