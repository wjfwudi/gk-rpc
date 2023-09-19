package codec;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JSONEncoderTest {

    @Test
    public void encode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("swx");
        bean.setAge(28);

        byte[] bytes = encoder.encode(bean);
        Assert.assertNotNull(bytes);
    }
}