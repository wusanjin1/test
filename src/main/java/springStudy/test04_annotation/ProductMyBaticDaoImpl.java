package springStudy.test04_annotation;

import org.springframework.stereotype.Repository;

@Repository  //表明这个类被spring托管  这个类是一个dao层的类  -> spring会将异常转为RuntimeException
public class ProductMyBaticDaoImpl implements ProductDao{

    public ProductMyBaticDaoImpl(){
        System.out.println("ProductMyBaticDaoImpl的无参构造");
    }

    @Override
    public void add() {
        System.out.println("ProductMyBaticDaoImpl的add()");
    }

    @Override
    public void find() {
        System.out.println("ProductMyBaticDaoImpl的find()");
    }

    @Override
    public void update() {
        System.out.println("ProductMyBaticDaoImpl的update()");
    }
}
