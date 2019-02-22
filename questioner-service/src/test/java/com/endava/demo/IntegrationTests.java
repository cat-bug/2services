package com.endava.demo;

import com.endava.demo.properties.ClientProperties;
import com.endava.demo.service.ClientService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;

import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {

    @Rule
    public GenericContainer respondentService = new GenericContainer("catbug/respondent-service:latest").withExposedPorts(8081);

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientProperties clientProperties;

    @Before
    public void before(){
        clientProperties.setUrl("http://" + respondentService.getContainerIpAddress() + ":" + respondentService.getFirstMappedPort());
    }

    @Test
    public void integrationTest() {
        String respondentServiceResponse = clientService.ask();
        assert respondentServiceResponse.equals("good morning!");
    }

}
