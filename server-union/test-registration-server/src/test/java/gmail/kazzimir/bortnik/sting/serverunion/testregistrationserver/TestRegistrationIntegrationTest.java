package gmail.kazzimir.bortnik.sting.serverunion.testregistrationserver;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.InstanceDTO;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestRegistrationIntegrationTest {
    @LocalServerPort
    int randomServerPort;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private RestTemplate restTemplateMock;

    @Test
    public void theRequestShouldReturnABadRequest_DoesNotPassValidation() {
        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        HttpStatus statusCode = restTemplate.postForEntity(url, new InstanceDTO(), null).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.BAD_REQUEST);
    }

    @Test
    public void checkValidationOnIpAddress_mustPassValidation() throws URISyntaxException {
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplateMock);
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("123.123.211.123", 2123);

        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + ipPortDTO.getIp() + ":" + ipPortDTO.getPort() + "/employee")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));

        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";

        instanceDTO.setIpPortDTO(ipPortDTO);
        HttpStatus statusCode = restTemplate.postForEntity(url, instanceDTO, null).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.CREATED);
    }

    @Test
    public void checkValidationOnIpAddress_musNotPassValidation() throws URISyntaxException {
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("123.123.211.123", 2123);

//        mockServer.expect(ExpectedCount.once(),
//                requestTo(new URI("http://" + ipPortDTO.getIp() + ":" + ipPortDTO.getPort() + "/employee")))
//                .andExpect(method(HttpMethod.GET))
//                .andRespond(withStatus(HttpStatus.OK));

        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";

        instanceDTO.setIpPortDTO(ipPortDTO);
        HttpStatus statusCode = restTemplate.postForEntity(url, instanceDTO, null).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.CREATED);
    }
}