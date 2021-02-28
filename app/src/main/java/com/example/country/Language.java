package com.example.country;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Language implements Serializable {
    @ColumnInfo(name = "iso1")
    @SerializedName("iso639_1")
    String Iso639_1;
    @ColumnInfo(name = "iso2")
    @SerializedName("iso639_2")
    String Iso639_2;
    @ColumnInfo(name = "name")
    @SerializedName("name")
    String  Name;
    @ColumnInfo(name = "native")
    @SerializedName("nativeName")
    String NativeName;

    public Language(String iso639_1, String iso639_2, String name, String nativeName) {
        Iso639_1 = iso639_1;
        Iso639_2 = iso639_2;
        Name = name;
        NativeName = nativeName;
    }

    public String getIso639_1() {
        return Iso639_1;
    }

    public void setIso639_1(String iso639_1) {
        Iso639_1 = iso639_1;
    }

    public String getIso639_2() {
        return Iso639_2;
    }

    public void setIso639_2(String iso639_2) {
        Iso639_2 = iso639_2;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNativeName() {
        return NativeName;
    }

    public void setNativeName(String nativeName) {
        NativeName = nativeName;
    }
}
