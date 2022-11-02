package com.example.managerhotel.application;

import com.example.managerhotel.application.exception.DataClientNotFoundException;
import com.example.managerhotel.application.exception.ErrorCommMicroServiceException;
import com.example.managerhotel.application.exception.ErrorRequestRoomException;
import com.example.managerhotel.domain.model.*;
import com.example.managerhotel.infra.clients.HostResourceClient;
import com.example.managerhotel.infra.clients.RoomResourceClient;
import com.example.managerhotel.infra.mqueue.RequestRoomPublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManagerHotelService {    

    private final HostResourceClient hostResourceClient;
    private final RoomResourceClient roomResourceClient;
    private final RequestRoomPublisher requestRoomPublisher;

    public ClientInfo getClientInfoByCpf(String cpf) throws DataClientNotFoundException,
            ErrorCommMicroServiceException {
        try {
            ResponseEntity<DataClient> dataClientResponseEntity = hostResourceClient.dataClient(cpf);
            ResponseEntity<List<RoomClient>> roomClientResponseEntity = roomResourceClient.getRoomByClient(cpf);

            return ClientInfo
                    .builder()
                    .dataClient(dataClientResponseEntity.getBody())
                    .roomClientList(roomClientResponseEntity.getBody())
                    .build();

        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.SC_NOT_FOUND == status) {
                throw new DataClientNotFoundException();
            }
            throw new ErrorCommMicroServiceException(e.getMessage(), status);
        }
    }

    public ProtocolRequestRoom getProtocolRequestRoom(DataRequestRoom dataRequestRoom) {
        try {
            requestRoomPublisher.sendsRoomRequest(dataRequestRoom);
            var protocol = UUID.randomUUID().toString();
            return new ProtocolRequestRoom(protocol);
        } catch (Exception e) {
            throw new ErrorRequestRoomException(e.getMessage());
        }
    }

}
