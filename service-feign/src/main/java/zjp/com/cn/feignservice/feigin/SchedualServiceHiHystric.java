package zjp.com.cn.feignservice.feigin;

import org.springframework.stereotype.Component;

/**
 * TODO
 * Created by 31349 on 2018-12-28.
 *
 * @author <a href="mailto:313497775@qq.com">zjp</a>
 * @version V1.0
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
