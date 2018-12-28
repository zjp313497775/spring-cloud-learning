package zjp.com.cn.serviceribbonapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hifeign?name="+name,String.class);
    }


}
