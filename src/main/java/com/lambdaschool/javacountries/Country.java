package com.lambdaschool.javacountries;

public class Country
{
    private String name;
    private long population;
    private long size;
    private int medianAge;

    public Country(String name, long population, long size, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.size = size;
        this.medianAge = medianAge;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }
}
