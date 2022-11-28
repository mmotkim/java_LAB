        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taskmanager;

import java.time.LocalDate;

/**
 *
 * @author Mmotkim
 */
class Task {
    private int id;
    private int type;
    private String name;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int id, int type, String name, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    
    public String getTaskTypeName(int type){
        switch(type){
            case 1: return "Code";
            case 2: return "Test";
            case 3: return "Design";
            case 4: return "Review";
        }
        return null;
    }

    @Override
    public String toString() {
        return id + "," + type + "," + name + "," + date + "," + planFrom + "," + planTo + "," + assignee + "," + reviewer;
    }
    
    
    
    
}
