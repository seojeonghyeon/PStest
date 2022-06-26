package staticFactoryMethod;

public class FirstHalfORSecondHalfSettingDto implements SettingDto {
    private int numberOfLecture;
    private String courseSeasonName;
    private String englishCourseSeasonName;
    private boolean enabled;
    private boolean firstHalfORSecondHalf;

    private StudentDto studentDto;

    private static final FirstHalfORSecondHalfSettingDto SETTING_DTO = new FirstHalfORSecondHalfSettingDto();

    private FirstHalfORSecondHalfSettingDto(){}

    public static FirstHalfORSecondHalfSettingDto newInstance(){
        return SETTING_DTO;
    }

    public static FirstHalfORSecondHalfSettingDto enabledSettingDto(StudentDto studentDto){
        FirstHalfORSecondHalfSettingDto settingDto = newInstance();
        settingDto.enabled = true;
        settingDto.studentDto = studentDto;
        return settingDto;
    }

    public static FirstHalfORSecondHalfSettingDto seasonLectureEnrolmentDto(StudentDto studentDto){
        FirstHalfORSecondHalfSettingDto settingDto = newInstance();
        settingDto.firstHalfORSecondHalf = true;
        settingDto.studentDto = studentDto;
        return settingDto;
    }
}
