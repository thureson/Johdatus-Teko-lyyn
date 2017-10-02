/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Tomppa
 */
public class NNB {
    private final List<Image> images;
    
    public NNB(List<Image> images){
        this.images = images;
    }
    
    double[] color(int targetChar, int oppositeChar){
        double[] weights = new double[28*28];
        
        for (int example = 5000; example < (int) images.size(); example++) {

            // choosing only from the + and - classes
            if (images.get(example).characterClass != targetChar
                    && images.get(example).characterClass != oppositeChar) {
                continue;
            }
            
            for (int i = 0; i < weights.length; i++){
                if (images.get(example).characterClass == targetChar){
                    if (i == weights.length){
                        weights[i] += images.get(example).vec[i];
                    } else {
                        weights[i] += images.get(example).vec[i+1];
                    }
                } else {
                    if (i == weights.length){
                        weights[i] -= images.get(example).vec[i];
                    } else {
                        weights[i] -= images.get(example).vec[i+1];
                    }
                }
                
                
            }
        }
        return weights;
    }
    
    double test(int targetChar, int oppositeChar) {
        int success = 0;
        int trials = 0;
        double[] weights = color(targetChar, oppositeChar);


        for (int example = 5000; example < (int) images.size(); example++) {

            // choosing only from the + and - classes
            if (images.get(example).characterClass != targetChar
                    && images.get(example).characterClass != oppositeChar) {
                continue;
            }

            // calculate z
            double z = 0.0;
            for (int j = 0; j < 28 * 28; j++) {
                z += images.get(example).vec[j] * weights[j];
            }

            // Is the classification correct=
            if ((z >= 0 && images.get(example).characterClass == targetChar)
                    || (z < 0 && images.get(example).characterClass == oppositeChar)) {
                success++;
            }
            trials++;
        }

        return (double) (trials - success) / trials;
    }
}
