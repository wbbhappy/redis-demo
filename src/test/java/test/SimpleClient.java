package test;

import client.RedisClient;
import entity.City;
import org.junit.Test;
/**
 * <p>
 *  测试独立redis 客户端
 * </p>
 * Created by yclimb on 2017/6/8.
 */
public class SimpleClient {
    @Test
    public void userCache(){
        //向缓存中保存对象
        City city = new City();
        city.setCity("city");
        city.setCity("石家庄");
        city.setLastUpdate("20190131");
        //调用方法处理
        boolean reusltCache = RedisClient.set("city", city);
        if (reusltCache) {
            System.out.println("向缓存中保存对象成功。");
        }else{
            System.out.println("向缓存中保存对象失败。");
        }
    }
    @Test
    public void getUserInfo(){
        City city = RedisClient.get("city", City.class);
        if (city != null) {
            System.out.println("从缓存中获取的对象，" + city.getCity() + "@" + city.getLastUpdate());
        }
    }
}

