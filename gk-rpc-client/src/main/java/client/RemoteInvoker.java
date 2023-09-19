package client;

import codec.Decoder;
import codec.Encoder;
import com.smgeek.gkrpc.Request;
import com.smgeek.gkrpc.Response;
import com.smgeek.gkrpc.ServiceDescriptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import transport.TransportClient;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class RemoteInvoker implements InvocationHandler {

    private Class clazz;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;
    public <T> RemoteInvoker(Class<T> clazz, Encoder encoder, Decoder decoder, TransportSelector selector) {
        this.clazz = clazz;
        this.encoder = encoder;
        this.decoder = decoder;
        this.selector = selector;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setService(ServiceDescriptor.from(clazz, method));
        request.setArgs(args);

        Response resp = invokeRemote(request);
        if (resp == null || resp.getCode() != 0) {
            throw new IllegalStateException("fail to invoke remote: " + resp);
        }
        return resp.getData();
    }

    private Response invokeRemote(Request request) {
        Response resp = null;
        TransportClient client = null;

        try {
            client = selector.select();
            byte[] outBytes = encoder.encode(request);
            InputStream receive = client.write(new ByteArrayInputStream(outBytes));
            byte[] inBytes = IOUtils.readFully(receive, receive.available());
            resp = decoder.decode(inBytes, Response.class);
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            resp = new Response();
            resp.setCode(1);
            resp.setMessage("RpcClient got error: " + e.getClass() + " " + e.getMessage());
        } finally {
            if (client != null) {
                selector.release(client);
            }
        }
        return resp;
    }
}
