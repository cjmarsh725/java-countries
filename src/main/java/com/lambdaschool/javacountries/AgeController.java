package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class AgeController
{
    @RequestMapping("/age")
    public ArrayList<Country> getCountriesByAge(@RequestParam(value = "age") int age)
    {
        JavacountriesApplication.countryListObj.countryList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        ArrayList<Country> countries = new ArrayList<>();
        for (Country c : JavacountriesApplication.countryListObj.countryList)
        {
            if (c.getMedianAge() >= age) {
                countries.add(c);
            }
        }
        return countries;
    }

    @RequestMapping("/min")
    public Country getLowestAge()
    {
        JavacountriesApplication.countryListObj.countryList
                .sort(Comparator.comparing(Country::getMedianAge));
        return JavacountriesApplication.countryListObj.countryList.get(0);
    }

    @RequestMapping("/max")
    public Country getHighestAge()
    {
        JavacountriesApplication.countryListObj.countryList
                .sort((c1, c2) -> (c2.getMedianAge() - c1.getMedianAge()));
        return JavacountriesApplication.countryListObj.countryList.get(0);
    }
}
