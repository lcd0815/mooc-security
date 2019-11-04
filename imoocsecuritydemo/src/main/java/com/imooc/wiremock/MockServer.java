package com.imooc.wiremock;



import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @Author: 李存东
 * @Date: 2019/10/30
 * @Description:
 */
public class MockServer {
    public static void main(String[] args) throws IOException {
        configureFor(8062);
        removeAllMappings();

        mock("/order/1", "01");
        mock("/order/2", "02");

    }

    private static void mock(String url, String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("mock/response/"+fileName+".txt");
        List<String> list = FileUtils.readLines(resource.getFile(), "UTF-8");
        String content = StringUtils.join(list.toArray(), "\n");
        stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
    }
}
