package pe.com.nttdata.bootcoin.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BootCoin {

    @Transient
    public static final String SEQUENCE_NAME = "bootcoin_sequence";

    @Id
    private Long id;
    private BigDecimal value;
    private LocalDateTime time;

}
