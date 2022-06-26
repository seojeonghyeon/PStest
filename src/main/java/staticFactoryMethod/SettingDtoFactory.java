package staticFactoryMethod;

public class SettingDtoFactory {
    public static SettingDto of(String settingName){
        if(settingName.equals("season")){
            return SeasonSettingDto.newInstance();
        }else{
            return FirstHalfORSecondHalfSettingDto.newInstance();
        }
    }
}
