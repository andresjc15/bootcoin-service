package pe.com.nttdata.bootcoin.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.nttdata.bootcoin.dto.response.BootCoinValueResponse;
import pe.com.nttdata.bootcoin.model.document.BootCoin;
import pe.com.nttdata.bootcoin.model.repository.BootCoinRepository;
import pe.com.nttdata.bootcoin.model.service.BootCoinService;
import pe.com.nttdata.bootcoin.util.SequenceGeneratorService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class BootCoinServiceImpl implements BootCoinService {

    private final SequenceGeneratorService sequenceGeneratorService;

    private final BootCoinRepository bootCoinRepository;

    private final BootCoinEventService bootCoinEventService;

    @Override
    public Flux<BootCoin> getValues() {
        return bootCoinRepository.findAll();
    }

    @Override
    public Mono<BootCoinValueResponse> getValue() {
        return bootCoinRepository.findFirstByOrderByIdDesc().flatMap(bootCoin -> {
            BootCoinValueResponse response = new BootCoinValueResponse(bootCoin.getValue(), bootCoin.getTime());
            return Mono.just(response);
        });
    }

    @Override
    public Mono<BootCoin> registerValue(BigDecimal value) throws ExecutionException, InterruptedException {
        BootCoin bootCoin = new BootCoin();
        bootCoin.setId(sequenceGeneratorService.generateSequence(BootCoin.SEQUENCE_NAME));
        bootCoin.setValue(value);
        bootCoin.setTime(LocalDateTime.now());
        return bootCoinRepository.save(bootCoin).doOnSuccess(obj -> bootCoinEventService.publish(bootCoin));
    }
}
