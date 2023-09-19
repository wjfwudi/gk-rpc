package com.smgeek.gkrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 定义网络传输的端点
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
