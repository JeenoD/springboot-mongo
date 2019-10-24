package jeeno.example.springbootmongo.conf;

import jeeno.example.springbootmongo.common.Constant;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Mongo 集合的配置生成器
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/24 9:56
 */
@Component(value = "mongoProvider")
public class MongoCollectionProvider {



    /**
     * 根据当前日期指定生成的集合名称
     * @return String
     */
    @SuppressWarnings("unused")
    public String getCollectionName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());
        return Constant.COLLECTION_PREFIX + date;
    }

}
