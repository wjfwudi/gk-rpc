package org.xhystudy.rpc.router;


/**
 * @description: 负载均衡工厂

 */
public class LoadBalancerFactory {

    public static LoadBalancer get(String serviceLoadBalancer) throws Exception {

        return ExtensionLoader.getInstance().get(serviceLoadBalancer);

    }

    public static void init() throws Exception {
        ExtensionLoader.getInstance().loadExtension(LoadBalancer.class);
    }

}
