package transport;

import com.smgeek.gkrpc.Peer;

import java.io.InputStream;

public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
