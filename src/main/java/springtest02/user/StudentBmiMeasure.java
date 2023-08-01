package springtest02.user;

import org.springframework.stereotype.Component;
import springtest02.system.Measure;

@Component("bmiMeasure")
public class StudentBmiMeasure implements Measure {
    //算法
    @Override
    public double doMeasure(Object obj) {
        if (obj == null) {
            throw new RuntimeException("该数据异常");
        }
        if (!(obj instanceof Student)) {
            throw new RuntimeException("该数据异常");
        }
        Student s = (Student) obj;
        return s.getWeight() / (s.getHeight() * s.getHeight());
    }
}
