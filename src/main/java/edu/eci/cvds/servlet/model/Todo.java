
package edu.eci.cvds.servlet.model;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
    public int getId(){ return (id); }
    public int getUserId(){ return (userId); }
    public String getTitle(){ return (title); }
    public boolean getCompleted(){ return (completed); }
    public void setId(int id){ this.id=id; }
    public void setUserId(int userId){ this.userId=userId; }
    public void setTitle(String title){ this.title=title; }
    public void setCompleted(boolean completed){ this.completed=completed; }

}