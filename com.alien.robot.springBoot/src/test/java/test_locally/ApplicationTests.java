package test_locally;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alien.robot.core.message.MessageLoader;

@SpringBootTest
class ApplicationTests {

	@Autowired
	MessageLoader  ml;
	
    @Test
    void contextLoads() {
    	
    	ml.load();
    }

}
