package zjp.com.cn.feignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * TODO
 * Created by 31349 on 2018-12-28.
 *
 * @author <a href="mailto:zhang_jianping@sicca.com.cn">zjp</a>
 * @version V1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class FeignService {
    public static void main(String[] args) {
        SpringApplication.run(FeignService.class, args);
    }
}
