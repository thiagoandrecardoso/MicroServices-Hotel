package com.example.hotel.Resource;

import com.example.hotel.dto.RoomSaveRequest;
import com.example.hotel.entity.Room;
import com.example.hotel.service.RoomClientService;
import com.example.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rooms")
@RequiredArgsConstructor
public class RoomResource {

    private final RoomService roomService;
    private final RoomClientService roomClientService;

    @GetMapping
    public String status(){
        return "OK";
    }

    @PostMapping
    public ResponseEntity register(@RequestBody RoomSaveRequest request){
        Room room = request.toModel();
        roomService.save(room);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "number")
    public ResponseEntity<Room> getRoomByNumber(@RequestParam("number") int number){
        Room room = roomService.getRoomByNumber(number);
        return ResponseEntity.ok(room);
    }

}
