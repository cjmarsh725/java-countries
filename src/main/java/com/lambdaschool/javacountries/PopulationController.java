package com.lambdaschool.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    @RequestMapping("/size")
    public ArrayList<Country> getCountriesByPopulation(@RequestParam(value = "people") long people)
    {
        JavacountriesApplication.countryListObj.countryList.sort((e1, e2) ->
                e1.getName().compareToIgnoreCase(e2.getName()));
        ArrayList<Country> countries = new ArrayList<>();
        for (Country c : JavacountriesApplication.countryListObj.countryList)
        {
            if (c.getPopulation() >= people) {
                countries.add(c);
            }
        }
        return countries;
    }

    @RequestMapping("/min")
    public Country getSmallestPop()
    {
        JavacountriesApplication.countryListObj.countryList
                .sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        return JavacountriesApplication.countryListObj.countryList.get(0);
    }

    @RequestMapping("/max")
    public Country getLargestPop()
    {
        JavacountriesApplication.countryListObj.countryList
                .sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));
        return JavacountriesApplication.countryListObj.countryList.get(0);
    }
}
