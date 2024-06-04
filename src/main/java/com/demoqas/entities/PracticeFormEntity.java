package com.demoqas.entities;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class PracticeFormEntity {
        private String firstName;
        private String lastName;
        private String email;
        private String mobileNumber;
        private String dateOfBirthInput;
        private String genderMaleInput;
        private String genderFemaleInput;
        private String genderOtherInput;
        private String subjects;
        private String subjects2;
        private String hobbiesSportsInput;
        private String hobbiesReadingInput;
        private String hobbiesMusicInput;
        private String currentAddress;
        private String uploadPicture;
        private String SelectState;
        private String SelectCity;
        private String closeLargeInput;

}