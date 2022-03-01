package Bean;

import java.io.Serializable;

public class Pro implements  Comparable<Pro>, Serializable {

    private String provinceName;
    private String city;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String code;
    private Double ans;
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Double getAns() {
        return ans;
    }

    public void setAns(Double ans) {
        this.ans = ans;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Pro() {
    }

    public Pro(String provinceName, String city, String currentConfirmedCount, String confirmedCount, String suspectedCount, String curedCount, String deadCount, String code) {
        this.provinceName = provinceName;
        this.city = city;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.code = code;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public Pro(String provinceName, String city, String currentConfirmedCount, String confirmedCount, String suspectedCount, String curedCount, String deadCount) {
        this.provinceName = provinceName;
        this.city = city;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
    }


    @Override
    public int compareTo(Pro o) {
        return (this.ans > o.ans ? -1 : (this.ans == o.ans ? 0 : 1));
    }
}
