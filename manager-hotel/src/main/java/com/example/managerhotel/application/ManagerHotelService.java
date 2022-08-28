package com.example.managerhotel.application;

import com.example.managerhotel.application.exception.DataClientNotFoundException;
import com.example.managerhotel.application.exception.ErrorCommMicroServiceException;
import com.example.managerhotel.domain.model.ClientInfo;
import com.example.managerhotel.domain.model.DataClient;
import com.example.managerhotel.domain.model.RoomClient;
import com.example.managerhotel.infra.clients.HostResourceClient;
import com.example.managerhotel.infra.clients.RoomResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManagerHotelService {

    private final HostResourceClient hostResourceClient;
    private final RoomResourceClient roomResourceClient;

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

}
