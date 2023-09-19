package com.smgeek.gkrpc;

import lombok.Data;

@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] args;
}
