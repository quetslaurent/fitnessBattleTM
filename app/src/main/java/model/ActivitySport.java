package model;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivitySport  implements Parcelable {

    private String name;
    private int nbrepetition;
    private boolean checked;


    public ActivitySport(String name, int nbrepetition) {
        this.name = name;
        this.nbrepetition = nbrepetition;
    }
    public ActivitySport() {

    }

    public String getName() {
        return name;
    }

    public int getNbrepetition() {
        return nbrepetition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNbrepetition(int nbrepetition) {
        this.nbrepetition = nbrepetition;
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
        paramParcel.writeInt(nbrepetition);
        paramParcel.writeInt(checked ? 1:0 );

    }
    public ActivitySport(Parcel pc){

        name = pc.readString();
        nbrepetition = pc.readInt();
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
