/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.main;

/**
 *
 * @author hemin
 */
public class Genetic {
    final int seedPopulation = 1000;
    final int maxNoOfGenerations = 10000;
    final float crossoverRate = 0.5f;
    final float elitismRate = 0.1f;
    final float mutationRate = 0.03f;
    long startTime = System.currentTimeMillis();
    static String targetString ;

    public static String getTargetString() {
        return targetString;
    }
    
    public static void setTargetString(String string)
    {
        targetString = string;
    }

    String generateRandomPassword(String targetString) {
        String randomPassword = null;
        this.targetString = targetString;
        Population pop = new Population(seedPopulation, crossoverRate, elitismRate, mutationRate);
        int i = 0;
	Chromosome best = pop.getPopulation()[0];
        while ((i++ <= maxNoOfGenerations) && (best.getFitness() != 0)) {
            if(i == 5)
                randomPassword = best.getGene();
            System.out.println("Generation " + i + ": " + best.getGene() + " Fitness " + best.getFitness());
            pop.evolve();
            best = pop.getPopulation()[0];
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Generation " + i + ": " + best.getGene() + " Fitness " + best.getFitness());
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
        
        return randomPassword;
    }
}
