package pe.com.nttdata.bootcoin.event;

import lombok.*;
import pe.com.nttdata.bootcoin.model.document.BootCoin;

@Data
@EqualsAndHashCode(callSuper = true)
public class BootCoinCreatedEvent extends Event<BootCoin> {
}
