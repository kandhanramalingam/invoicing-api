package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "wld_users")
public class WldUserEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "city")
    private Integer city;

    @Column(name = "state")
    private Integer state;

    @Column(name = "location", length = 100)
    private String location;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "mobile", length = 15)
    private String mobile;

    @Column(name = "telephone", length = 15)
    private String telephone;

    @Column(name = "username")
    private String username;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "decrpt_password", nullable = false, columnDefinition = "TEXT")
    private String decrptPassword;

    @Column(name = "idNumber", length = 50)
    private String idNumber;

    @Column(name = "passport", length = 50)
    private String passport;

    @Column(name = "user_type", nullable = false, length = 2)
    private String userType;

    @Column(name = "sub_user_type", length = 2)
    private String subUserType;

    @Column(name = "login_from", nullable = false, length = 1)
    private String loginFrom;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "comm_email", nullable = false)
    private String commEmail;

    @Column(name = "comm_sms", nullable = false)
    private String commSms;

    @Column(name = "comm_cell", nullable = false)
    private String commCell;

    @Column(name = "comm_telephone", nullable = false)
    private String commTelephone;

    @Column(name = "comm_email_cell", nullable = false)
    private String commEmailCell;

    @Column(name = "status", length = 1)
    private String status;

    @Column(name = "ip_address", length = 20)
    private String ipAddress;

    @Column(name = "game_dealers", length = 2)
    private String gameDealers;

    @Column(name = "game_sellers", length = 2)
    private String gameSellers;

    @Column(name = "game_capturer", length = 2)
    private String gameCapturer;

    @Column(name = "game_buyers", length = 2)
    private String gameBuyers;

    @Column(name = "game_transporter", length = 2)
    private String gameTransporter;

    @Column(name = "hunting_farm", length = 2)
    private String huntingFarm;

    @Column(name = "hunter", length = 2)
    private String hunter;

    @Column(name = "veterinary_services", length = 2)
    private String veterinaryServices;

    @Column(name = "address_type", nullable = false, length = 2)
    private String addressType;

    @Column(name = "country", length = 10)
    private String country;

    @Column(name = "area", length = 10)
    private String area;

    @Column(name = "agent", nullable = false, length = 25)
    private String agent;

    @Column(name = "is_agent", nullable = false)
    private String isAgent;

    @Column(name = "Interest_species", nullable = false, columnDefinition = "TEXT")
    private String interestSpecies;

    @Column(name = "unsubscribe", nullable = false)
    private String unsubscribe;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getDecrptPassword() {
        return decrptPassword;
    }

    public void setDecrptPassword(String decrptPassword) {
        this.decrptPassword = decrptPassword;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSubUserType() {
        return subUserType;
    }

    public void setSubUserType(String subUserType) {
        this.subUserType = subUserType;
    }

    public String getLoginFrom() {
        return loginFrom;
    }

    public void setLoginFrom(String loginFrom) {
        this.loginFrom = loginFrom;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getCommEmail() {
        return commEmail;
    }

    public void setCommEmail(String commEmail) {
        this.commEmail = commEmail;
    }

    public String getCommSms() {
        return commSms;
    }

    public void setCommSms(String commSms) {
        this.commSms = commSms;
    }

    public String getCommCell() {
        return commCell;
    }

    public void setCommCell(String commCell) {
        this.commCell = commCell;
    }

    public String getCommTelephone() {
        return commTelephone;
    }

    public void setCommTelephone(String commTelephone) {
        this.commTelephone = commTelephone;
    }

    public String getCommEmailCell() {
        return commEmailCell;
    }

    public void setCommEmailCell(String commEmailCell) {
        this.commEmailCell = commEmailCell;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getGameDealers() {
        return gameDealers;
    }

    public void setGameDealers(String gameDealers) {
        this.gameDealers = gameDealers;
    }

    public String getGameSellers() {
        return gameSellers;
    }

    public void setGameSellers(String gameSellers) {
        this.gameSellers = gameSellers;
    }

    public String getGameCapturer() {
        return gameCapturer;
    }

    public void setGameCapturer(String gameCapturer) {
        this.gameCapturer = gameCapturer;
    }

    public String getGameBuyers() {
        return gameBuyers;
    }

    public void setGameBuyers(String gameBuyers) {
        this.gameBuyers = gameBuyers;
    }

    public String getGameTransporter() {
        return gameTransporter;
    }

    public void setGameTransporter(String gameTransporter) {
        this.gameTransporter = gameTransporter;
    }

    public String getHuntingFarm() {
        return huntingFarm;
    }

    public void setHuntingFarm(String huntingFarm) {
        this.huntingFarm = huntingFarm;
    }

    public String getHunter() {
        return hunter;
    }

    public void setHunter(String hunter) {
        this.hunter = hunter;
    }

    public String getVeterinaryServices() {
        return veterinaryServices;
    }

    public void setVeterinaryServices(String veterinaryServices) {
        this.veterinaryServices = veterinaryServices;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(String isAgent) {
        this.isAgent = isAgent;
    }

    public String getInterestSpecies() {
        return interestSpecies;
    }

    public void setInterestSpecies(String interestSpecies) {
        this.interestSpecies = interestSpecies;
    }

    public String getUnsubscribe() {
        return unsubscribe;
    }

    public void setUnsubscribe(String unsubscribe) {
        this.unsubscribe = unsubscribe;
    }
}
