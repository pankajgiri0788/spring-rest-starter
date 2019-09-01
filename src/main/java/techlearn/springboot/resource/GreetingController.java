package techlearn.springboot.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")
public class GreetingController {

    @GetMapping(value = "/hello", produces = MediaType.ALL_VALUE, consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> greet(@RequestParam(name = "username", defaultValue = "Pankaj") String username) {
        return ResponseEntity.ok(String.format("Hello, %1$s", username));
    }
}
