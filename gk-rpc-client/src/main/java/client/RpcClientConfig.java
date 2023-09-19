package client;

import codec.Decoder;
import codec.Encoder;
import codec.JSONDecoder;
import codec.JSONEncoder;
import com.smgeek.gkrpc.Peer;
import lombok.Data;
import transport.HttpTransportClient;
import transport.TransportClient;

import java.util.Collections;
import java.util.List;

@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Collections.singletonList(new Peer("127.0.0.1", 3000));
}
