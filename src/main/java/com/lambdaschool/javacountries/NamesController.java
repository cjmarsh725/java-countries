package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController
{
    @RequestMapping("/all")
    public ArrayList<String> getAllCountries()
    {
        JavacountriesApplication.countryListObj.countryList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        ArrayList<String> names = new ArrayList<>();
        for (Country c : JavacountriesApplication.countryListObj.countryList)
        {
            names.add(c.getName());
        }
        return names;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> getCountriesBeginningWith(@RequestParam(value = "letter") String letter)
    {

        JavacountriesApplication.countryListObj.countryList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        ArrayList<Country> countries = new ArrayList<>();
        for (Country c : JavacountriesApplication.countryListObj.countryList)
        {
            if (c.getName().startsWith(letter.toUpperCase())) {
                countries.add(c);
            }
        }
        return countries;
    }

    @RequestMapping("/size")
    public ArrayList<Country> getCountriesByNameLength(@RequestParam(value = "letters") int letters)
    {
        JavacountriesApplication.countryListObj.countryList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        ArrayList<Country> countries = new ArrayList<>();
        for (Country c : JavacountriesApplication.countryListObj.countryList)
        {
            if (c.getName().length() >= letters) {
                countries.add(c);
            }
        }
        return countries;
    }
}
