package com.oocode;

import io.fusionauth.http.server.HTTPHandler;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;

import java.io.Writer;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ExtremeStartupHttpServer {
    private final HTTPServer server;

    public static void main(String[] args) throws Exception {
        int port = 8123;
        System.out.println("Starting server for: http://" + myIpAddress() + ":" + port);
        new ExtremeStartupHttpServer(port).start();
    }

    private static String myIpAddress() throws UnknownHostException, SocketException {
        try (final DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
            return datagramSocket.getLocalAddress().getHostAddress();
        }
    }

    public ExtremeStartupHttpServer(int port) {
        HTTPHandler handler = (req, res) -> {
            String value = QueryDecoder.decode(req.getParameter("q"));
            System.out.println("value = " + value);
            try (Writer writer = res.getWriter()) {
                writer.write("Someone");
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

