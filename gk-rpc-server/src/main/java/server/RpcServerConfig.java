package server;

import codec.Decoder;
import codec.Encoder;
import codec.JSONDecoder;
import codec.JSONEncoder;
import lombok.Data;
import transport.HttpTransportServer;
import transport.TransportServer;

/**
 * server配置
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JSONEncoder.class;
    private Class<? extends Decoder> decoderClass = JSONDecoder.class;
    private int port = 3000;
}
