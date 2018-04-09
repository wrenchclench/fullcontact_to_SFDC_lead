package fullContactInsights.model.fullContact;

public class LocationDeduced {

    String normalizedLocation;
    String deducedLocation;
    City city;
    State state;
    Country country;
    Continent continent;
    County county;
    int likelihood;

    public String getNormalizedLocation() {
        return normalizedLocation;
    }

    public void setNormalizedLocation(String normalizedLocation) {
        this.normalizedLocation = normalizedLocation;
    }

    public String getDeducedLocation() {
        return deducedLocation;
    }

    public void setDeducedLocation(String deducedLocation) {
        this.deducedLocation = deducedLocation;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }

    public int getLikelihood() {
        return likelihood;
    }

    public void setLikelihood(int likelihood) {
        this.likelihood = likelihood;
    }
}
