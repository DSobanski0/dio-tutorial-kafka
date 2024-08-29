package dio.expertostech.tutorial_kafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dio.expertostech.tutorial_kafka.data.PedidoData;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SalvarPedidoService {

    @KafkaListener(topics = "SalvarPedido", groupId = "MicrosservicoSalvaPedido")
    private void executar(ConsumerRecord<String, String> record) {
        log.info("Key = {}", record.key());
        log.info("Header = {}", record.headers());
        log.info("Partition = {}", record.partition());

        String dados = record.value();
        ObjectMapper mapper = new ObjectMapper();
        PedidoData pedidoData;
        try {
            pedidoData = mapper.readValue(dados, PedidoData.class);
        } catch (JsonProcessingException e) {
            log.error("Falha converter evento [dado={}]", dados);
            return;
        }

        log.info("Evento recebido = {}", pedidoData);

        // Gravar no banco de dados
        // Responder para a fila que o pedido foi salvo
    }

    private void gravar(PedidoData pedido) {
        // Gravar no banco de dados
    }
}
