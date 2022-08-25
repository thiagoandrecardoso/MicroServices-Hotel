package programadorwho.manager.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomByClient {
    private ClientData clientData;
    private List<RoomClientData> roomClientDataList;
}
