package springStudy.Test05_import;

public class Banana {
    private int id;

    public Banana() {
        System.out.println("Banana的无参构造...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Banana{" +
                "id=" + id +
                '}';
    }
}
