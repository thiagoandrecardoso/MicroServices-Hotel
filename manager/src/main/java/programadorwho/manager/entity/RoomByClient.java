package programadorwho.manager.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoomByClient {
    private ClientData clientData;
    private List<RoomClientData> roomClientDataList;
}
