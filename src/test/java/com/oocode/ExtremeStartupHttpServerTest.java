package com.oocode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URLEncoder;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExtremeStartupHttpServerTest {
    private ExtremeStartupHttpServer server;

    @Test
    public void canAnswerSimpleAddition() throws Exception {
        var contents = new SimpleHttpClient().readUrl("http://127.0.0.1:9123?q=" + URLEncoder.encode("What+is+your+name%3F", UTF_8));

        assertThat(contents, equalTo("Someone"));
    }

    @BeforeEach
    public void startLocalServerPretendingToBeExternalDependency() {
        server = new ExtremeStartupHttpServer(9123);
        server.start();
    }

    @AfterEach
    public void stopLocalServerPretendingToBeNationalGridEso() {
        server.stop();
    }
}
