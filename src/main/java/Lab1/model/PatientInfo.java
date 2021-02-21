package Lab1.model;


public class PatientInfo {
    private int identificationNumber;
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private long phoneNumber;
    private int medicalCardNumber;
    private String diagnosis;

    PatientInfo(int identificationNumber, String name, String surname, String patronymic, String address, long phoneNumber, int medicalCardNumber, String diagnosis) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return String.format("%20s%20s%20s%30s%30s%30s%30s%30s",
                identificationNumber,
                name,
                surname,
                patronymic,
                address,
                phoneNumber,
                medicalCardNumber,
                diagnosis
        );
    }
}
