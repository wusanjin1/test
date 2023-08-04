package springtest04.user;

import lombok.Data;

@Data  //lombok 注解需要在idea中增加一个插件
public class BankAccount {
    private int id;
    private double balance;
}
