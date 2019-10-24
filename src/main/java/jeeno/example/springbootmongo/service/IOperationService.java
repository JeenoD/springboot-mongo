package jeeno.example.springbootmongo.service;

import jeeno.example.springbootmongo.pojo.OperationDO;
import jeeno.example.springbootmongo.pojo.OperationDTO;

import java.util.List;

/**
 * service interface for operation log
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/23 15:42
 */
public interface IOperationService {

    /**
     * add operation log
     * @param operationDO operation info
     */
    void save(OperationDO operationDO);

    /**
     * get all operation log at someday
     * @param date the date
     * @return List<OperationDTO>
     */
    List<OperationDTO> getAll(String date);
}
