package programadorwho.manager.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programadorwho.manager.entity.ClientData;

@FeignClient(value = "client", path = "clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> dataClient(@RequestParam("cpf") String cpf);
}
