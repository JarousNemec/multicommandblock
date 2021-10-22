package com.strejdajara.multicommandblock.prototipesCODE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strejdajara.multicommandblock.prototipesCODE.Company;
import com.strejdajara.multicommandblock.prototipesCODE.Staff;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestJSON {
    public static void main(String[] args) {

    }
}




class JacksonExample1 {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createStaff("franta");
        Staff staff2 = createStaff("pepa");

        Company company = new Company();
        company.setEmployees(Arrays.asList(staff, staff2));


        try {

            // Java objects to JSON file
            mapper.writeValue(new File("c:\\test\\staff.json"), company);
/*
            // Java objects to JSON string - compact-print
            String jsonString = mapper.writeValueAsString(staff);

            System.out.println(jsonString);
*/
            // Java objects to JSON string - pretty-print
            String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(company);

            System.out.println(jsonInString2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static Staff createStaff(String name) {

        Staff staff = new Staff();

        staff.setName(name);
        staff.setAge(38);
        String[] position = new String[]{"Founder", "CTO", "Writer"};
        staff.setPosition(position);
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

}