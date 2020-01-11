package com.helioluna.rabec.domain;

import com.helioluna.rabec.util.interfaces.Save;
import com.helioluna.rabec.util.interfaces.Update;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Document
@Setter
@Getter
public class Complaint {

    public Complaint(String id, String description, City locale, Company company) {
        this.id = id;
        this.description = description;
        this.locale = locale;
        this.company = company;
    }

    @Id
    @NotBlank(message = "Id required.", groups = {Update.class})
    private String id;

    @NotBlank(message = "Description required.", groups = {Save.class, Update.class})
    private String description;

    @DBRef
    @NotNull(message = "City required.", groups = {Save.class, Update.class})
    private City locale;

    @DBRef
    @NotNull(message = "Company required.", groups = {Save.class, Update.class})
    private Company company;

}
