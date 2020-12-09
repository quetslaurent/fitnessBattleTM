package model.outputDataModel;

import android.os.Parcel;
import android.os.Parcelable;

import model.inputDataModel.CategoryInput;
import model.inputDataModel.UnitInput;

public class ActivitySport {
    private int id;
    private String name;
    private double repetitions;
    private String categoryName;
    private String unitType;



    public ActivitySport(String name,double repetitions ,String categoryName, String unitType) {
        this.name = name;
        this.repetitions = repetitions;
        this.categoryName = categoryName;
        this.unitType = unitType;
    }

    @Override
    public String toString() {
        return name ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRepetitions() {
        return repetitions;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setRepetitions(double repetitions) {
        this.repetitions = repetitions;
    }


}
