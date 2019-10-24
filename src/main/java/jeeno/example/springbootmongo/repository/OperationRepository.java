package jeeno.example.springbootmongo.repository;

import jeeno.example.springbootmongo.pojo.OperationDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * repository for operation_log_xx
 * @author jeeno
 * @version 0.0.1
 * @date 2019/10/23 15:40
 */
@Repository
public interface OperationRepository extends MongoRepository<OperationDO, Long> {

}
