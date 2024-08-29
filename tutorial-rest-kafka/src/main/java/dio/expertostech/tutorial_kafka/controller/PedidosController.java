package dio.expertostech.tutorial_kafka.controller;

import dio.expertostech.tutorial_kafka.data.PedidoData;
import dio.expertostech.tutorial_kafka.service.RegistraEventoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PedidosController {

    private final RegistraEventoService eventoService;

    @PostMapping("/api/salva-pedido")
    public ResponseEntity<String> salvarPedido(@RequestBody PedidoData pedido) {
        eventoService.adicionarEvento("SalvaPedido", pedido);
        return ResponseEntity.ok("Sucesso");
    }
}
