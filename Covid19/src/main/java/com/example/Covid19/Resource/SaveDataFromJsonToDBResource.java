package com.example.Covid19.Resource;

import com.example.Covid19.Service.SaveDataFromJsonToDBService;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController("SaveDataFromJsonToDBResource")
@RequestMapping("/saveData")
public class SaveDataFromJsonToDBResource {
    private final SaveDataFromJsonToDBService saveDataFromJsonToDBService;

    @Autowired
    public SaveDataFromJsonToDBResource(SaveDataFromJsonToDBService saveDataFromJsonToDBService) {
        this.saveDataFromJsonToDBService = saveDataFromJsonToDBService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void readDataFromJson() throws ParseException, IOException, JSONException {
        saveDataFromJsonToDBService.readDataFromJson();
    }
}
