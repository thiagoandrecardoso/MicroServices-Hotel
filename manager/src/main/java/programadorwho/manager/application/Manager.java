package programadorwho.manager.application;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "manager")
@RequiredArgsConstructor
public class Manager {



    @GetMapping
    public String status() {
        return "Ok";
    }
}
