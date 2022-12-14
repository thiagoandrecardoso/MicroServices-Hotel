package com.example.hotel.infra.mqueue;

import com.example.hotel.entity.DataRequestRoom;
import com.example.hotel.entity.Room;
import com.example.hotel.entity.RoomClient;
import com.example.hotel.exception.RoomIsOccupiedException;
import com.example.hotel.service.RoomClientService;
import com.example.hotel.service.RoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReceiveRoomRequest {
    private final RoomService roomService;
    private final RoomClientService roomClientService;

    @RabbitListener(queues = "${mq.queues.cursomsrabbitmq}")
    public void receiveRoom(@Payload String payload) {
        var mapper = new ObjectMapper();

        try {
            DataRequestRoom dataRequestRoom = mapper.readValue(payload, DataRequestRoom.class);
            Room room = roomService.getRoomByNumber(dataRequestRoom.getNumber());

            if (room != null) {
                if (room.isOccupied()) throw new RoomIsOccupiedException();

                room.setOccupied(true);
                roomService.save(room);

                RoomClient roomClient = new RoomClient(dataRequestRoom.getCpf(), room);
                roomClientService.save(roomClient);
            }

        } catch (JsonProcessingException | RoomIsOccupiedException e) {
           log.error("Error when receiving room issue request: {}", e.getMessage());
        }
    }
}
