package jeeno.example.springbootmongo.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.CreatedDate;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 操作日志的返回实体
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/24 10:08
 */
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    /**
     * 操作人
     */
    @NotBlank(message = "操作人不能为空")
    private String account;
    /**
     * 操作模块
     */
    @NotBlank(message = "操作模块不能为空")
    private String module;
    /**
     * 操作内容
     */
    @NotBlank(message = "操作内容不能为空")
    private String content;
    /**
     * 操作状态（1 - 成功，0 - 失败）
     */
    @Range(min = 0, max = 1, message = "无效的操作状态信息")
    private Integer status;
    /**
     * 操作时间（转成东8时区：+8小时）
     */
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    /**
     * 详情
     */
    private String detail;
}
