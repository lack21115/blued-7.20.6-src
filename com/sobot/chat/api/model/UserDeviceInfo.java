package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/UserDeviceInfo.class */
public class UserDeviceInfo implements Serializable {
    private String appName;
    private String appVersion;
    private String phoneEquipmentModel;
    private String phoneMACAddr;
    private String phoneOS;
    private String phoneOSLanguage;
    private String phoneOSVersion;
    private String phoneOperator;
    private String phoneScreenSize;
    private String phoneScreesResolution;
    private String phoneUUID;

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getPhoneEquipmentModel() {
        return this.phoneEquipmentModel;
    }

    public String getPhoneMACAddr() {
        return this.phoneMACAddr;
    }

    public String getPhoneOS() {
        return this.phoneOS;
    }

    public String getPhoneOSLanguage() {
        return this.phoneOSLanguage;
    }

    public String getPhoneOSVersion() {
        return this.phoneOSVersion;
    }

    public String getPhoneOperator() {
        return this.phoneOperator;
    }

    public String getPhoneScreenSize() {
        return this.phoneScreenSize;
    }

    public String getPhoneScreesResolution() {
        return this.phoneScreesResolution;
    }

    public String getPhoneUUID() {
        return this.phoneUUID;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setPhoneEquipmentModel(String str) {
        this.phoneEquipmentModel = str;
    }

    public void setPhoneMACAddr(String str) {
        this.phoneMACAddr = str;
    }

    public void setPhoneOS(String str) {
        this.phoneOS = str;
    }

    public void setPhoneOSLanguage(String str) {
        this.phoneOSLanguage = str;
    }

    public void setPhoneOSVersion(String str) {
        this.phoneOSVersion = str;
    }

    public void setPhoneOperator(String str) {
        this.phoneOperator = str;
    }

    public void setPhoneScreenSize(String str) {
        this.phoneScreenSize = str;
    }

    public void setPhoneScreesResolution(String str) {
        this.phoneScreesResolution = str;
    }

    public void setPhoneUUID(String str) {
        this.phoneUUID = str;
    }
}
