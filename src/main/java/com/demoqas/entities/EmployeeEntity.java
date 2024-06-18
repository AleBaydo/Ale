package com.demoqas.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class EmployeeEntity {

    private String firstname;
    private String lastname;
    private int age;
    private String email;
    private Long salary;
    private String department;




}
