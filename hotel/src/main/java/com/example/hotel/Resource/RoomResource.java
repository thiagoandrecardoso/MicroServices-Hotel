package com.example.hotel.Resource;

import com.example.hotel.dto.RoomByClientResponse;
import com.example.hotel.dto.RoomByClientSaveRequest;
import com.example.hotel.dto.RoomSaveRequest;
import com.example.hotel.entity.Room;
import com.example.hotel.entity.RoomClient;
import com.example.hotel.service.RoomClientService;
import com.example.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.customizers.ServerBaseUrlCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomResource {

    private final RoomService roomService;
    private final RoomClientService roomClientService;

    @PostMapping
    public ResponseEntity register(@RequestBody RoomSaveRequest request) {
        Room room = request.toModel();
        roomService.save(room);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("number={}number")
                .buildAndExpand(request.getNumber())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @PostMapping(value = "client-room")
    public ResponseEntity registerClientRoom(@RequestBody RoomByClientSaveRequest request) {
        Room room = roomService.getRoomByNumber(request.getNumber());
        room.setOccupied(true);

        RoomClient roomClient = new RoomClient(request.getCpf(), room);
        roomClientService.save(roomClient);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(request.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(value = "number")
    public ResponseEntity<Room> getRoomByNumber(@RequestParam("number") int number) {
        Room room = roomService.getRoomByNumber(number);
        return ResponseEntity.ok(room);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<RoomByClientResponse>> getRoomByClient(@RequestParam("cpf") String cpf) {
        List<RoomClient> roomClientList = roomClientService.listRoomByCpf(cpf);

        List<RoomByClientResponse> roomByClientResponseList = roomClientList.stream()
                .map(RoomByClientResponse::fromModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(roomByClientResponseList);
    }

    @GetMapping(value = "free")
    public ResponseEntity<List<Room>> getRoomFree(){
        List<Room> roomList = roomService.getRoomsFree();
        return ResponseEntity.ok(roomList);
    }

}
