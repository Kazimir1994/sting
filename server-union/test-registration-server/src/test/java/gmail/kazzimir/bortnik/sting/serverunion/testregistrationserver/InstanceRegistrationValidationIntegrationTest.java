package gmail.kazzimir.bortnik.sting.serverunion.testregistrationserver;

import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.components.chain.ValidationResultNodeMessageEnum;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.model.ValidationErrorResponse;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.controller.validation.model.Violation;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.InstanceDTO;
import gmail.kazzimir.bortnik.sting.serverunion.registrationserver.model.dto.IpPortDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InstanceRegistrationValidationIntegrationTest {
    @LocalServerPort
    int randomServerPort;
    @Autowired
    private TestRestTemplate restTemplateMock;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void theRequestShouldReturnABadRequest_CheckingForEmptyInput() {
        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        HttpStatus statusCode = restTemplateMock.postForEntity(url, null, null).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Test
    public void theRequestShouldReturnABadRequest_DoesNotPassValidation_IPMustNotBeNull() {
        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        ResponseEntity<ValidationErrorResponse> stringResponseEntity = restTemplateMock.postForEntity(url, new InstanceDTO(), ValidationErrorResponse.class);
        ValidationErrorResponse validationErrorResponse = Objects.requireNonNull(stringResponseEntity.getBody());

        ValidationErrorResponse validationErrorResponseTest = new ValidationErrorResponse();
        Violation violationTest = new Violation("ipPortDTO", ValidationResultNodeMessageEnum.NULL.toString());
        validationErrorResponseTest.add(violationTest);

        Assert.assertEquals(validationErrorResponse, validationErrorResponseTest);
        Assert.assertEquals(stringResponseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void theRequestShouldReturnABadRequest_DoesNotPassValidation_IPDoesNotMatchValidationPattern() {
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("W34E", 2123);
        instanceDTO.setIpPortDTO(ipPortDTO);

        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        ResponseEntity<ValidationErrorResponse> stringResponseEntity = restTemplateMock.postForEntity(url, instanceDTO, ValidationErrorResponse.class);
        ValidationErrorResponse validationErrorResponse = Objects.requireNonNull(stringResponseEntity.getBody());

        ValidationErrorResponse validationErrorResponseTest = new ValidationErrorResponse();
        Violation violationTest = new Violation("ipPortDTO", ValidationResultNodeMessageEnum.NOT_MATCH.toString());
        validationErrorResponseTest.add(violationTest);

        Assert.assertEquals(validationErrorResponse, validationErrorResponseTest);
        Assert.assertEquals(stringResponseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void theRequestShouldReturnABadRequest_DoesNotPassValidation_TheSpecifiedPortCannotExist() {
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("123.123.211.123", -43);
        instanceDTO.setIpPortDTO(ipPortDTO);

        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        ResponseEntity<ValidationErrorResponse> stringResponseEntity = restTemplateMock.postForEntity(url, instanceDTO, ValidationErrorResponse.class);
        ValidationErrorResponse validationErrorResponse = Objects.requireNonNull(stringResponseEntity.getBody());

        ValidationErrorResponse validationErrorResponseTest = new ValidationErrorResponse();
        Violation violationTest = new Violation("ipPortDTO", ValidationResultNodeMessageEnum.NONEXISTENT_PORT.toString());
        validationErrorResponseTest.add(violationTest);

        Assert.assertEquals(validationErrorResponse, validationErrorResponseTest);
        Assert.assertEquals(stringResponseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    public void theRequestShouldReturnABadRequest_DoesNotPassValidation_IPAddressNotAvailable() {
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("123.123.211.123", 2123);
        instanceDTO.setIpPortDTO(ipPortDTO);

        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";
        ResponseEntity<ValidationErrorResponse> stringResponseEntity = restTemplateMock.postForEntity(url, instanceDTO, ValidationErrorResponse.class);
        ValidationErrorResponse validationErrorResponse = Objects.requireNonNull(stringResponseEntity.getBody());

        ValidationErrorResponse validationErrorResponseTest = new ValidationErrorResponse();
        Violation violationTest = new Violation("ipPortDTO", ValidationResultNodeMessageEnum.IP_ADDRESS_NOT_AVAILABLE.toString());
        validationErrorResponseTest.add(violationTest);

        Assert.assertEquals(validationErrorResponse, validationErrorResponseTest);
        Assert.assertEquals(stringResponseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void theRequestShouldReturnACreated_MustPassAllValidation() throws URISyntaxException {
        InstanceDTO instanceDTO = new InstanceDTO();
        IpPortDTO ipPortDTO = new IpPortDTO("113.123.211.123", 2123);
        instanceDTO.setIpPortDTO(ipPortDTO);

        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);
        mockServer.expect(ExpectedCount.once(),
                requestTo(new URI("http://" + ipPortDTO.getIp() + ":" + ipPortDTO.getPort() + "/check")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.OK));
        final String url = "http://localhost:" + randomServerPort + "/api/v1/registration";

        HttpStatus statusCode = restTemplateMock.postForEntity(url, instanceDTO, null).getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.CREATED);
    }
}