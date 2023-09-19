package transport;

/**
 * 1、启动、监听
 * 2、接收请求，处理、响应
 * 3、关闭
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
