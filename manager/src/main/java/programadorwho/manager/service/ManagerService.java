package programadorwho.manager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import programadorwho.manager.client.ClientResourceClient;
import programadorwho.manager.client.HotelResourceClient;
import programadorwho.manager.entity.ClientData;
import programadorwho.manager.entity.RoomByClient;
import programadorwho.manager.entity.RoomClientData;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ClientResourceClient clientResourceClient;
    private final HotelResourceClient hotelResourceClient;

    public RoomByClient getRoomByCpfClient(String cpf){
        ResponseEntity<ClientData> dataClient = clientResourceClient.dataClient(cpf);
        ResponseEntity<List<RoomClientData>> roomByClientList = hotelResourceClient.getRoomByClient(cpf);

        return  RoomByClient.builder()
                .clientData(dataClient.getBody())
                .roomClientDataList(roomByClientList.getBody())
                .build();
    }

}
