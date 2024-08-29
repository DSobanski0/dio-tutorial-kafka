package dio.expertostech.tutorial_kafka.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoData {

    private String id;
    private String nomeProduto;
    private BigDecimal valor;
}
