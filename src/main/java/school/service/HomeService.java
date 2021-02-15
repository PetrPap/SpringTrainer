
package school.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    
    public String getWelcomeMessage(){
        String message = "Welcome!";
        return message;
    }  
}
