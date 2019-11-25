package com.CALV.RilDilBBQ.Controller;
import com.CALV.RilDilBBQ.ContactUs;
import com.CALV.RilDilBBQ.ContactUsRepository;
import com.CALV.RilDilBBQ.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/api")
public class ContactUsController {
    @Autowired
    ContactUsRepository contactUsRepository;
    // Get All contactUs
    @GetMapping("/contactUs")
    public List<ContactUs> getAllContactUs() {
        return contactUsRepository.findAll();
    }
    // Create a new contactUs
    @PostMapping("/contactUs")
    public ContactUs createContactUs(@Valid @RequestBody ContactUs contactUs) {
        return contactUsRepository.save(contactUs);
    }
    // Get a Single contactUs
    @GetMapping("/contactUs/{id}")
    public ContactUs getContactUsById(@PathVariable(value = "id") Long contactUsId) {
        return contactUsRepository.findById(contactUsId)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs", "id", contactUsId));
    }
    // Update a contactUs
    @PutMapping("/contactUs/{id}")
    public ContactUs updateContactUs(@PathVariable(value = "id") Long contactUsId,
                                            @Valid @RequestBody ContactUs contactUsDetails) {
    	ContactUs contactUs = contactUsRepository.findById(contactUsId)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs", "id", contactUsId));
    	contactUs.setFirstName(contactUsDetails.getFirstName());
    	contactUs.setLastName(contactUsDetails.getLastName());
    	contactUs.setStreetAddress(contactUsDetails.getStreetAddress());
    	contactUs.setCity(contactUsDetails.getCity());
    	contactUs.setState(contactUsDetails.getState());
    	contactUs.setZip(contactUsDetails.getZip());
    	contactUs.setNumberOfGuests(contactUsDetails.getNumberOfGuests());
    	contactUs.setDescriptionOfRequest(contactUsDetails.getDescriptionOfRequest());
        ContactUs updatedContactUs = contactUsRepository.save(contactUs);
        return updatedContactUs;
    }
    // Delete a ContactUs
    @DeleteMapping("/contactUs/{id}")
    public ResponseEntity<?> deleteContactUs(@PathVariable(value = "id") Long contactUsId) {
    	ContactUs contactUs = contactUsRepository.findById(contactUsId)
                .orElseThrow(() -> new ResourceNotFoundException("ContactUs", "id", contactUsId));
    	contactUsRepository.delete(contactUs);
        return ResponseEntity.ok().build();
    }
}