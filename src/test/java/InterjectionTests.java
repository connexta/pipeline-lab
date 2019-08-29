import com.connexta.basic.mvn.BasicMain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Basic Unit test 1")
public class InterjectionTests {

    @Test
    @DisplayName("Speaking Test")
    public void testSpeaking() {
        BasicMain instance = new BasicMain();
        assertEquals(BasicMain.MY_THOUGHTS, instance.speak());
    }

    @Test
    @DisplayName("Interjecting Test")
    public void testInterject1() {
        final String SOME_THOUGHTS = "Excuse me?";
        BasicMain instance = new BasicMain();
        instance.interject(SOME_THOUGHTS);
        assertEquals(SOME_THOUGHTS, instance.speak());
    }


}
