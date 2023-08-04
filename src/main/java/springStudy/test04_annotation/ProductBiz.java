package springStudy.test04_annotation;

public interface ProductBiz {
    /**
     * 入库： 1.先查find()  2.再添加（a.加数量update()  b.增加add()）
     */
    public void takein();
}
