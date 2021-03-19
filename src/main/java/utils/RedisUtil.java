package utils;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import static config.envParam.*;

/**
 * @program: TestNG_DEMO
 * @description: 实现redis连接
 * @author: poooooi
 * @create: 2021-03-19 23:09
 **/

public class RedisUtil {

    private static Jedis redis = new Jedis(REDIS_IP, Integer.parseInt(REDIS_PORT));

    static {
        redis.getClient().setSoTimeout(20000);
    }

    @Test
    public static String queryRedis(String key) {
        Integer cursor = 0;
        ScanParams scanParams = new ScanParams();
        scanParams.count(100);
        String keyName = "*"+((key.equals(""))?"":(key+"*"));
        scanParams.match(keyName);
        ScanResult<String> scanResult;
        String value="";
        do {
            scanResult = redis.scan(cursor,scanParams);
            cursor= scanResult.getCursor();
            for (String map:scanResult.getResult()){
                value = redis.get(map);
            }

        }while (cursor!=0);

        return value;
    }
}

