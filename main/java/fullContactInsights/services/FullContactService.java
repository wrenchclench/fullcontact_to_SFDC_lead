package fullContactInsights.services;


import fullContactInsights.model.fullContact.PersonSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FullContactService {

    @Autowired
    RestTemplate restTemplate;

    // Access FullContact API via a given email address
    public PersonSummary searchByEmail(String query) {

        String fQuery = "https://api.fullcontact.com/v2/person.json?email=" + query + "&apiKey=9USxOV7iSFQDVg8xHnO4CDnRffCORa0I";

        PersonSummary response = restTemplate.getForObject(fQuery, PersonSummary.class);

        return response;
    }
}
