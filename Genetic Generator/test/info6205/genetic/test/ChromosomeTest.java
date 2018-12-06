/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.test;

import info6205.genetic.main.Chromosome;
import info6205.genetic.main.Genetic;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Juhi
 */

//Juhi Pareek test cases
public class ChromosomeTest {
    
    @Test
    public void testFitnessFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        Chromosome chromosome  = new Chromosome("Program Structure and Algorithms");
        assertEquals(0, chromosome.getFitness());
        
    }
    
    @Test
    public void testFitnessFunction2()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        Chromosome chromosome  = new Chromosome("Qsphsbn Tusvduvsf and Blgorithms");
        assertEquals(17, chromosome.getFitness());
    }
    
    @Test
    public void testRandomGeneFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        
        Chromosome chromosome;
        for(int i = 0 ; i < 10 ; i++)
        {
            chromosome = Chromosome.generateRandom();
            assertTrue(chromosome.getFitness() >= 0);
            assertEquals(32, chromosome.getGene().length());
            for(int j = 0 ; j<chromosome.getGene().length(); j++)
            {
                char c = chromosome.getGene().charAt(j);
                assertTrue(c>=32 && c<=121);
            }
        }
    }
    
    @Test 
    public void testMutateFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        
        Chromosome chromosome1, chromosome2;
        
        for(int i = 0 ; i < 10 ; i++)
        {
            chromosome1 = Chromosome.generateRandom();
            chromosome2 = chromosome1.mutate();
            
            assertEquals(chromosome1.getGene().length(), chromosome2.getGene().length());
            
            int difference = 0;
            //Obtain no of differences between the original string and mutated string
            for(int j = 0 ; j<chromosome1.getGene().length() ; j++)
            {
                if(chromosome1.getGene().charAt(j)!=chromosome2.getGene().charAt(j))
                    difference++;
            }
            
            assertTrue(difference<=1);
        }
    }
    
    @Test
    public void testMateFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        
        //Generate parents
        Chromosome parent1 = Chromosome.generateRandom();
        Chromosome parent2 = Chromosome.generateRandom();
        
        //Mate parents
        Chromosome[] children = parent1.mate(parent2);
        
        //Check no of children after mating
        assertEquals(2, children.length);
        
        //Check if length of each children is equal to parent
        assertEquals(32, children[0].getGene().length());
        assertEquals(32, children[1].getGene().length());
        
        int pivot;
        
        //Obtain pivot
        for(pivot = 0 ; pivot<parent1.getGene().length() ; pivot++)
        {
            if(parent1.getGene().charAt(pivot)!=children[0].getGene().charAt(pivot))
                break;
        }
        
        //Verify children1 content after mating
        for(int i = 0 ; i<children[0].getGene().length() ; i++)
        {
            if(i<pivot)
            {
                assertEquals(parent1.getGene().charAt(i), children[0].getGene().charAt(i));
            }
            else
            {
                assertEquals(parent2.getGene().charAt(i), children[0].getGene().charAt(i));
            }
        }
        
        //Verify children2 content after mating
        for(int i = 0 ; i<children[1].getGene().length() ; i++)
        {
            if(i<pivot)
            {
                assertEquals(parent2.getGene().charAt(i), children[1].getGene().charAt(i));
            }
            else
            {
                assertEquals(parent1.getGene().charAt(i), children[1].getGene().charAt(i));
            }
        }
        
    }
    
}
