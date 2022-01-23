public class LocalizationServiceImpl implements LocalizationService {

    public String locale(Country country) {
        if (country == Country.RUSSIA) {
            return "Добро пожаловать";
        } else {
            return "Welcome";
        }
    }
}