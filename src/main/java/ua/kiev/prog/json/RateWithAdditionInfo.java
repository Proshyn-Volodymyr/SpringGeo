package ua.kiev.prog.json;

import ua.kiev.prog.dto.LocationDTO;

public class RateWithAdditionInfo {
    private Rate rate;
    private LocationDTO locationDTO;

    public RateWithAdditionInfo(Rate rate, LocationDTO locationDTO) {
        this.rate = rate;
        this.locationDTO = locationDTO;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public LocationDTO getLocationDTO() {
        return locationDTO;
    }

    public void setLocationDTO(LocationDTO locationDTO) {
        this.locationDTO = locationDTO;
    }
}
