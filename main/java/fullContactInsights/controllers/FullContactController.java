package fullContactInsights.controllers;

import fullContactInsights.model.fullContact.PersonSummary;
import fullContactInsights.services.FullContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class FullContactController {

    @RestController
    @RequestMapping("/fullcontact")
    public class FCController {

        @Autowired
        FullContactService fcService;

        //Controller to pull FullContact data using only an email address
        @RequestMapping("/email")
        public PersonSummary searchByEmail(@RequestParam(value = "query", defaultValue = "email") String query) {

            return fcService.searchByEmail(query);
        }
    }
}
