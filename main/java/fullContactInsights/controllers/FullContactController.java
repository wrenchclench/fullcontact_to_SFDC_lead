package fullContactInsights.controllers;

import fullContactInsights.model.fullContact.PersonSummary;
import fullContactInsights.services.FullContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fullcontact")
public class FullContactController {

    @Autowired
    FullContactService fcService;

    @RequestMapping("/email")
    public PersonSummary searchByEmail(@RequestParam(value = "query", defaultValue = "email") String query) {

        return fcService.searchByEmail(query);
    }

}
