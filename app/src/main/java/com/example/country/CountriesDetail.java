package com.example.country;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
@Entity( tableName = "country")

public class CountriesDetail implements Serializable {
   @PrimaryKey
   @NonNull
    @SerializedName("name")
    String Name;
   @ColumnInfo(name = "capital")
   @SerializedName("capital")
    String Capital;
    @ColumnInfo(name = "region")
   @SerializedName("region")
    String Region;
    @ColumnInfo(name = "subregion")
    @SerializedName("subregion")
    String SubRegion;
    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    String  Flag;
    @ColumnInfo(name = "borders")
    @SerializedName("borders")
   List<String> Borders;
    @ColumnInfo(name = "population")
    @SerializedName("population")
    Integer Population;
    @ColumnInfo(name = "languages")
    @SerializedName("languages")
   List<Language> language;

    public CountriesDetail(String name, String capital, String region, String subRegion, String flag, List<String> borders, Integer population, List<Language> language) {
        Name = name;
        Capital = capital;
        Region = region;
        SubRegion = subRegion;
        Flag = flag;
        Borders = borders;
        Population = population;
        this.language = language;
    }

    public CountriesDetail() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String capital) {
        Capital = capital;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getSubRegion() {
        return SubRegion;
    }

    public void setSubRegion(String subRegion) {
        SubRegion = subRegion;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public List<String> getBorders() {
        return Borders;
    }

    public void setBorders(List<String> borders) {
        Borders = borders;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer population) {
        Population = population;
    }

    public List<Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Language> language) {
        this.language = language;
    }
}

