package com.jetbrains;

public class PhoneCoder {
    private int key;

    public PhoneCoder(int key) {
        this.key = key;
    }

    public PhoneCoder(){}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String encode(String phoneNumber){
        return phoneNumber;
    }

    public String decode(String codedPhoneNumber){
        return codedPhoneNumber;
    }

    public String toString(){
        return "PhoneCoder" + this.key;
    }


}
