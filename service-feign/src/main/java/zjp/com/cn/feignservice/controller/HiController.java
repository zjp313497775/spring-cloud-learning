package zjp.com.cn.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zjp.com.cn.feignservice.feigin.SchedualServiceHi;

/**
 * TODO
 * Created by 31349 on 2018-12-28.
 *
 * @author <a href="mailto:zhang_jianping@sicca.com.cn">zjp</a>
 * @version V1.0
 */
@RestController
public class HiController {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}
