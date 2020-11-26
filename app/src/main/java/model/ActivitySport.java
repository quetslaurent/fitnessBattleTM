package model;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivitySport  implements Parcelable {

    private String name;
    private int nbrepetitionPoint;
    private boolean checked;
    private Category category;
    private Unit unit;


    /**
     * constructeur de la classe activité
     * @param name , le nom du sport , exemple pompe
     * @param nbrepetition , le nombre de répétition pour avoir un point
     */
    public ActivitySport(String name, int nbrepetition,Category category,Unit unit) {
        this.name = name;
        this.nbrepetitionPoint = nbrepetition;
        this.category = category;
        this.unit = unit;
    }
    public ActivitySport() {

    }


    @Override
    public String toString() {
        return "ActivitySport{" +
                "name='" + name + '\'' +
                ", nbrepetitionPoint=" + nbrepetitionPoint +
                ", checked=" + checked +
                ", category=" + category +
                ", unit=" + unit +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getNbrepetitionPoint() {
        return nbrepetitionPoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbrepetitionPoint(int nbrepetitionPoint) {
        this.nbrepetitionPoint = nbrepetitionPoint;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ActivitySport other = (ActivitySport) obj;
        if (name == null) {
            if (other.name == null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel paramParcel, int flags) {
        paramParcel.writeString(name);
        paramParcel.writeInt(nbrepetitionPoint);
        paramParcel.writeInt(checked ? 1:0 );

    }

    /**
     * change
     * constructeur qui va lire les argu de l'objet Parcel dans l'ordre dans lequel ils sont passer dans write
     * @param pc
     */
    public ActivitySport(Parcel pc){

        name = pc.readString();
        nbrepetitionPoint = pc.readInt();
        checked = (pc.readInt() == 1);
    }

    public static final Parcelable.Creator<ActivitySport> CREATOR = new Parcelable.Creator<ActivitySport>() {
        public ActivitySport createFromParcel(Parcel pc) {
            return new ActivitySport(pc);
        }
        public ActivitySport[] newArray(int size) {
            return new ActivitySport[size];
        }
    };

}
