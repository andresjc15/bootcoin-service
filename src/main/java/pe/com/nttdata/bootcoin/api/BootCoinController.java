package pe.com.nttdata.bootcoin.api;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.com.nttdata.bootcoin.dto.response.BootCoinValueResponse;
import pe.com.nttdata.bootcoin.model.document.BootCoin;
import pe.com.nttdata.bootcoin.model.service.BootCoinService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/bootcoin")
@AllArgsConstructor
public class BootCoinController {

    private final BootCoinService bootCoinService;

    @GetMapping
    public Flux<BootCoin> getBootCoinValues() { return bootCoinService.getValues(); }

    @GetMapping("/value")
    public Mono<BootCoinValueResponse> getBootCoinValue() { return bootCoinService.getValue(); }

    @PostMapping("/register/{value}")
    public Mono<BootCoin> changeValue(@PathVariable BigDecimal value) throws ExecutionException, InterruptedException {
        return bootCoinService.registerValue(value);
    }

}
