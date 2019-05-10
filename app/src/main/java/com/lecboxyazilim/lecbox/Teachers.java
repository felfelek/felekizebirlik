package com.lecboxyazilim.lecbox;

public class Teachers  {
    private String name;
    private String status;
    public Teachers(){

    }

    public Teachers(String name, String status) {
        this.name = name;
        this.status = status;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
