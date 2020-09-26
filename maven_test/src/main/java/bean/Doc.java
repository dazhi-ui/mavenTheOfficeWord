package bean;

public class Doc {
    private int id;
    private String title;
    private String content;
    private String owner;
    private String receiver;
    private String time;
    private String status;
    private String ftip;
    private String ctip;
    private String del;

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFtip() {
        return ftip;
    }

    public void setFtip(String ftip) {
        this.ftip = ftip;
    }

    public String getCtip() {
        return ctip;
    }

    public void setCtip(String ctip) {
        this.ctip = ctip;
    }

    public Doc(String title, String content, String owner, String receiver, String time, String status, String del) {
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.receiver = receiver;
        this.time = time;
        this.status = status;
        this.del = del;
    }

    public Doc(int id, String title, String content, String owner, String receiver, String time, String status, String ftip, String ctip, String del) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.receiver = receiver;
        this.time = time;
        this.status = status;
        this.ftip = ftip;
        this.ctip = ctip;
        this.del = del;
    }

    public Doc(int id, String title, String content, String owner, String receiver, String time, String status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.receiver = receiver;
        this.time = time;
        this.status = status;
    }
}
