package com.lab596.httpserver.http;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HttpParserTest {

    private HttpParser httpParser;

    @BeforeAll
    public void beforeClass() {
        httpParser = new HttpParser();
    }

    @Test
    void parseHTTpRequest() {
        HttpRequest request = null;
        try {
            request = httpParser.parseHTTpRequest(
                    generateValidGETTestCase()
            );
        } catch (HttpParsingException e) {
            fail(e);
        }

        assertEquals(request.getMethod(), HttpMethod.GET);
    }

    void parseHTTpRequestBadMethod() {
        try {
            HttpRequest request = httpParser.parseHTTpRequest(
                    generateBadTestCaseMethod()
            );
            fail();
        } catch (HttpParsingException e) {
            assertEquals(e.getErrorCode(), HttpStatusCodes.SERVER_ERROR_501_NOT_IMPLEMENTED);
        }

    }

    private InputStream generateValidGETTestCase() {
        String rawData = "GET / HTTP/1.1\r\r\n" +
                "Host: localhost:8080\r\n" +
                "Connection: keep-alive\r\n" +
                "sec-ch-ua: \" Not A;Brand\";v=\"99\", \"Chromium\";v=\"102\", \"Google Chrome\";v=\"102\"\r\n" +
                "sec-ch-ua-mobile: ?0\r\n" +
                "sec-ch-ua-platform: \"Windows\"\r\n" +
                "Upgrade-Insecure-Requests: 1\r\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.63 Safa12:57:35.169 [Thread-1] INFO com.lab596.httpserver.core.HttpConnectionWorkerThread - * Connection Processing Finished.\r\n" +
                "ri/537.36\r\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9\r\n" +
                "Sec-Fetch-Site: none\r\n" +
                "Sec-Fetch-Mode: navigate\r\n" +
                "Sec-Fetch-User: ?1\r\n" +
                "Sec-Fetch-Dest: document\r\n" +
                "Accept-Encoding: gzip, deflate, br\r\n" +
                "Accept-Language: en-US,en;q=0.9\r\n" +
                "\r\n";

        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(StandardCharsets.US_ASCII
                )
        );

        return inputStream;
    }

    private InputStream generateBadTestCaseMethod() {
        String rawData = "GET / HTTP/1.1\r\r\n" +
                "Host: localhost:8080\r\n" +
                "Accept-Language: en-US,en;q=0.9\r\n" +
                "\r\n";

        InputStream inputStream = new ByteArrayInputStream(
                rawData.getBytes(StandardCharsets.US_ASCII
                )
        );

        return inputStream;
    }


}