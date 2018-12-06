/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.test;

import info6205.genetic.main.Chromosome;
import info6205.genetic.main.Genetic;
import info6205.genetic.main.Population;
import java.util.Arrays;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Juhi
 */

//Juhi Pareek Test cases
public class PopulationTest {
    
    @Test
    public void testGetCrossoverFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        
        Population pop = new Population(1024, 0.7f, 0.1f, 0.05f);
        assertEquals(70, (int) (pop.getCrossover() * 100));

        pop = new Population(1024, 0.0f, 0.1f, 0.05f);
        assertEquals(0, (int) (pop.getCrossover() * 100));
        
        pop = new Population(1024, 1.0f, 0.1f, 0.05f);
        assertEquals(100, (int) (pop.getCrossover() * 100));
        
    }
    
    @Test
    public void testGetElitismFunction()
    {
        Genetic genetic = new Genetic();
        genetic.setTargetString("Program Structure and Algorithms");
        
        Population pop = new Population(1024, 0.8f, 0.3f, 0.05f);
        assertEquals(30, (int) (pop.getElitism() * 100));

        pop = new Population(1024, 0.8f, 0.0f, 0.05f);
        assertEquals(0, (int) (pop.getElitism() * 100));

        pop = new Population(1024, 0.8f, 0.99f, 0.05f);
        assertEquals(99, (int) (pop.getElitism() * 100));
    }
    
    @Test
    public void testGetMutationFunction() {
        
            Genetic genetic = new Genetic();
            genetic.setTargetString("Program Structure and Algorithms");
        
            Population pop = new Population(1024, 0.8f, 0.1f, 0.04f);
            assertEquals(4, (int) (pop.getMutation() * 100));

            pop = new Population(1024, 0.8f, 0.1f, 0.0f);
            assertEquals(0, (int) (pop.getMutation() * 100));

            pop = new Population(1024, 0.8f, 0.1f, 1.0f);
            assertEquals(100, (int) (pop.getMutation() * 100));
    }
    
    @Test
    public void testGetPopulationFunction() {
            Population population   = new Population(1000, 0.8f, 0.1f, 0.05f);
            Chromosome[] chromosomeArr = population.getPopulation();

            assertEquals(1000, chromosomeArr.length);

            Chromosome[] newChromosomeArr = new Chromosome[chromosomeArr.length];
            System.arraycopy(chromosomeArr, 0, newChromosomeArr, 0, newChromosomeArr.length);
            Arrays.sort(newChromosomeArr);

            // Check if the array is actually sorted.
            assertArrayEquals(chromosomeArr, newChromosomeArr);
    }
    
    @Test
    public void testEvolveFunction() {
        
            Genetic genetic = new Genetic();
            genetic.setTargetString("Program Structure and Algorithms");
            
            Population pop = new Population(1024, 0.8f, 0.1f, 0.05f);
            Chromosome[] oldChromosomeArr = pop.getPopulation();

            // Evolve and get the new population
            pop.evolve();
            Chromosome[] newChromosomeArr = pop.getPopulation();

            assertEquals(80, (int) (pop.getCrossover() * 100));
            assertEquals(10, (int) (pop.getElitism() * 100));
            assertEquals(5, (int) (pop.getMutation() * 100));

            // Check if that the elitism took place.
            final int elitismCount = Math.round(1024 * 0.1f);
            int count = 0;
            for (int i = 0; i < oldChromosomeArr.length; i++) {
                    if (Arrays.binarySearch(newChromosomeArr, oldChromosomeArr[i]) >= 0) {
                            ++count;
                    }
            }
            
            assertTrue(count >= elitismCount);
            assertTrue(count < oldChromosomeArr.length);
    }
    
}
