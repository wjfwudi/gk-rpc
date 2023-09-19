package codec;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {

    @Test
    public void decode() {
        Encoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setName("swx");
        bean.setAge(28);

        byte[] bytes = encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean2 = decoder.decode(bytes, TestBean.class);
        Assert.assertEquals(bean.getName(), bean2.getName());
        Assert.assertEquals(bean.getAge(), bean2.getAge());
    }
}