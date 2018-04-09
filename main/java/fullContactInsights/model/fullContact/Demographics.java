package fullContactInsights.model.fullContact;

public class Demographics {

    LocationDeduced locationDeduced;
    String gender;
    String locationGeneral;

    public LocationDeduced getLocationDeduced() {
        return locationDeduced;
    }

    public void setLocationDeduced(LocationDeduced locationDeduced) {
        this.locationDeduced = locationDeduced;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocationGeneral() {
        return locationGeneral;
    }

    public void setLocationGeneral(String locationGeneral) {
        this.locationGeneral = locationGeneral;
    }
}
