package pe.com.nttdata.bootcoin.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BootCoinValueResponse {

    private BigDecimal value;
    private LocalDateTime time;

}
