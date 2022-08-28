package com.example.managerhotel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInfo {
    private DataClient dataClient;
    private List<RoomClient> roomClientList;
}
