package model.inputDataModel;


/**
 * Ca sera la classe qui sera envoyé au serveur lorsqu'une category sera creer.
 */
public class CategoryInput {
    private int id;
    private String name;

    //ceci est un com
    public CategoryInput(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
