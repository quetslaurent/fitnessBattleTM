package model;

public class ActivitySport {

    private String name;
    private int nbrepetitionPoint;
    private Category category;
    private Unit unit;
    private int id;


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
                ", category=" + category +
                ", unit=" + unit +
                '}';
    }

    public int getId() {
        return id;
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

}
