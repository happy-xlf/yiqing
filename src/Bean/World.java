package Bean;

import java.io.Serializable;

public class World implements Comparable<World>, Serializable {
    private String name;
    private String Date;
    private String confirmed;
    private String suspected;
    private String cured;
    private String dead;
    private Double ans;

    public Double getAns() {
        return ans;
    }

    public void setAns(Double ans) {
        this.ans = ans;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return Date;
    }
    public void setDate(String date) {
        Date = date;
    }
    public String getConfirmed() {
        return confirmed;
    }
    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }
    public String getSuspected() {
        return suspected;
    }
    public void setSuspected(String suspected) {
        this.suspected = suspected;
    }
    public String getCured() {
        return cured;
    }
    public void setCured(String cured) {
        this.cured = cured;
    }
    public String getDead() {
        return dead;
    }
    public void setDead(String dead) {
        this.dead = dead;
    }
    public World(String name, String date, String confirmed, String suspected, String cured, String dead) {
        super();
        this.name = name;
        Date = date;
        this.confirmed = confirmed;
        this.suspected = suspected;
        this.cured = cured;
        this.dead = dead;
    }
    public World() {
        super();
    }

    @Override
    public int compareTo(World o) {
        return (this.ans > o.ans ? -1 : (this.ans == o.ans ? 0 : 1));
    }
}
