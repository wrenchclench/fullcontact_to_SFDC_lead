package fullContactInsights.services;

import fullContactInsights.model.FullContacToSalesforceLead;
import fullContactInsights.model.fullContact.PersonSummary;
import fullContactInsights.services.salesforce_rest.SalesforceRESTAPIService;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class FullContactService {

    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
    private static String leadId ;
    private static String baseUrl = "https://ap5.salesforce.com/services/data/v32.0";


    @Autowired
    RestTemplate restTemplate;

    // Access FullContact API via a given email address
    public PersonSummary searchByEmail(String email) {

        //FullContact API URL
        String fQuery = "https://api.fullcontact.com/v2/person.json?email=" + email + "&apiKey=";

        PersonSummary response = restTemplate.getForObject(fQuery, PersonSummary.class);

        // Save passed email to SFDC
        response.setEmail(email);

        // Connect with SFDC instance
        SalesforceRESTAPIService.authenticate();

        // Pull contact data from FullContact API and insert to SFDC as a new lead
        FullContacToSalesforceLead obj = convertFullContactToSFDC(response);

        return response;
    }

    // Pull First Name, Last Name, Country, City, Company and Title from PersonSummary objects into object to be sent to Salesforce
    //instance as a lead.
    // NOTE: Required fields for SFDC lead are: Last Name and Company. Lead will not be created if Company is null.
    public FullContacToSalesforceLead convertFullContactToSFDC(PersonSummary result) {

        System.out.println("\n_______________ Lead INSERT _______________");

        baseUrl = baseUrl + "/sobjects/Lead/";
        try {

            //create the JSON object containing the new lead details.
            JSONObject lead = new JSONObject();
            lead.put("FirstName", result.getContactInfo().getGivenName());
            lead.put("LastName", result.getContactInfo().getFamilyName());
            lead.put("Company", "Fake Company1"); //result.getOrganizations()[0].getName());
            lead.put("City", result.getDemographics().getLocationDeduced().getCity().getName());
            lead.put("Country", result.getDemographics().getLocationDeduced().getCountry().getName());
            lead.put("Title", result.getOrganizations()[0].getTitle());
            lead.put("Email", result.getEmail());

            System.out.println("JSON for lead record to be inserted:\n" + lead.toString(1));

            //Construct the objects needed for the request
            HttpClient httpClient = HttpClientBuilder.create().build();

            HttpPost httpPost = new HttpPost(baseUrl);
            httpPost.addHeader(SalesforceRESTAPIService.getOauthHeader());
            httpPost.addHeader(prettyPrintHeader);
            // The message we are going to post
            StringEntity body = new StringEntity(lead.toString(1));
            body.setContentType("application/json");
            httpPost.setEntity(body);

            //Make the request
            HttpResponse response = httpClient.execute(httpPost);

//            // Send SFDC Status to JSON
//            PersonSummary sp = new PersonSummary();
//            sp.setSfdcStatus(response.getStatusLine().getStatusCode());

            //Process the results
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 201) {
                String response_string = EntityUtils.toString(response.getEntity());
                JSONObject json = new JSONObject(response_string);
                // Store the retrieved lead id to use when we update the lead.
                leadId = json.getString("id");
                System.out.println("New Lead id from response: " + leadId);
            } else {
                System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
            }
        } catch (JSONException e) {
            System.out.println("Issue creating JSON or processing results");
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("Null Pointer Exception. Company Data not found. Lead not submitted to Salesforce.");

        }
        return null;
    }

}
