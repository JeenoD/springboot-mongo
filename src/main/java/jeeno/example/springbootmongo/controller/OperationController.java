package jeeno.example.springbootmongo.controller;

import jeeno.example.springbootmongo.pojo.OperationDO;
import jeeno.example.springbootmongo.pojo.OperationDTO;
import jeeno.example.springbootmongo.pojo.ReturnDTO;
import jeeno.example.springbootmongo.service.IOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * controller layer for operation log
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/23 15:46
 */
@RestController
@Slf4j
@RequestMapping("/opt")
public class OperationController {

    @Resource
    private IOperationService operationService;

    /**
     * add operation log
     * @return ReturnDTO<String>
     */
    @PostMapping("/add")
    public ReturnDTO<String> add(@RequestBody @Validated OperationDO operation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ReturnDTO.<String>builder()
                    .status(ReturnDTO.StatusEnum.FAILURE)
                    .message(bindingResult.getAllErrors().get(0).getDefaultMessage())
                    .data(null).build();
        }

        // TODO do the things for add operation
        // ...

        // add the operation log to mongodb
        operationService.save(operation);

        return ReturnDTO.<String>builder()
                .status(ReturnDTO.StatusEnum.SUCCESS)
                .message("操作成功")
                .data(null)
                .build();
    }

    /**
     * get the list of operation log at someday
     * @return ReturnDTO<List<String>>
     */
    @GetMapping("/list/{date}")
    public ReturnDTO<List<OperationDTO>> getAll(@PathVariable String date) {
        return ReturnDTO.<List<OperationDTO>>builder()
                .status(ReturnDTO.StatusEnum.SUCCESS)
                .message("操作成功")
                .data(operationService.getAll(date))
                .build();
    }
}
