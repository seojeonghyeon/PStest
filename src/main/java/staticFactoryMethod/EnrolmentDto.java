package staticFactoryMethod;

public class EnrolmentDto {
    private String lectureName;
    private boolean prime;
    private boolean urgent;

    private StudentDto studentDto;

    private EnrolmentDto(){}

    public static EnrolmentDto primeEnrolmentDto(StudentDto studentDto){
        EnrolmentDto enrolmentDto = new EnrolmentDto();
        enrolmentDto.prime = true;
        enrolmentDto.urgent = false;
        enrolmentDto.studentDto = studentDto;
        return enrolmentDto;
    }

    public static EnrolmentDto urgentEnrolmentDto(StudentDto studentDto){
        EnrolmentDto enrolmentDto = new EnrolmentDto();
        enrolmentDto.prime = false;
        enrolmentDto.urgent = true;
        enrolmentDto.studentDto = studentDto;
        return enrolmentDto;
    }
}
