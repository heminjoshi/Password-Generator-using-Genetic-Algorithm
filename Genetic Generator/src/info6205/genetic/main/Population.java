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
    private Chromosome[] popArr;
    
    public Population(int size, float crossoverRatio, float elitismRatio, float mutationRatio) {
        this.crossover = crossoverRatio;
        this.elitism = elitismRatio;
        this.mutation = mutationRatio;
        this.popArr = new Chromosome[size];
        for (int i = 0; i < size; i++) {
            this.popArr[i] = Chromosome.generateRandom();
        }
        Arrays.sort(this.popArr);
    }
    
    public void evolve() {
        Chromosome[] buffer = new Chromosome[popArr.length];
        int populationCopy = Math.round(popArr.length * elitism);
        System.arraycopy(popArr, 0, buffer, 0, populationCopy);
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
                    buffer[populationCopy] = popArr[populationCopy].mutate();
                } 
                else {
                    buffer[populationCopy] = popArr[populationCopy];
                }
            }
            ++populationCopy;
        }
        //Sorting on the basis of fitness
	Arrays.sort(buffer);	
	popArr = buffer;
    }
    
    public Chromosome[] getPopulation() {
	Chromosome[] arr = new Chromosome[popArr.length];
	System.arraycopy(popArr, 0, arr, 0, popArr.length);
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
	//On the basis of tournament selection, selecting two parents randomly
	for (int i = 0; i < 2; i++) {
            parents[i] = popArr[rand.nextInt(popArr.length)];
            for (int j = 0; j < TOURNAMENT_SIZE; j++) {
		int randomLength = rand.nextInt(popArr.length);
		if (popArr[randomLength].compareTo(parents[i]) < 0) {
                    parents[i] = popArr[randomLength];
		}
            }
	}
	return parents;
    }
}