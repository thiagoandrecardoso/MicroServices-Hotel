package com.example.managerhotel.infra.mqueue;

import com.example.managerhotel.domain.model.DataRequestRoom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestRoomPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queueRequestRoom;

    public void sendsRoomRequest(DataRequestRoom dataRequestRoom) throws JsonProcessingException {
        var json = convertIntoJson(dataRequestRoom);
        rabbitTemplate.convertAndSend(queueRequestRoom.getName(), json);
    }

    private String convertIntoJson(DataRequestRoom dataRequestRoom) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dataRequestRoom);
    }
}
