package jeeno.example.springbootmongo.service.impl;

import jeeno.example.springbootmongo.common.Constant;
import jeeno.example.springbootmongo.pojo.OperationDO;
import jeeno.example.springbootmongo.pojo.OperationDTO;
import jeeno.example.springbootmongo.repository.OperationRepository;
import jeeno.example.springbootmongo.service.IOperationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * impl for operation log
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/23 15:43
 */
@Service
@Slf4j
public class OperationServiceImpl implements IOperationService {

    @Resource
    private OperationRepository operationRepository;

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save(OperationDO operationDO) {
        operationRepository.save(operationDO);
    }

    @Override
    public List<OperationDTO> getAll(String date) {
        return mongoTemplate.find(new Query(), OperationDTO.class, Constant.COLLECTION_PREFIX + date);
    }

}
