package com.company;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class SimpleBloomFilter {

    public static void main(String[] args) {

        //  Implement a bloom filter with add and check functions
        //Bloomfilter instance
	    com.google.common.hash.BloomFilter<String> bloomfilter = com.google.common.hash.BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 1000);

	    //Adding
	    bloomfilter.put("Frederikke");
	    bloomfilter.put("Simone");
	    bloomfilter.put("Lise");
	    bloomfilter.put("Sophie");
	    bloomfilter.put("hej");
	    bloomfilter.put("hallooooo");

	    //Checking
        System.out.println(bloomfilter.mightContain("Hans")); //false
        System.out.println(bloomfilter.mightContain("Frederikke")); //true
        System.out.println(bloomfilter.mightContain("Lise")); //true
        System.out.println(bloomfilter.mightContain("hejsa")); //false
        System.out.println(bloomfilter.mightContain("hej")); //true
        System.out.println(bloomfilter.mightContain("hallooooo")); // true

        // If you are to store one million ASCII strings with an average size of 10
        //characters in a hash set, what would be the approximate space consumption?

        // Space consumtion would be 1 million ASCII strings * 10 characters = 10.000.000

        //The following equation gives the required number of bits of space per
        //inserted key, where E is the false positive rate.
        // b = 1.44log2(1/E)

        // How many bits per element are required for a 1% false positive rate?

        double result = (1.44 * Math.log(1.0/0.01)/Math.log(2));
        System.out.println("The required amount of bits per element for a 1% positive rate is: " + result); // 9.567152913275605

        // How many bits per element are required for a 5% false positive rate?

        double result1 = (1.44 * Math.log(1.0/0.05)/Math.log(2));
        System.out.println("The required amount of bits per element for a 5% positive rate is: " + result1); //6.223576456637802

        // If you are to store one million ASCII strings with an average size of 10 characters in a bloom filter
        // What would be the approximate space consumption, given an allowed false positive rate of 5%?

        double result2 = result1 * 1000000;
        System.out.println("The approximate space consumtion would be: " + result2); // 6223576.456637802
    }
}
