package springStudy.test03_factoryBean;

public class Pear {
    private int id;

    public Pear() {
        System.out.println("pear的无参构造...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pear{" +
                "id=" + id +
                '}';
    }
}
