package com.example.managerhotel.application;

import com.example.managerhotel.infra.clients.HostResourceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerHotelService {

    private final HostResourceClient hostResourceClient;

}
