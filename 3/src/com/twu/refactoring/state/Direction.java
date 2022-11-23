package com.twu.refactoring.state;

import java.util.HashMap;
import java.util.Map;

public class Direction {

    private static final Map<Character, Character> turnLeftMap = new HashMap<>();
    private static final Map<Character, Character> turnRightMap = new HashMap<>();

    private final char orientation;

    static {
        turnRightMap.put('N', 'E');
        turnRightMap.put('S', 'W');
        turnRightMap.put('E', 'N');
        turnRightMap.put('W', 'S');

        turnLeftMap.put('N', 'W');
        turnLeftMap.put('S', 'E');
        turnLeftMap.put('E', 'N');
        turnLeftMap.put('W', 'S');
    }

    public Direction(char orientation) {
        this.orientation = orientation;
    }

    public char getOrientation() {
        return orientation;
    }

    public Direction turnRight() {
        Character nextOrientation = dictionaryQuery(turnRightMap);
        return Direction.builder().orientation(nextOrientation).build();
    }

    public Direction turnLeft() {
        Character nextOrientation = dictionaryQuery(turnLeftMap);
        return Direction.builder().orientation(nextOrientation).build();
    }

    private Character dictionaryQuery(Map<Character, Character> dic) {
        return dic.get(this.orientation);
    }

    public static DirectionBuilder builder() {
        return new DirectionBuilder();
    }

    public static class DirectionBuilder {
        private Character orientation;

        DirectionBuilder() {
        }

        public DirectionBuilder orientation(Character orientation) {
            if (orientation == null) {
                throw new IllegalArgumentException();
            }
            this.orientation = orientation;
            return this;
        }

        public Direction build() {
            return new Direction(this.orientation);
        }

        @Override
        public String toString() {
            return "DirectionBuilder{" +
                    "orientation=" + orientation +
                    '}';
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        Direction temp = (Direction) obj;

        return this.orientation == temp.getOrientation();
    }

    @Override
    public int hashCode() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "orientation=" + orientation +
                '}';
    }
}
