package com.helioluna.rabec.domain;

import com.helioluna.rabec.util.interfaces.Save;
import com.helioluna.rabec.util.interfaces.Update;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Document
@Setter
@Getter
public class City {

    public City(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @NotBlank(message = "Id required.", groups = {Update.class})
    private String id;

    @NotBlank(message = "Name required.", groups = {Save.class, Update.class})
    private String name;
}
