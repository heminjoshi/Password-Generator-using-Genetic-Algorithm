/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.main;

import java.util.Random;

/**
 *
 * @author hemin
 */
public class Chromosome implements Comparable<Chromosome> {
    private final String gene;
    private final int fitness;
//    Genetic g = new Genetic();
    static String targetString = Genetic.getTargetString();
    private static char[] TARGET_GENE = targetString.toCharArray(); //should be  static. need to figure this one out.
//    private static final char[] TARGET_GENE = "Professor Robin Charles Hillyard loves Knuth and Sedgewick".toCharArray();
    private static final Random rand = new Random(System.currentTimeMillis());
    
    public Chromosome(String gene) {
	this.gene = gene;
	this.fitness = calculateFitness(gene);
    }
    
    public String getGene() {
        return gene;
    }

    public int getFitness() {
        return fitness;
    }
    
    @Override
    public int compareTo(Chromosome o) {
        if (fitness < o.fitness) {
            return -1;
	}
        else if (fitness > o.fitness) {
            return 1;
	}
	return 0;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Chromosome)) {
            return false;
	}
	Chromosome c = (Chromosome) o;
	return (gene.equals(c.gene) && fitness == c.fitness);
    }
    
    @Override
    public int hashCode() {		
	return new StringBuilder().append(gene).append(fitness).toString().hashCode();
    }

    public static Chromosome generateRandom() {
        char[] arr = new char[TARGET_GENE.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (rand.nextInt(90) + 32);
        }
        return new Chromosome(String.valueOf(arr));
    }
    
    private int calculateFitness(String gene) {
        int fitnessValue = 0;
	char[] arr  = gene.toCharArray();
	for (int i = 0; i < arr.length; i++) {
            fitnessValue += Math.abs(((int) arr[i]) - ((int) TARGET_GENE[i]));
	}
        return fitnessValue;
    }
    
    public Chromosome mutate() {
	char[] arr  = gene.toCharArray();
	int idx     = rand.nextInt(arr.length);
	int delta   = (rand.nextInt() % 90) + 32;
	arr[idx]    = (char) ((arr[idx] + delta) % 122);
	return new Chromosome(String.valueOf(arr));
    }

    public Chromosome[] mate(Chromosome parent) {
        // Convert the genes to arrays to make thing easier.
	char[] arr1  = gene.toCharArray();
	char[] arr2  = parent.gene.toCharArray();
	//Randomly select the pivot point
        int pivot    = rand.nextInt(arr1.length);
	char[] child1 = new char[gene.length()];
	char[] child2 = new char[gene.length()];
        //Generate First Child
	System.arraycopy(arr1, 0, child1, 0, pivot);
	System.arraycopy(arr2, pivot, child1, pivot, (child1.length - pivot));
        //Generate Second Child
	System.arraycopy(arr2, 0, child2, 0, pivot);
	System.arraycopy(arr1, pivot, child2, pivot, (child2.length - pivot));
        return new Chromosome[] { new Chromosome(String.valueOf(child1)), new Chromosome(String.valueOf(child2))}; 
    }
    
}
