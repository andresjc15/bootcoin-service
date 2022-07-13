package pe.com.nttdata.bootcoin.model.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.nttdata.bootcoin.model.document.BootCoin;
import reactor.core.publisher.Mono;

@Repository
public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin, Long> {

    public Mono<BootCoin> findFirstByOrderByIdDesc();

}
