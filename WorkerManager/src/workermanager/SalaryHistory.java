package workermanager;

public class SalaryHistory {
    private int id;
    private String status;
    private String date;

    public SalaryHistory(int id, String status, String date) {
        this.id = id;
        this.status = status;
        this.date = date;
    }

    public SalaryHistory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "|" + status + "|" + date;
    }
    
    

}
