package programadorwho.manager.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import programadorwho.manager.entity.RoomClientData;

import java.util.List;

@FeignClient(value = "hotel", path = "rooms")
public interface HotelResourceClient {

    @GetMapping(params = "cpf")
    public ResponseEntity<List<RoomClientData>> getRoomByClient(@RequestParam("cpf") String cpf);
}
