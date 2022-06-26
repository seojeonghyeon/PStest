package staticFactoryMethod;

public class SeasonSettingDto implements SettingDto {
    private int numberOfLecture;
    private String courseSeasonName;
    private String englishCourseSeasonName;
    private boolean enabled;
    private boolean firstHalfORSecondHalf;

    private StudentDto studentDto;

    private static final SeasonSettingDto SETTING_DTO = new SeasonSettingDto();

    private SeasonSettingDto(){}

    public static SeasonSettingDto newInstance(){
        return SETTING_DTO;
    }

    public static SeasonSettingDto enabledSettingDto(StudentDto studentDto){
        SeasonSettingDto settingDto = newInstance();
        settingDto.enabled = true;
        settingDto.studentDto = studentDto;
        return settingDto;
    }

    public static SeasonSettingDto seasonLectureEnrolmentDto(StudentDto studentDto){
        SeasonSettingDto settingDto = newInstance();
        settingDto.firstHalfORSecondHalf = true;
        settingDto.studentDto = studentDto;
        return settingDto;
    }
}
