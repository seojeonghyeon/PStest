package staticFactoryMethod;

public class Main {

    public static void main(String[] args){
        SettingDto settingDtoFactory = SettingDtoFactory.of("season");
    }
}
