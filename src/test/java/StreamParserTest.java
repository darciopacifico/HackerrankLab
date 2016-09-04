
import java.util.Optional;

import static parser.StreamParser.parseAsStream;

/**
 * Tests for the StreamParser implementation
 */
public class StreamParserTest {


    public static void main(String[] args) {

    }
    public void testStateMachine(){

    /*    assertEquals(parseAsStream("aAbBABacfe"), Optional.of('e'));
        assertEquals(parseAsStream("aAbBABacf"), Optional.empty());
        assertEquals(parseAsStream("aAbBABacfE"), Optional.of('E'));
        assertEquals(parseAsStream("aAbBABacfu"), Optional.of('u'));
        assertEquals(parseAsStream("aA+++bBAB&&&acfe"), Optional.of('e'));
        assertEquals(parseAsStream("aaaaaaa"), Optional.empty());
        assertEquals(parseAsStream("zzzzzzzzz"), Optional.empty());
        assertEquals(parseAsStream("zzzzzzzzzAzzzzzzBzzzzzC"), Optional.of('A'));
        assertEquals(parseAsStream(""), Optional.empty());
*/

    }

    /**
     * Avoid NPE
     */
    public void testStateMachineNull(){
/*

        assertEquals(parseAsStream(null), Optional.empty());
*/

    }

}