package springStudy.test01;

public class Student {
    private int id;
    private String name;
    private Address address;

    public Student(){
        System.out.println("Student无参构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("setId: " + id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName: " + name);
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("setAddress:" + address);
        this.address = address;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
