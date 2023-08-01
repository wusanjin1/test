package springStudy.test02;

public class Apple {
    private int id;

    public Apple(){
        System.out.println("Apple无参构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                '}';
    }
}
