package com.jumia.interview.task;

import com.jumia.interview.task.model.entity.Country;
import com.jumia.interview.task.model.entity.PhoneNumber;
import com.jumia.interview.task.model.entity.Status;
import com.jumia.interview.task.repositories.CountryRepository;
import com.jumia.interview.task.repositories.PhoneNumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    private final CountryRepository countryRepository;
    private final PhoneNumberRepository phoneNumberRepository;

    public AppStartupRunner(CountryRepository countryRepository, PhoneNumberRepository phoneNumberRepository) {
        this.countryRepository = countryRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Your application started with option names : {}", args.getOptionNames());

        countryRepository.save(new Country("Test Country", "226", "regex"));
        phoneNumberRepository.save(new PhoneNumber("Test Country", "226", Status.VALID));

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            ResultSet rs = statement.executeQuery("select * from customer");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));

                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                Pattern p = Pattern.compile("\\((\\d*)\\) (\\d*)");
                Matcher m = p.matcher(phone);

                if (m.find()) {
                    String phoneNumber = m.group(0);
                    String countryCode = m.group(1);
                    String phoneNumberPostfix = m.group(2);
                    String countryRegex;
                    switch (countryCode){
                        case "237":

                            countryRegex = "\\(237\\)\\ ?[2368]\\d{7,8}$";

                            countryRepository.save(new Country("Cameroon", "237", countryRegex));

                            if(phoneNumber.matches(countryRegex)) {
                                phoneNumberRepository.save(new PhoneNumber("Cameroon", phoneNumberPostfix, Status.VALID));

                            }else {
                                phoneNumberRepository.save(new PhoneNumber("Cameroon", phoneNumberPostfix, Status.UNVALID));
                            }
                            break;
                        case "251":
                            countryRegex = "\\(251\\)\\ ?[1-59]\\d{8}$";

                            countryRepository.save(new Country("Ethiopia", "251", countryRegex));

                            if(phoneNumber.matches(countryRegex) == true) {
                                phoneNumberRepository.save(new PhoneNumber("Ethiopia", phoneNumberPostfix, Status.VALID));

                            }else {
                                phoneNumberRepository.save(new PhoneNumber("Ethiopia", phoneNumberPostfix, Status.UNVALID));
                            }
                            break;
                        case "212":
                            countryRegex = "\\(212\\)\\ ?[5-9]\\d{8}$";

                            countryRepository.save(new Country("Morocco", "212", countryRegex));

                            if(phoneNumber.matches(countryRegex) == true) {
                                phoneNumberRepository.save(new PhoneNumber("Morocco", phoneNumberPostfix, Status.VALID));

                            }else {
                                phoneNumberRepository.save(new PhoneNumber("Morocco", phoneNumberPostfix, Status.UNVALID));
                            }
                            break;
                        case "258":
                            countryRegex = "\\(258\\)\\ ?[28]\\d{7,8}$";

                            countryRepository.save(new Country("Mozambique", "258", countryRegex));

                            if(phoneNumber.matches(countryRegex) == true) {
                                phoneNumberRepository.save(new PhoneNumber("Mozambique", phoneNumberPostfix, Status.VALID));

                            }else {
                                phoneNumberRepository.save(new PhoneNumber("Mozambique", phoneNumberPostfix, Status.UNVALID));
                            }
                            break;
                        case "256":
                            countryRegex = "\\(256\\)\\ ?\\d{9}$";

                            countryRepository.save(new Country("Uganda", "256", countryRegex));

                            if(phoneNumber.matches(countryRegex) == true) {
                                phoneNumberRepository.save(new PhoneNumber("Uganda", phoneNumberPostfix, Status.VALID));

                            }else {
                                phoneNumberRepository.save(new PhoneNumber("Uganda", phoneNumberPostfix, Status.UNVALID));
                            }
                            break;
                        default:
                            // special cases to be handled for undefined countries in the DB
                    }
                }

            }
        }
        catch(SQLException e)
        {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}