package org.example;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Random {
    private static final java.util.Random random = new java.util.Random();

    public static boolean isDeprecated() {
        return random.isDeprecated();
    }

    public static DoubleStream doubles() {
        return random.doubles();
    }

    public static DoubleStream doubles(double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(randomNumberOrigin, randomNumberBound);
    }

    public static DoubleStream doubles(long streamSize) {
        return random.doubles(streamSize);
    }

    public static DoubleStream doubles(long streamSize, double randomNumberOrigin, double randomNumberBound) {
        return random.doubles(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public static IntStream ints() {
        return random.ints();
    }

    public static IntStream ints(int randomNumberOrigin, int randomNumberBound) {
        return random.ints(randomNumberOrigin, randomNumberBound);
    }

    public static IntStream ints(long streamSize) {
        return random.ints(streamSize);
    }

    public static IntStream ints(long streamSize, int randomNumberOrigin, int randomNumberBound) {
        return random.ints(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public static LongStream longs() {
        return random.longs();
    }

    public static LongStream longs(long randomNumberOrigin, long randomNumberBound) {
        return random.longs(randomNumberOrigin, randomNumberBound);
    }

    public static LongStream longs(long streamSize) {
        return random.longs(streamSize);
    }

    public static LongStream longs(long streamSize, long randomNumberOrigin, long randomNumberBound) {
        return random.longs(streamSize, randomNumberOrigin, randomNumberBound);
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static void nextBytes(byte[] bytes) {
        random.nextBytes(bytes);
    }

    public static float nextFloat() {
        return random.nextFloat();
    }

    public static float nextFloat(float bound) {
        return random.nextFloat(bound);
    }

    public static float nextFloat(float origin, float bound) {
        return random.nextFloat(origin, bound);
    }

    public static double nextDouble() {
        return random.nextDouble();
    }

    public static double nextDouble(double bound) {
        return random.nextDouble(bound);
    }

    public static double nextDouble(double origin, double bound) {
        return random.nextDouble(origin, bound);
    }

    public static int nextInt() {
        return random.nextInt();
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public static int nextInt(int origin, int bound) {
        return random.nextInt(origin, bound);
    }

    public static long nextLong() {
        return 0;
    }

    public static long nextLong(long bound) {
        return random.nextLong(bound);
    }

    public static long nextLong(long origin, long bound) {
        return random.nextLong(origin, bound);
    }

    public static double nextGaussian() {
        return random.nextGaussian();
    }

    public static double nextGaussian(double mean, double stddev) {
        return random.nextGaussian(mean, stddev);
    }

    public static double nextExponential() {
        return random.nextExponential();
    }
}
