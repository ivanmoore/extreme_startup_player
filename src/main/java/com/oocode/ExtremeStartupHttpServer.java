package com.oocode;

import io.fusionauth.http.server.HTTPHandler;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;

import java.io.Writer;

public class ExtremeStartupHttpServer {
    private final HTTPServer server;

    public ExtremeStartupHttpServer(int port) {
        HTTPHandler handler = (req, res) -> {
            try(Writer writer = res.getWriter()) {
                writer.write("42");
            }
        };
        server = new HTTPServer().withHandler(handler).withListener(new HTTPListenerConfiguration(port));
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.close();
    }
}

