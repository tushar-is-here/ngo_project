package com.ngo.project.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSequenceId implements Serializable {
    private String date;
    private char firstLetter;
    private char gender;
}
