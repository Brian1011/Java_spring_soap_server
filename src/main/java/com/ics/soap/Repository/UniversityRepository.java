package com.ics.soap.Repository;

import localhost._7991.universities.University;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UniversityRepository {
    private Map<String, University> universities = new HashMap<>();

    @PostConstruct
    private void loadData() {
//        Strathmore
        University strathmore = new University();
        strathmore.setName("Strathmore");
        strathmore.setLocation("Madaraka");
        strathmore.setYearFounded("1961");
        universities.put(strathmore.getName(), strathmore);
        universities.put(strathmore.getLocation(), strathmore);
        universities.put(strathmore.getYearFounded(), strathmore);

//        JKUAT
        University jkuat = new University();
        jkuat.setName("Jomo Kenyatta University");
        jkuat.setLocation("Juja");
        jkuat.setYearFounded("1994");
        universities.put(jkuat.getName(), jkuat);
        universities.put(jkuat.getLocation(), jkuat);
        universities.put(jkuat.getYearFounded(), jkuat);

//        KU
        University ku = new University();
        ku.setName("Kenyatta University");
        ku.setLocation("Thika");
        ku.setYearFounded("1985");
        universities.put(ku.getName(), ku);
        universities.put(ku.getLocation(), ku);
        universities.put(ku.getYearFounded(), ku);
    }

    // get university by name
    public University getUniversityByName(String name) {
        return universities.get(name);
    }

    // get university by location
    public University getUniversityByLocation(String location){
        return universities.get(location);
    }

    // get by year founded
    public List<University> getByYearFounded(String year){
        //return new ArrayList<>(universities.get(year));
        return new ArrayList<>(universities.values());
    }

    // get a list of university
    public List<University> getAllUniversities(){
        return new ArrayList<>(universities.values());
    }
}
