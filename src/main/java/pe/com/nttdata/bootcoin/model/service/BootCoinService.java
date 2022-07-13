package pe.com.nttdata.bootcoin.model.service;

import pe.com.nttdata.bootcoin.dto.response.BootCoinValueResponse;
import pe.com.nttdata.bootcoin.model.document.BootCoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

public interface BootCoinService {

    public Flux<BootCoin> getValues();

    public Mono<BootCoinValueResponse> getValue();

    public Mono<BootCoin> registerValue(BigDecimal value) throws ExecutionException, InterruptedException;
}
