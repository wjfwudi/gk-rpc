package server;

import com.smgeek.gkrpc.Request;
import com.smgeek.util.ReflectionUtils;

public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getArgs());
    }
}
