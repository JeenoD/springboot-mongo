package jeeno.example.springbootmongo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 返回数据的封装类型
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/23 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@SuppressWarnings("unused")
public class ReturnDTO<T> {

    /**
     * 处理状态
     */
    private StatusEnum status;
    /**
     * 信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;


    public enum StatusEnum{
        /**
         * 处理成功
         */
        SUCCESS,
        /**
         * 处理失败
         */
        FAILURE;
    }
}
