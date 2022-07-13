package pe.com.nttdata.bootcoin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinRequest {

    private Long id;
    private BigDecimal value;
    private LocalDateTime time;

}
