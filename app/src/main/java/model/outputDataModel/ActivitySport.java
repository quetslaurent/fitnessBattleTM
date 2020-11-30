package model.outputDataModel;

import android.os.Parcel;
import android.os.Parcelable;

import model.inputDataModel.CategoryInput;
import model.inputDataModel.UnitInput;

public class ActivitySport {
    private int id;
    private String name;
    private double repetitions;
    private CategoryInput category;
    private UnitInput unit;



    public ActivitySport(String name,double repetitions ,CategoryInput categoryId, UnitInput unitId) {
        this.name = name;
        this.repetitions = repetitions;
        this.category = categoryId;
        this.unit = unitId;
    }

    @Override
    public String toString() {
        return "ActivitySport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", repetitions=" + repetitions +
                ", category=" + category +
                ", unit=" + unit +
                '}';
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

    public void setRepetitions(double repetitions) {
        this.repetitions = repetitions;
    }

    public CategoryInput getCategory() {
        return category;
    }

    public void setCategory(CategoryInput category) {
        this.category = category;
    }

    public UnitInput getUnit() {
        return unit;
    }

    public void setUnit(UnitInput unit) {
        this.unit = unit;
    }
}
