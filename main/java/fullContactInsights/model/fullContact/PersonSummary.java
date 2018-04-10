package fullContactInsights.model.fullContact;

public class PersonSummary {

    int status;
    String requestId;
    double likelihood;
    Photos[] photos;
    ContactInfo contactInfo;
    Organizations[] organizations;
    Demographics demographics;
    SocialProfiles[] socialProfiles;
    DigitalFootprints digitalFootprint;
    String email;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public double getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(double likelihood) {
        this.likelihood = likelihood;
    }

    public Photos[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photos[] photos) {
        this.photos = photos;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Organizations[] getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organizations[] organizations) {
        this.organizations = organizations;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public SocialProfiles[] getSocialProfiles() {
        return socialProfiles;
    }

    public void setSocialProfiles(SocialProfiles[] socialProfiles) {
        this.socialProfiles = socialProfiles;
    }

    public DigitalFootprints getDigitalFootprint() {
        return digitalFootprint;
    }

    public void setDigitalFootprint(DigitalFootprints digitalFootprint) {
        this.digitalFootprint = digitalFootprint;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}