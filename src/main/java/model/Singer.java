package model;

public class Singer {
    private int idSinger;
    private String usernameSinger;
    private String passwordSinger;
    private String singerName;
    private int phoneNumberSinger;
    private String emailSinger;
    private String addressSinger;

    public Singer() {
    }

    public Singer(int idSinger, String usernameSinger, String passwordSinger, String singerName, int phoneNumberSinger, String emailSinger, String addressSinger) {
        this.idSinger = idSinger;
        this.usernameSinger = usernameSinger;
        this.passwordSinger = passwordSinger;
        this.singerName = singerName;
        this.phoneNumberSinger = phoneNumberSinger;
        this.emailSinger = emailSinger;
        this.addressSinger = addressSinger;
    }

    public Singer(String usernameSinger, String passwordSinger, String singerName, int phoneNumberSinger, String emailSinger, String addressSinger) {
        this.usernameSinger = usernameSinger;
        this.passwordSinger = passwordSinger;
        this.singerName = singerName;
        this.phoneNumberSinger = phoneNumberSinger;
        this.emailSinger = emailSinger;
        this.addressSinger = addressSinger;
    }

    public int getIdSinger() {
        return idSinger;
    }

    public void setIdSinger(int idSinger) {
        this.idSinger = idSinger;
    }

    public String getUsernameSinger() {
        return usernameSinger;
    }

    public void setUsernameSinger(String usernameSinger) {
        this.usernameSinger = usernameSinger;
    }

    public String getPasswordSinger() {
        return passwordSinger;
    }

    public void setPasswordSinger(String passwordSinger) {
        this.passwordSinger = passwordSinger;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getPhoneNumberSinger() {
        return phoneNumberSinger;
    }

    public void setPhoneNumberSinger(int phoneNumberSinger) {
        this.phoneNumberSinger = phoneNumberSinger;
    }

    public String getEmailSinger() {
        return emailSinger;
    }

    public void setEmailSinger(String emailSinger) {
        this.emailSinger = emailSinger;
    }

    public String getAddressSinger() {
        return addressSinger;
    }

    public void setAddressSinger(String addressSinger) {
        this.addressSinger = addressSinger;
    }
}
