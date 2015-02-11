/*
 * This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
 * Copyright (c) 1997 by David Flanagan
 * This example is provided WITHOUT ANY WARRANTY either expressed or implied.
 * You may study, use, modify, and distribute it for non-commercial purposes.
 * For any commercial use, see http://www.davidflanagan.com/javaexamples
 */

import java.util.Date;

/**
 * This class defines methods for computing pseudo-random numbers, and it defines
 * the state variable that needs to be maintained for use by those methods.
 */
public class Randomizer {
  static final int MODULUS_CONSTANT = 233280;
  static final int MULTIPLIER_CONSTANT = 9301;
  static final int INCREMENT_CONSTANT = 49297;

  // The state variable maintained by each Randomizer instance
  long seed = 1;

  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   * @param seed The input seed to create a randomized number.
   */
  public Randomizer(long seed) {
    this.seed = seed;
  }

  /**
   * This method computes a pseudo-random number between 0 and 1 using a very
   * simple algorithm.  Math.random() and java.util.Random are actually a lot
   * better at computing randomness.
   * @return The computed float.
   */
  public float randomFloat() {
    seed = (seed * MULTIPLIER_CONSTANT + INCREMENT_CONSTANT) % MODULUS_CONSTANT;
    return ((float) seed) / ((float) MODULUS_CONSTANT);
  }

  /**
   * This method computes a pseudo-random integer between 0 and specified
   * maximum.  It uses randomFloat() above.
   * @param max The maximum input.
   * @return The rounded int.
   */
  public int randomInt(int max) {
      return Math.round(max * randomFloat());
  }

  /**
   * Prints 10 random floats between the ranges 0 and 100.
   * @param args The commandline arguments.
   */
  public static void main(String[] args) {
    Date date = new java.util.Date();
    long inputSeed = date.getTime();
    Randomizer randomizer = new Randomizer(inputSeed);
    for (int i = 0; i < 10; i++) {
      System.out.println(randomizer.randomInt(100));
    }
  }
}