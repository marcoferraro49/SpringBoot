package co.develhope.deploy02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class BasicController {

    @GetMapping
    public int sum(){
        Random random = new Random();
        int x = random.nextInt(50);
        int y = random.nextInt(50);
        return x+y;
    }
}
