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
            try (Writer writer = res.getWriter()) {
                writer.write(responseForQuery(req.getParameter("q")));
            }
        };
        server = new HTTPServer().withHandler(handler).withListener(new HTTPListenerConfiguration(port));
    }

    private static String responseForQuery(String queryEncoded) {
        if (queryEncoded == null) {
            return HomePage.HTML;
        } else {
            String value = QueryDecoder.decode(queryEncoded);
            System.out.println("value = " + value);
            return new Answerer().answerFor(value);
        }
    }

    public void start() {
        server.start();
    }

    public void stop() {
        server.close();
    }
}

