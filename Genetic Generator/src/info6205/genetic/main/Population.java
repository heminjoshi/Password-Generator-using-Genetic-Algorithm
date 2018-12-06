/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info6205.genetic.main;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author hemin
 */
public class Population {
    private static final int TOURNAMENT_SIZE = 100;
    private static final Random rand = new Random(System.currentTimeMillis());
    private float elitism;
    private float mutation;
    private float crossover;
    private Chromosome[] populationArray;
    
    public Population(int size, float crossover, float elitism, float mutation) {
        this.crossover = crossover;
        this.elitism = elitism;
        this.mutation = mutation;
        this.populationArray = new Chromosome[size];
        for (int i = 0; i < size; i++) {
            this.populationArray[i] = Chromosome.generateRandom();
        }
        Arrays.sort(this.populationArray);
    }
    
    public void evolve() {
        Chromosome[] buffer = new Chromosome[populationArray.length];
        int populationCopy = Math.round(populationArray.length * elitism);
        System.arraycopy(populationArray, 0, buffer, 0, populationCopy);
        while (populationCopy < buffer.length) { 
            if (rand.nextFloat() <= crossover) {
                Chromosome[] parents = selectParents();
                Chromosome[] children = parents[0].mate(parents[1]);
                //If the first child should be mutated
                if (rand.nextFloat() <= mutation) {
                    buffer[populationCopy++] = children[0].mutate();
                } 
                else {
                    buffer[populationCopy++] = children[0];
                }
                //If the second child should be mutated
                if (populationCopy < buffer.length) {
                    if (rand.nextFloat() <= mutation) {
                        buffer[populationCopy] = children[1].mutate();
                    } 
                    else {
                        buffer[populationCopy] = children[1];
                    }
                }
            } 
            else { 
                // No crossover. Check if mutation should occur.
                if (rand.nextFloat() <= mutation) {
                    buffer[populationCopy] = populationArray[populationCopy].mutate();
                } 
                else {
                    buffer[populationCopy] = populationArray[populationCopy];
                }
            }
            ++populationCopy;
        }
        //Sorting on the basis of fitness
	Arrays.sort(buffer);	
	populationArray = buffer;
    }
    
    public Chromosome[] getPopulation() {
	Chromosome[] arr = new Chromosome[populationArray.length];
	System.arraycopy(populationArray, 0, arr, 0, populationArray.length);
	return arr;
    }
    
    public float getElitism() {
        return elitism;
    }
    
    public float getCrossover() {
	return crossover;
    }

    public float getMutation() {
	return mutation;
    }

    private Chromosome[] selectParents() {
	Chromosome[] parents = new Chromosome[2];
	//On the basis of tournament selection, select two parents randomly
	for (int i = 0; i < 2; i++) {
            parents[i] = populationArray[rand.nextInt(populationArray.length)];
            for (int j = 0; j < TOURNAMENT_SIZE; j++) {
		int randomLength = rand.nextInt(populationArray.length);
		if (populationArray[randomLength].compareTo(parents[i]) < 0) {
                    parents[i] = populationArray[randomLength];
		}
            }
	}
	return parents;
    }
}